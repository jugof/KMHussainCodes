package app.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class SalesAgentController {
    
    //By default browser allows a script to render/submit data
    //from/to the endpoint from which this scripts originates, 
    //unless the endpoint that owns the data sends headers to 
    //indicate that it allows cross origin resource sharing (CORS)
    @CrossOrigin
    @GetMapping("/api/sales/{id}")
    public ResponseEntity<List<OrderResource>> readOrders(@PathVariable("id") String customerId, SalesAgentModel model) {
        var orders = new ArrayList<OrderResource>();
        model.loadOrders(customerId, orders);
        return orders.size() > 0 
            ? ResponseEntity.ok(orders) 
            : ResponseEntity.notFound().build();
    }

    @PostMapping("/api/sales")
    public ResponseEntity<OrderResource> createOrder(@RequestBody OrderResource order, SalesAgentModel model) {
        try{
            model.saveOrder(order);
            return ResponseEntity.ok(order);
        }catch(Exception e){
            Logger.getLogger(getClass().getName()).severe(e.toString());
            return ResponseEntity.internalServerError().build();
        }
    }
}
