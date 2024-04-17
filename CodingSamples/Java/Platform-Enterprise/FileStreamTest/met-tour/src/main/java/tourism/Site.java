package tourism;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Site implements Serializable {
    
    String title;

    private List<Visitor> visitors;

    public Site(String title) {
        this.title = title;
        visitors = new ArrayList<>();
    }

    public String getTitle() {
        return title;
    }

    public List<Visitor> getVisitors() {
        return visitors;
    }

    public Visitor getVisitor(String name) {
        return visitors.stream()
                .filter(v -> v.name.equals(name))
                .findFirst()
                .orElseGet(() -> {
                    var visitor = new Visitor(name);
                    visitors.add(visitor);
                    return visitor;
                });
    }

    public void persist() {
        SiteStore.save(this);
    }
}
