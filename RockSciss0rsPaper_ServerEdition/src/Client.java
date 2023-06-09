import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Client implements Closeable {
    public BufferedWriter writer;
    public StringBuffer ChbGr= new StringBuffer("New"); // curent Scissors Rock Paper
    public String Who;
    public BufferedReader reader;
    private Socket client;
    public Client(Socket client){
        this.client=client;
        try {
            reader=new BufferedReader(new InputStreamReader(client.getInputStream()));
            writer=new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
//        writeLine("Who");
//        Who=readLine();
//        whatchNow();
    }
    void whatchNow(){
        ChbGr.delete(0,ChbGr.length()).append(readLine());
    }
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
