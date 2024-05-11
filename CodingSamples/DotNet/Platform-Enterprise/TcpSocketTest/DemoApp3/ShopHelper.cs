using System.Net.Sockets;

namespace DemoApp;

class ShopHelper
{
    public static ItemInfo FetchItemInfoTcp(string name, string host, int port)
    {
        using var client = new TcpClient(host, port);
        using var remote = client.GetStream();
        using var reader = new StreamReader(remote);
        using var writer = new StreamWriter(remote);
        Console.WriteLine(reader.ReadLine());
        writer.WriteLine(name);
        writer.Flush();
        string message = reader.ReadLine();
        if(message != null)
            return ItemInfo.Parse(message);
        return new ItemInfo();

    }
}