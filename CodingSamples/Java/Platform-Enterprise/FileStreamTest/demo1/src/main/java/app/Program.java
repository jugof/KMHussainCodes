package app;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Program {
    
    public static void main(String[] args) throws Exception {
        var input = new FileInputStream(args[0]);
        var output = new FileOutputStream(args[1]);
        byte[] buffer = new byte[80];
        while(input.available() > 0){
            int n = input.read(buffer, 0, buffer.length);
            Transformer.transform(buffer, n);
            output.write(buffer, 0, n);
        }
        output.close();
        input.close();
    }
}

