namespace DemoApp;

//a reference type immutable record
record Item(string Name, string Brand);

//a value-type record has settable properties by default 
//unless the record is declared with 'readonly' keyword
readonly record struct Customer(string Id, decimal Purchase, int Rating);

class Shop
{
    public static Item[] GetItems()
    {
        return
        [
            new Item("cpu", "intel"),
            new Item("ddr", "samsung"),
            new Item("ssd", "seagate"),
            new Item("cpu", "amd"),
            new Item("keyboard", "logitech"),
            new Item("ssd", "samsung"),
            new Item("mouse", "microsoft"),
            new Item("monitor", "samsung"),
            new Item("mouse", "logitech"),
            new Item("motherboard", "intel")
        ];
    }

    public static ICollection<Customer> GetCustomers()
    {
        return
        [
            new Customer("Pranjali", 42000, 3),
            new Customer("Sagar", 26000, 2),
            new Customer("Rushikesh", 68000, 4),
            new Customer("Anushka", 79000, 5),
            new Customer("Varun", 53000, 3),
            new Customer("Mahesh", 19000, 1),
            new Customer("Tejal", 92000, 4),
            new Customer("Bhagyashri", 115000, 5),
            new Customer("Juned", 84000, 4),
            new Customer("Ketan", 74000, 2),
            new Customer("Chetan", 9000, 1)
        ];

    }
}