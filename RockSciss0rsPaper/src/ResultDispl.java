import java.awt.*;

public class ResultDispl extends Frame{
    TextArea TA;
    GameWindow w1;
    GameWindow w2;
    ResultDispl(int x, int y, int H, int W, Color clrWindow, GameWindow w1,GameWindow w2){
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
        TA.append("\n Playr1 "+w1.Who+" Choose "+w1.ChbGr.getSelectedCheckbox().getLabel());
        TA.append("   Playr2 "+w2.Who+" Choose "+w2.ChbGr.getSelectedCheckbox().getLabel()+"\n");
    }

    void addCount(String say){
        TA.append(say);
    }
}
