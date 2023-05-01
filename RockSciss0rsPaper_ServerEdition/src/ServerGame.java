import javax.lang.model.type.NullType;
import java.awt.*;
import java.io.IOException;
import java.net.ServerSocket;

public class ServerGame implements Runnable{
    private static ServerSocket server;
    private Client client1;
    private Client client2;

    Color colPl1= Color.YELLOW;
    Color colPl2=Color.CYAN;

    public ServerGame(int port){
        try {
            if( server == null) {
                server = new ServerSocket(port);
                System.out.println("Open server port " + port);
            }else {
                System.out.println("Server allredy open \n Wait new client");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            client1=new Client(server.accept());
            System.out.println("Open YELLOW client");
            client1.Who="Yellow";
        //    System.out.println(colPl1.toString());
            client1.writeLine( Integer.toString( colPl1.getRGB()));
            client1.whatchNow();// read Status
            System.out.println(client1.ChbGr);

            client2=new Client(server.accept());
            System.out.println("Open CYAN client");
            client1.Who="Cyan";
            client2.writeLine( Integer.toString( colPl2.getRGB()));
            client2.whatchNow();// read Status
            System.out.println(client2.ChbGr);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        System.out.println("Run Thread -- -- ");
        ResultDispl resultDispl_now = new ResultDispl(50,1000,350,700, Color.GRAY,client1,client2);
        try {
            while (true) {
                resultDispl_now.addResult();
                Thread.sleep(2000);
                client1.writeLine("U"); client2.writeLine("U");
                resultDispl_now.addCount(" U  ");
                System.out.println("Transfer U --- ");
                Thread.sleep(2000);
                client1.writeLine("E"); client2.writeLine("E");
                client1.whatchNow(); client2.whatchNow();
                resultDispl_now.addCount("E  ");
                Thread.sleep(2000);
                client1.writeLine("FA"); client2.writeLine("FA");
                client1.writeLine(client2.ChbGr.substring(0));
                client2.writeLine(client1.ChbGr.substring(0));
                resultDispl_now.addCount("FA \n  ");
            }
        }catch(InterruptedException e){ // Обработка исключения "прерывание потока"
            resultDispl_now.addCount("\n Поток завершен! \n");}
    }
}
