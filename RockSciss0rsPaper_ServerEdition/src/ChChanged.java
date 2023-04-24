import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class ChChanged implements ItemListener {
 private GameWindow curentWindow;
 ChChanged(GameWindow curentwindow) {
  this.curentWindow = curentwindow;
 }
 public void itemStateChanged(ItemEvent ie){
  for (int i=0; i<this.curentWindow.Cb.length;i++){
   this.curentWindow.Who=this.curentWindow.ch.getItem(this.curentWindow.ch.getSelectedIndex());
   this.curentWindow.Cb[i].setEnabled(this.curentWindow.Who=="People");
  }
 }

}
