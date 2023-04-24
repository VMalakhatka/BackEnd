public class Socketor {
    public static void main(String[] args) {
        if(args.length<3){
            System.out.println("Usege \n" +
                    "java Socketor server 8000 /\n"+
                    "java Sockertor client 127.0.0.1 8000 45 35"
                    );
            return;
        }
        Socketor socketor=new Socketor();
        if (args[0].equals("server"))
            socketor.runServer(args[1],args[2]);
        if(args[0].equals("client"))
            socketor.runClient(args[1],args[2],args[3],args[4]);

    }

    private void runClient(String ip, String port, String a, String b) {
        Phone phone = new Phone(ip,port);
        phone.writeLine(a);
        phone.writeLine(b);
        String answer =  phone.readLine();
        System.out.println(answer);
        phone.close();
    }

    private void runServer(String port, String operation) {
        Phone phoneServer = new Phone(port);
        System.out.println("Started server with "+ operation +" on " + port);
        while (true) {
            Phone phone = new Phone(phoneServer);
            System.out.println("Client accepted");
            new Thread(() ->{
                //System.out.println("Server # " + "  Wating for client .....");
                // phone.accept();
                String a = phone.readLine();
                String b = phone.readLine();
                int result = calculate(operation, a ,b );
                String message = a +  " "+ operation+" "+ b + " = " +result;
                try { Thread.sleep(7000);} catch (InterruptedException e) {}
                System.out.println("Accepted: potok# " + "  Resalt  " +message);
                phone.writeLine(message);
                phone.close();
            }).start();
            if (Math.random()==0.0) break;
        }
        phoneServer.close();

    }
    private int calculate(String operation, String a, String b) {
        int x = Integer.parseInt(a);
        int y = Integer.parseInt(b);
        switch (operation){
            case "+" : return x+y;
            case "-" : return x-y;
            case "*" : return x*y;
            case "/" : return x/y;
            default: return x+y;
        }
    }


}
