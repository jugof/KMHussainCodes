package tourism;

import java.io.Serializable;
import java.util.Date;

public class Visitor implements Serializable {
    
    String name;

    private int visitCount;

    private Date lastVisit;
    
    //a field declared with 'transient' modifier 
    //is ignored during serialization
    private transient long ticketNumber;

    public Visitor(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getVisitCount() {
        return visitCount;
    }

    public Date getLastVisit() {
        return lastVisit;
    }

    public long getTicketNumber() {
        return ticketNumber;
    }

    public void visit() {
        visitCount += 1;
        lastVisit = new Date();
        ticketNumber = System.currentTimeMillis() % 100000000;
    }
}
