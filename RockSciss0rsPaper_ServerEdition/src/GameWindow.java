import java.awt.*;
import java.awt.event.*;
public class GameWindow extends Frame {
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
      setVisible(true);
    }
}
