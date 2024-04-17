import java.util.ArrayList;
import java.util.Collection;

class Shop {

    public static Item[] items() {
        return new Item[] {
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
        };
    }

    public static Collection<Customer> customers() {
        var entries = new ArrayList<Customer>();
        entries.add(new Customer("Pranjali", 42000, 3));
        entries.add(new Customer("Sagar", 26000, 2));
        entries.add(new Customer("Rushikesh", 68000, 4));
        entries.add(new Customer("Anushka", 79000, 5));
        entries.add(new Customer("Varun", 53000, 3));
        entries.add(new Customer("Mahesh", 19000, 1));
        entries.add(new Customer("Tejal", 92000, 4));
        entries.add(new Customer("Bhagyashri", 115000, 5));
        entries.add(new Customer("Juned", 84000, 4));
        entries.add(new Customer("Ketan", 74000, 2));
        entries.add(new Customer("Chetan", 9000, 1));
        return entries;
    }
}
