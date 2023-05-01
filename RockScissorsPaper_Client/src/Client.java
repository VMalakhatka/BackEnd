import java.io.*;
import java.net.Socket;

public class Client implements Cloneable {
    public BufferedWriter writer;
    public BufferedReader reader;
    public Socket client;
    public String answer="E";
    public Client(String ip, int port){
        try {
            this.client=new Socket(ip, port);
            System.out.println("Client connect ip " + ip+" port "+port);
            reader=new BufferedReader(new InputStreamReader(client.getInputStream()));
            writer=new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
        } catch (IOException e) {
            System.out.println("Server not answer"+e);
            this.close();
        }
    }
//    String whatchNow(){
//       // writeLine("?");
//        return readLine();
//    }
    public void writeLine(String message) {
        try {
            writer.write(message);
            writer.newLine();
            writer.flush();
        } catch (IOException e) {
            throw  new RuntimeException(e);
        }

    }
    public String readLine() {
        try {
            return reader.readLine();
        } catch (IOException e) {
            throw  new RuntimeException(e);
        }
    }
    public void close(){
        try {
            writer.close();
            reader.close();
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

