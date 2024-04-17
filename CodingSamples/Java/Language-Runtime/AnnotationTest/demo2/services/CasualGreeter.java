package services;

import hosting.OnePerCall;

@OnePerCall
public class CasualGreeter implements Greeter {
    
    public CasualGreeter() {
        System.out.println("CasualGreeter activated.");
    }

    public String greet(String person) {
        return "Hi " + person;
    }
}
