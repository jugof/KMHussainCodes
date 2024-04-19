package app;

import java.util.logging.Level;
import java.util.logging.Logger;

import app.data.Booking;
import app.data.Guest;
import app.data.Visitor;
import jakarta.persistence.Persistence;

public class Program {
    
    public static void main(String[] args) throws Exception {
        Logger.getLogger("org.hibernate").setLevel(Level.SEVERE);
        var em = Persistence.createEntityManagerFactory("app.data")
                    .createEntityManager();
        if(args.length > 0){
            var guest = em.find(Guest.class, args[0]);
            if(guest == null)
                guest = new Guest(args[0]);
            guest.getBookings().add(new Booking(guest));
            var tx = em.getTransaction();
            tx.begin();
            em.persist(guest);
            tx.commit();
        }else{
            var query = em.createQuery("SELECT g FROM Guest g WHERE LENGTH(g.name) > 3", Guest.class);
            for(var guest : query.getResultList()){
                var visitor = Visitor.fromGuest(guest);
                System.out.printf("%s\t%d\t%s\t%s%n", 
                    visitor.givenName(), 
                    visitor.visitCount(), 
                    visitor.lastVisit(), 
                    visitor.starRating());
            }


        }
        em.close();
    }
}

