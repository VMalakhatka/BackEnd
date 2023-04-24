import java.awt.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerGame implements Runnable{
    private ServerSocket server;
    private Client client1;
    private Client client2;

    public ServerGame(){
        try {
            server=new ServerSocket(8000);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            client1=new Client(server.accept());
            client2=new Client(server.accept());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        ResultDispl resultDispl_now = new ResultDispl(50,1000,350,700, Color.GRAY,client1,client2);
        try {
            while (true) {
                resultDispl_now.addResult();
                Thread.sleep(1000);
                client1.writeLine("u");
                client2.writeLine("u");
                resultDispl_now.addCount(" u  ");
                Thread.sleep(1000);
                client1.writeLine("e");
                client2.writeLine("e");
                resultDispl_now.addCount("e  ");
                Thread.sleep(1000);
                client1.whatchNow();
                client2.whatchNow();
                client1.writeLine(client2.ChbGr);
                client2.writeLine(client1.ChbGr);
                resultDispl_now.addCount("fa \n  ");
            }
        }catch(InterruptedException e){ // Обработка исключения "прерывание потока"
            resultDispl_now.addCount("\n Поток завершен! \n");}
    }
}
