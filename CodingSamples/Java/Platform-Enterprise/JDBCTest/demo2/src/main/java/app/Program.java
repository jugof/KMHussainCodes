package app;

import java.sql.Date;
import java.sql.DriverManager;

public class Program {
    
    public static void main(String[] args) throws Exception {
        String customerId = args[0].toUpperCase();
        int productNo = Integer.parseInt(args[1]);
        int quantity = Integer.parseInt(args[2]);
        Date today = new Date(System.currentTimeMillis());
        var con = DriverManager.getConnection("jdbc:oracle:thin:@//iitdac.met.edu/xe", "scott", "tiger");
        con.close();
    }
}

