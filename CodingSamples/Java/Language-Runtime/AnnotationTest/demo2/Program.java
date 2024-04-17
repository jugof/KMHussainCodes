import hosting.ServiceContainer;
import services.CasualGreeter;
import services.FormalGreeter;
import services.Greeter;

class Program {

    public static void main(String[] args) throws Exception {
        Greeter fg = ServiceContainer.getService(Greeter.class, FormalGreeter.class);
        System.out.println(fg.greet("Jack"));
        System.out.println(fg.greet("Jill"));
        System.out.printf("Used %s%n", fg.getClass());
        System.out.println("-------------------------------------------------");
        Greeter cg = ServiceContainer.getService(Greeter.class, CasualGreeter.class);
        System.out.println(cg.greet("Jane"));
        System.out.println(cg.greet("John"));
        System.out.printf("Used %s%n", cg.getClass());
    }
}