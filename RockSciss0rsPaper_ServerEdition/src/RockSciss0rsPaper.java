import java.awt.*;

public class RockSciss0rsPaper {
    public static void main(String[] args) {
        GameWindow yellowPlayer = new GameWindow(50,100, 400,350, Color.YELLOW);
        GameWindow cyanPlayer = new GameWindow(600,100, 400,350, Color.CYAN);
       //  ResultDispl resultDispl_now = new ResultDispl(50,1000,350,700,Color.GRAY,yellowPlayer,cyanPlayer);
        ComputerThread comp1 = new ComputerThread(yellowPlayer,resultDispl_now);
        ComputerThread comp2 = new ComputerThread(cyanPlayer,resultDispl_now);
        try {
            while (true) {
                resultDispl_now.addResult();
                Thread.sleep(1000);
                resultDispl_now.addCount(" u  ");
                Thread.sleep(1000);
                resultDispl_now.addCount("e  ");
                Thread.sleep(1000);
                resultDispl_now.addCount("fa \n  ");
            }
        }catch(InterruptedException e){ // Обработка исключения "прерывание потока"
            resultDispl_now.addCount("\n Поток завершен! \n");}
    }
}
