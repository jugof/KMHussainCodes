package app.components;

import java.util.HashMap;
import java.util.Map;

public class NamedCounter implements Counter {

    private Map<String, Integer> store = new HashMap<>();

    public synchronized int countNext(String name) {
        int count = store.getOrDefault(name, 0);
        store.put(name, ++count);
        return count;
    }
    
}
