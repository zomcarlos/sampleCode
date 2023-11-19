import java.io.*;
import java.net.*; 

public class tcpClient {

    public static void main(String argv[]) throws Exception 
    { 
        String string;
        String modifiedString;

        BufferedReader fromUser = new BufferedReader(new InputStreamReader(System.in));
        Socket clientSocket = new Socket("localhost", 6789);
        DataOutputStream toServer = new DataOutputStream(clientSocket.getOutputStream());
        BufferedReader fromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        string = fromUser.readLine();
        toServer.writeBytes(string + '\n');
        modifiedString = fromServer.readLine();
        System.out.println("From server: " + modifiedString);
        clientSocket.close();
    }
}
