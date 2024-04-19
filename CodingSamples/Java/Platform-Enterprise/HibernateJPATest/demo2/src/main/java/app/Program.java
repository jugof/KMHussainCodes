package app;

import java.util.logging.Level;
import java.util.logging.Logger;

import app.data.Product;
import jakarta.persistence.Persistence;

public class Program {
    
    public static void main(String[] args) throws Exception {
        Logger.getLogger("org.hibernate").setLevel(Level.SEVERE);
        var em = Persistence.createEntityManagerFactory("app.data")
                    .createEntityManager();
        if(args.length == 0){
            var query = em.createNamedQuery("findAvailableProducts", Product.class);
            query.setParameter("min_stock", 25)
                .getResultList()
                .stream()
                .forEach(e -> System.out.printf("%d\t%.2f\t%d%n", e.getProductNo(), e.getPrice(), e.getStock()));
        }else{
            int id = Integer.parseInt(args[0]);
            var product = em.find(Product.class, id);
            product.getOrders()
                .stream()
                .forEach(e -> System.out.printf("%s\t%d\t%s%n", e.getCustomerId(), e.getQuantity(), e.orderDateAsString()));
        }
        em.close();
                    
    }
}

