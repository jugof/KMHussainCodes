using DemoApp;

Console.Write("Item Name: ");
string item = Console.ReadLine();
var info = ShopHelper.FetchItemInfoTcp(item, args[0], 4000);
if(info.Stock > 0)
{
    Console.Write("Quantity : ");
    int quantity = int.Parse(Console.ReadLine());
    if(quantity <= info.Stock)
        Console.WriteLine("Total Payment: {0:0.00}", 1.08 * quantity * info.Price);
    else
        Console.WriteLine("Item out of stock!");
}
else
{
    Console.WriteLine("Item not available!");
}