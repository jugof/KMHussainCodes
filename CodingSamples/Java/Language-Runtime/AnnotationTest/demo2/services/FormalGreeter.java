package services;

public class FormalGreeter implements Greeter {
    
    public FormalGreeter() {
        System.out.println("FormalGreeter activated.");
    }

    public String greet(String person) {
        return "Hello " + person;
    }
}
