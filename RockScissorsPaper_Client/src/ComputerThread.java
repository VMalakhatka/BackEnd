public class ComputerThread implements Runnable{
    Thread t;
    String prevAnswer="E";
    GameWindow pl;
    Client client;
    ComputerThread(GameWindow pl, Client client){
        t= new Thread(this, "Player - "+pl.clrPlayer );
        this.pl=pl;
        this.client=client;
    //    System.out.println("First Who Yellow --  " + pl.Who);
        client.writeLine(pl.ChbGr.getSelectedCheckbox().getLabel());
        System.out.println("First Who Yellow --  " + pl.ChbGr.getSelectedCheckbox().getLabel());
        pl.pl2="Wait"; // We not know who second player
        t.start();
    }
    public void run(){
        StringBuilder answer=new StringBuilder("New");
        while(true) {
            try {
                Thread.sleep(450);
                 System.out.println("In Thread --  " + client.answer+"    ----RR----" + prevAnswer);
                if (pl.Who == "Computer" & client.answer.equals("U") & !prevAnswer.equals("U")) {
                    pl.ChbGr.setSelectedCheckbox(pl.Cb[(int) (Math.random() * 3-0.0001)]);
                }
            }catch (InterruptedException e){
                System.out.println("\n Прерывание потока Компьютер \n");
            }
            prevAnswer=client.answer;
        }
    }

    public void close() throws Exception {
        t.interrupt();
        throw new Exception("Thread close " + pl.Who);
    }
}
