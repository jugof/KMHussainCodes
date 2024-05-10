using System.Net;
using System.Net.Sockets;
using DemoApp.Services;

namespace DemoApp;

class Program
{
    static readonly ShopKeeper shop = new ();

    static void Main(string[] args)
    {
        var listener = new Socket(AddressFamily.InterNetwork, SocketType.Stream, ProtocolType.Tcp);
        listener.Bind(new IPEndPoint(IPAddress.Any, 4000));
        listener.Listen();
        while(true)
        {
            var client = listener.Accept();
            #if SIMPLE_SERVER
                CommunicateWith(client);
            #else
                new Thread(() => CommunicateWith(client)).Start();
            #endif
        }
    }

    static void CommunicateWith(Socket connection)
    {
        connection.ReceiveTimeout = 60000;
        try
        {
            using var remote = new NetworkStream(connection);
            using var reader = new StreamReader(remote);
            using var writer = new StreamWriter(remote){ AutoFlush = true };
            writer.WriteLine("Welcome to CitiTek Computers.");
            string item = reader.ReadLine();
            var info = shop.GetItemInfo(item);
            if(info is not null)
                writer.WriteLine(info);
        }
        catch {}
        connection.Close();
    }
}
