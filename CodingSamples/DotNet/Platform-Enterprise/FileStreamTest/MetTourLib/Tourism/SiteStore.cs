using System.IO.Compression;
using System.Text.Json;

namespace Tourism;

public static class SiteStore
{
    public static bool Save(this Site site)
    {
        string doc = site.Title + ".store";
        try
        {
            using var output = new DeflateStream(new FileStream(doc, FileMode.Create), CompressionMode.Compress);
            JsonSerializer.Serialize(output, site);
            return true;
        }
        catch
        {
            return false;
        }
    }

    public static Site Load(string name)
    {
        string doc = name + ".store";
        try
        {
            using var input = new DeflateStream(new FileStream(doc, FileMode.Open), CompressionMode.Decompress);
            return JsonSerializer.Deserialize<Site>(input);
        }
        catch
        {
            return new Site(name);
        }
    }
}
