import java.awt.*;

public class RockScissorsPaper_server {

    public static void main(String[] args) {
        while (true) {
            ServerGame serverGame = new ServerGame(Integer.parseInt(args[0]));
            new Thread(serverGame).start();
        }
    }
}
