package app.components;

import java.util.Set;
import java.util.TreeSet;

public class GreeterBean implements java.io.Serializable {
    
    private String person;

    private String period;

    private int count;

    private static Set<String> people = new TreeSet<>();

    public GreeterBean(String person, String period) {
        this.person = person;
        this.period = period;
    }

    public GreeterBean() {}

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public String getGreetingMessage() {
        if(person == null)
            return "Welcome Visitor";
        count += 1;
        people.add(person);
        return String.format("Good %s %s", period, person);
    }

    public int getGreetCount() {
        return count;
    }

    public Iterable<String> getPeople() {
        return people;
    }
}
