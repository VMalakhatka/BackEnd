public class ComputerThread implements Runnable{
    Thread t;
    GameWindow pl;
    ResultDispl dp;
    ComputerThread(GameWindow pl, ResultDispl dp){
        t= new Thread(this, "Player - "+pl.clrPlayer );
       // dp.addCount("Player - "+pl.clrPlayer + "  поток ");
       // System.out.println("Поток запустили Player - "+pl.clrPlayer );
        this.pl=pl;
        this.dp=dp;
        t.start();
    }
    public void run(){
        while(true) {
            try {
                Thread.sleep(2500);
         //       System.out.println("Player - "+pl.clrPlayer + pl.Who);
         //   dp.addCount("Player - "+pl.clrPlayer + "  поток ");

                if (pl.Who == "Computer") {
                    pl.ChbGr.setSelectedCheckbox(pl.Cb[(int) (Math.random() * 3-0.0001)]);
                }
            }catch (InterruptedException e){
                System.out.println("\n Прерывание потока Компьютер \n");
            }
        }
    }

    public void close() throws Exception {
        t.interrupt();
        throw new Exception("Thread close " + pl.Who);
    }
}
