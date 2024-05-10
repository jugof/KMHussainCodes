using System.Text.Json;

namespace Tourism;

public static class SiteStore
{
    public static bool Save(this Site site)
    {
        string doc = site.Title + ".store";
        try
        {
            using var output = new FileStream(doc, FileMode.Create);
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
            using var input = new FileStream(doc, FileMode.Open);
            return JsonSerializer.Deserialize<Site>(input);
        }
        catch
        {
            return new Site(name);
        }
    }
}
