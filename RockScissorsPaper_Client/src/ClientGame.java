import java.awt.*;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ClientGame{
    Client conect;
   //  String answer;
    GameWindow window;
    String partner;
    ResultDispl resultDispl;


    public ClientGame(String ip, int port) {
        //  int x,y,H,W;
        Color color;
        conect = new Client(ip, port);
        String temp = conect.readLine();
        System.out.println("RECIVE COD COLOR FROM SERVER :   " + temp);
        color = new Color(Integer.parseInt(temp));
        System.out.println("From server color : " + color);
        window = new GameWindow(50, 100, 300, 250, color);
        resultDispl = new ResultDispl(30, 400, 300, 700, Color.GRAY, window);
        new ComputerThread(window, conect);
        System.out.println("Wait for  answer -  ");
        while (true) {
            conect.answer=conect.readLine();
          //  System.out.println("Receive ansver - "+ conect.answer);
            switch (conect.answer) {
                case "U":
                    break;
                case "E":
                    conect.writeLine(window.ChbGr.getSelectedCheckbox().getLabel());
                    break;
                case "FA":
                    window.pl2 = conect.readLine();
                    resultDispl.addResult();
                    break;
                default:
                    throw
                            new IllegalStateException("Unexpected value: " + conect.answer.substring(0));
            }

        }
    }

}
