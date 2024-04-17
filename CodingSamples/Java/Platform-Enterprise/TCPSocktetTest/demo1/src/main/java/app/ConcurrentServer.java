package app;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Properties;

class ConcurrentServer {
    
    private static Properties store = new Properties();

    public static void run(int port) throws IOException {
        try(var input = new FileInputStream("CitiTek.xml")){
            store.loadFromXML(input);
        }
        try(var listener = new ServerSocket(port)){
            for(;;){
                var client = listener.accept();
                //Thread.ofPlatform().start(() -> service(client));
                //a virtual thread can be resused to perform another task
                //while its original task is blocked by an i/o operation
                Thread.ofVirtual().start(() -> service(client));
            }
        }
    }

    private static void service(Socket client) {
        try(var connection = client){
            var receiver = connection.getInputStream();
            var sender = connection.getOutputStream();
            var reader = new BufferedReader(new InputStreamReader(receiver));
            var writer = new PrintWriter(sender, true); 
            writer.println("Welcome to CitiTek Computers.");
            String item = reader.readLine();
            String info = store.getProperty(item);
            if(info != null)
                writer.println(info);
            writer.close();
            reader.close();

        }catch(IOException e){}
    }
}
