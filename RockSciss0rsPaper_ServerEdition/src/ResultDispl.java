import java.awt.*;

public class ResultDispl extends Frame{
    String[][] winResult = new String[][] {
            {" Ничья", " Победил 1й игрок"," Победил 2й игрок"},
            {" Победил 2й игрок"," Ничья"," Победил 1й игрок"},
            {" Победил 1й игрок"," Победил 2й игрок", " Ничья"}
    };
    int winer=0;
    TextArea TA;
    Client w1;
    Client w2;
    ResultDispl(int x, int y, int H, int W, Color clrWindow, Client w1,Client w2){
        this.w1=w1;
        this.w2=w2;
        setTitle("Результат игры");
        setBounds(x,y,W,H);
        setBackground(clrWindow);
        setLayout(null);
        Font fontGameWindow = new Font("Arial",Font.BOLD,18);
        setFont(fontGameWindow);
        TA=new TextArea(3000,30); // Шрифт для текстовой области:
        TA.setFont(new Font("Serif",Font.PLAIN,15));
// Размер и положение текстовой области:
        TA.setBounds(5,5,W-10,H -10);
// Область недоступна для редактирования:
        TA.setEditable(false);
                ;
// Добавление текстовой области на панель справки:
        add(TA);
        setVisible(true);
    }

    void addResult(){
        int pl1Index=0;
        int pl2Index=0;
        String pl1 = w1.ChbGr;
        String pl2 = w2.ChbGr;
        TA.append("\n Playr1 "+w1.Who+" Choose "+pl1);
        TA.append("   Playr2 "+w2.Who+" Choose "+pl2);
        if (pl1.equals("Rock")){
            pl1Index=0;
        } else if (pl1.equals("Scissors")) {
            pl1Index=1;
        }else pl1Index=2;
        if (pl2.equals("Rock")){
            pl2Index=0;
        } else if (pl2.equals("Scissors")) {
            pl2Index=1;
        }else pl2Index=2;
        TA.append(winResult[pl1Index][pl2Index]+"\n");
    }

    void addCount(String say){
        TA.append(say);
    }
}
