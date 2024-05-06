using DemoApp;

if (args[0] == "items")
{
    Item[] items = Shop.GetItems();
    items.Where(i => i.Brand == args[1])
        .Select(i => i.Name)
        .PrintEach();
}
else if(args[0] == "customers")
{
    decimal min = decimal.Parse(args[1]);
    ICollection<Customer> customers = Shop.GetCustomers();
    customers.Add(new Customer("Xavier", 65000, 4));
    var selection = from c in customers
                    where c.Purchase >= min
                    orderby c.Id descending
                    select new //makes object of anonymous type 
                    {
                        Email = c.Id.ToLower() + "@cititek.com",
                        Review = new string('*', c.Rating),
                        Payment = 1.18m * c.Purchase
                    };
    foreach(var entry in selection)
        Console.WriteLine("{0, -24}{1, -8}{2, 12:0.00}", entry.Email, entry.Review, entry.Payment);
    Console.WriteLine();
    Console.WriteLine("Total Payment: {0:0.00}", selection.Sum(c => c.Payment));
}
