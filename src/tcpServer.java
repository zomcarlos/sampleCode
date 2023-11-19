import java.io.*;
import java.net.*; 

public class tcpServer {
  public static void main(String argv[ ]) throws Exception 
    { 
      String clientString;
      String upperString;

      ServerSocket receptionSocket = new ServerSocket(6789);
  
      while(true) { 
        Socket socketConexao = receptionSocket.accept();
        BufferedReader fromClient = new BufferedReader(new InputStreamReader(socketConexao.getInputStream()));
        DataOutputStream  toClient = new DataOutputStream(socketConexao.getOutputStream());
        clientString = fromClient.readLine();
        upperString = clientString.toUpperCase() + '\n';
        toClient.writeBytes(upperString);
        }
    } 
}
