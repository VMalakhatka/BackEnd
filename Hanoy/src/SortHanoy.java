public class SortHanoy {
    private int iter=0;
    private int q;
    private Tower from;
    private Tower to;
    private Tower buf;

    public SortHanoy(int q, Tower from, Tower to, Tower buf) {
        this.q = q;
        this.from = from;
        this.to = to;
        this.buf = buf;
    }

    public void sortTower(){
        hanoy(q,from,to,buf);
    }

    private void hanoy(int q,Tower from, Tower to, Tower buf){
        if(q==0) return;
        hanoy(q-1,from,buf,to);
        to.pushDisk(from.popDisk());
        System.out.println("Iteration - "+(++iter));
        System.out.println(this.from.outAllTower(this.to,this.buf));
        hanoy(q-1,buf,to,from);
    }
}
