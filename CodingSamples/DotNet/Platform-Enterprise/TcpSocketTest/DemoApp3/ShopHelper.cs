using System.Net;
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

    public static async Task<ItemInfo> FetchItemInfoHttp(string name)
    {
        using var client = new HttpClient();
        try
        {
            var response = await client.GetStringAsync($"http://iitdac.met.edu/shop/{name}");
            return ItemInfo.Parse(response);
        }
        catch(HttpRequestException ex) when (ex.StatusCode == HttpStatusCode.NotFound)
        {
            return default; 
        }
    }
}