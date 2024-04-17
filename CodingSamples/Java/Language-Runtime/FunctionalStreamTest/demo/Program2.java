import java.util.Arrays;
import java.util.Collection;

class Program {

    public static void main(String[] args) {
        if(args[0].equalsIgnoreCase("items")){
            Item[] items = Shop.items();
            Arrays.stream(items)
                .filter(i -> i.brand().equals(args[1]))
                .map(i -> i.name())
                .forEach(System.out::println);
        }else if(args[0].equalsIgnoreCase("customers")){
            double min = Double.parseDouble(args[1]);
            Collection<Customer> customers = Shop.customers();
            customers.add(new Customer("Xavier", 65000, 4));
            customers.stream()
                .filter(c -> c.purchase() >= min)
                .sorted()
                .map(c -> String.format("%-20s%8s", c.id(), "*".repeat(c.rating())))
                .forEach(System.out::println);
            double total = customers.stream()
                            .filter(c -> c.purchase() >= min)
                            .mapToDouble(c -> c.purchase())
                            .sum();
            System.out.printf("Total Purchase = %.2f%n", total);
        }
    }
}
