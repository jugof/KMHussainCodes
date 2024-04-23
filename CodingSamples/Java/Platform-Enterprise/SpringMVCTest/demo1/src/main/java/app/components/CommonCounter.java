package app.components;

import java.util.concurrent.atomic.AtomicInteger;

public class CommonCounter implements Counter {
    
    private AtomicInteger current = new AtomicInteger();

    public int countNext(String name) {
        return current.incrementAndGet();
    }

    
}
