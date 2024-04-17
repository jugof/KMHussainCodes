package app;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Program {
    
    public static void main(String[] args) throws Exception {
        var scanner = new Scanner(System.in);
        var connection = new Socket(args[0], 4000);
        var receiver = connection.getInputStream();
        var sender = connection.getOutputStream();
        var reader = new BufferedReader(new InputStreamReader(receiver));
        var writer = new PrintWriter(sender);
        System.out.println(reader.readLine());
        System.out.print("Item to buy: ");
        String item = scanner.next();
        writer.println(item);
        writer.flush();
        String msg = reader.readLine();
        if(msg != null){
            ItemInfo info = ItemInfo.parse(msg);
            System.out.print("Quantity: ");
            int quantity = scanner.nextInt();
            if(quantity <= info.stock()){
                System.out.printf("Total payment: %.2f%n", quantity * info.price());
            }else{
                System.out.println("Item out of stock!");
            }

        }else{
            System.out.println("Item not sold!");
        }
        writer.close();
        reader.close();
        connection.close();
        scanner.close();
    }
}

