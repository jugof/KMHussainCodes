package app;

import app.services.OrderManagerService;
import io.grpc.ServerBuilder;

public class Program {
    
    public static void main(String[] args) throws Exception {
        ServerBuilder.forPort(4030)
            .addService(new OrderManagerService())
            .build()
            .start()
            .awaitTermination();
    }
}

