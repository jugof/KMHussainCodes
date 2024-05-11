using System.Net;
using System.Net.Sockets;
using DemoApp.Services;

namespace DemoApp;

public class Worker(IConfiguration settings, ILogger<Worker> logging, ShopKeeper shop) : BackgroundService
{
    protected override async Task ExecuteAsync(CancellationToken stoppingToken)
    {
        int port = settings.GetValue<int>("Listener:Port", 4001);
        var listener = new TcpListener(IPAddress.Any, port);
        listener.Start();
        logging.LogInformation("Server started on port {p}", port);
        while (!stoppingToken.IsCancellationRequested)
        {
            var client = await listener.AcceptTcpClientAsync(stoppingToken);
            CommunicateWithAsync(client, stoppingToken);
        }
    }

    private async void CommunicateWithAsync(TcpClient connection, CancellationToken cancel)
    {
        try
        {
            using var remote = connection.GetStream();
            using var reader = new StreamReader(remote);
            using var writer = new StreamWriter(remote) { AutoFlush = true };
            await writer.WriteLineAsync("Welcome to CitiTek Computers");
            string item = await reader.ReadLineAsync(cancel);
            string info = shop.GetItemInfo(item);
            if(info is not null)
                await writer.WriteLineAsync(info);
        }
        catch {}
        connection.Close();
    }
}
