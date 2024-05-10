using System.Xml.Linq;

namespace DemoApp.Services;

public class ShopKeeper
{
    private Dictionary<string, string> store;

    public string GetItemInfo(string name)
    {
        store ??= XElement.Load("CitiTek.xml")
                        .Elements("item")
                        .ToDictionary(i => i.Attribute("id").Value, i => i.Value);
        return store.GetValueOrDefault(name);
    }
}