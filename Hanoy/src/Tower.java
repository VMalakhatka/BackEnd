import java.util.Stack;

public class Tower {
    private int hight;
    private int top=-1;
    private Disk[] tower=new Disk[Disk.MAX_SIZE_DISK];
    public Tower(int hight,boolean full) throws Exception {
        this.hight = hight;
        if (full==true){
            for (int i=0 ; i<hight; i++){
                tower[i]=new Disk(hight-i);
            }
            this.top=hight-1;
        }
    }
    public Disk popDisk(){
        Disk buf;
        if (this.top==-1) return null;
        buf=tower[this.top];
        this.tower[this.top]=null;
        this.top--;
        return buf;
    }

    public void pushDisk(Disk disk){
        tower[++top]=disk;
    }

    @Override
    public String toString() {
        String imgTower="      ┘└       ";
        for(int i=hight-1;i>=0;i--){
            if(tower[i]==null) imgTower+="              ┘└              \n";
            else imgTower+=tower[i].toString()+"\n";
        }
        return new String(imgTower);
    }

    public String getLier(int i){
        String imgLier;

            if(tower[i]==null) imgLier="       ┘└       ";
            else imgLier=tower[i].toString();

        return new String(imgLier);
    }
    public String outAllTower(Tower B, Tower C){
        String imgTower="";
        for(int i=hight-1;i>=0;i--){
            imgTower+=this.getLier(i)+B.getLier(i)+C.getLier(i)+"\n";
        }
        return new String(imgTower);
    }
}
