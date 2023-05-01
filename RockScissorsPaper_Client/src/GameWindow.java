import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class GameWindow extends Frame {
    //    static String[][] winResult = new String[][] {
//            {" Ничья", " Победил 1й игрок"," Победил 2й игрок"},
//            {" Победил 2й игрок"," Ничья"," Победил 1й игрок"},
//            {" Победил 1й игрок"," Победил 2й игрок", " Ничья"}
//    };
    int winer=0;
    TextArea TA;
    Client w1;
    String pl2="Rock"; //Payr 2
    public Color clrPlayer;
    public Choice ch;
    public CheckboxGroup ChbGr;
    public Checkbox[] Cb;
    public String Who="People";
    GameWindow(int x, int y, int H, int W, Color clrPalyer){
        this.clrPlayer=clrPalyer;
        setTitle("Игра Камень Ножницы Бумага");
        setBounds(x,y,W,H);
        setBackground(clrPalyer);
        setLayout(null);
        Font fontGameWindow = new Font("Arial",Font.BOLD,18);
        setFont(fontGameWindow);
        MyAdapter adapter = new MyAdapter();
        addWindowListener(adapter);
        ch= new Choice();
        ch.add("People");
        ch.add("Computer");
        ch.setBounds(15,40,getWidth()-25,30);
        ch.setBackground(Color.WHITE);
//      ChChanged chChanged = new ChChanged(this);
        ch.addItemListener(new ChChanged(this));
        add(ch);
        ChbGr = new CheckboxGroup();
        Cb = new Checkbox[3];
        Cb[0] = new Checkbox("Rock",ChbGr,true);
        Cb[1] = new Checkbox("Scissors",ChbGr,false);
        Cb[2] = new Checkbox("Paper",ChbGr,false);
        for(int i=0; i<3;i+=1){
            Cb[i].setBounds(15,80+i*25,getWidth()-10,30);
            add(Cb[i]);
        }


//      TA=new TextArea(500,300);
//      TA.setBounds(2,200,W-4,H-203);
//      TA.setBackground(Color.GREEN);
//      TA.setFont(new Font("Serif",Font.PLAIN,15));
//      TA.setEditable(false);
//      TA.setVisible(true);
//      add(TA);


        setVisible(true);
        //    TA.append("Result of Geme \n safeaffdasfd \n цукасцуксцууц");
//      setVisible(true);
    }
//    void addResult(){
//        int pl1Index=0;
//        int pl2Index=0;
//        String pl1 = Who;
//
//        TA.append("\n My choose "+" Choose "+pl1);
//        TA.append(" Playr2  choose"+" Choose "+pl2);
//        if (pl1.equals("Rock")){
//            pl1Index=0;
//        } else if (pl1.equals("Scissors")) {
//            pl1Index=1;
//        }else pl1Index=2;
//        if (pl2.equals("Rock")){
//            pl2Index=0;
//        } else if (pl2.equals("Scissors")) {
//            pl2Index=1;
//        }else pl2Index=2;
//        TA.append(winResult[pl1Index][pl2Index]+"\n");
//    }

//    void addCount(String say){
//        TA.append(say);
//    }
}
