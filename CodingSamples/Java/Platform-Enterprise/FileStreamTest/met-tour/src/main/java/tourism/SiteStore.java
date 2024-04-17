package tourism;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SiteStore {
    
    public static boolean save(Site site) {
        String doc = site.title + ".store";
        try(var serializer = new ObjectOutputStream(new FileOutputStream(doc))){
            serializer.writeObject(site);
            return true;
        }catch(Exception e){
            return false;
        }
    }

    public static Site load(String name) {
        String doc = name + ".store";
        try(var deserializer = new ObjectInputStream(new FileInputStream(doc))){
            return (Site)deserializer.readObject();
        }catch(Exception e){
            return new Site(name);
        }
    }
}
