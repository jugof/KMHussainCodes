namespace DemoApp;

readonly record struct ItemInfo(double Price, int Stock)
{
    public static ItemInfo Parse(string message)
    {
        string[] segments = message.Split(',');
        double price = double.Parse(segments[0][6 ..]);
        int stock = int.Parse(segments[1][6 ..]);
        return new ItemInfo(price, stock);
    }

}