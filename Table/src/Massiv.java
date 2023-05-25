import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Massiv {
    private int[] mass;
    public Massiv(int lench) {
        mass=new int[lench];
    }

    public Massiv(int[] mass){
        this.mass=mass;
    }

    public int[] generate(int r){
        for(int i=0;i<mass.length;i++){
            mass[i]=(int)Math.round(Math.random()*r);
            System.out.print(mass[i]+" ");
        }
        return mass;
    }

    @Override
    public String toString() {
        return "Massiv{" +
                "mass=" + Arrays.toString(mass) +
                '}';
    }

    public int[] delDubl(){
        if (mass.length<1 || mass==null) {
            throw new NullPointerException( "Null masiv");
        }
        if (mass.length<2) return mass;
        Arrays.sort(mass);
        System.out.println(this);
        ArrayList<Integer> newMass = new ArrayList<>();
        newMass.add(mass[0]);
        for (int i=0;i<mass.length-1;i++){
            if(mass[i]!=mass[i+1]){
                newMass.add(mass[i+1]);
            }
        }
        mass=new int[newMass.size()];
        for (int i=0; i<newMass.size();i++) mass[i]=newMass.get(i);
        return mass;
    }


    public int[] getMass() {
        return mass;
    }

    public int[] findMinPaar(Pair Arg){
        if (mass.length<1 || mass==null) {
            throw new NullPointerException( "Null masiv");
        }
        if (mass.length<2) return mass;
        int minA=Math.min(mass[0],mass[1]);
        int minB=Math.max(mass[0],mass[1]);
        for(int i=2;i<mass.length;i++){
            if (mass[i]<minA){
                minB=minA;minA=mass[i];
            } else if (mass[i]<minB) {
                minB=mass[i];
            }
        }
        Arg.setA(minA); Arg.setB(minB);
        return mass;
    }


    public int[] MaxFollowing(Pair Arg, int inc){
        int lenghtFollowing=1;
        int beginCarent= Arg.getA();
        int lenghtFollowingMax=1;
        if (mass.length<1 || mass==null) {
            throw new NullPointerException( "Null masiv");
        }
        if (mass.length<2) return mass;
        for (int i= Arg.getA();i<(Arg.getB()-1);i++){
            if(mass[i]==(mass[i+1]-inc)) lenghtFollowing++;
            else {
                if (lenghtFollowing>lenghtFollowingMax){
                    Arg.setA(beginCarent);
                    lenghtFollowingMax=lenghtFollowing;
                }
                beginCarent=i+1;
                lenghtFollowing=1;
            }
        }
        if (lenghtFollowing>lenghtFollowingMax){
            Arg.setA(beginCarent);
            lenghtFollowingMax=lenghtFollowing;
        }
        Arg.setB(lenghtFollowingMax);
        return mass;
    }

    public int MaxFollowingSum(Pair Arg, int inc){
        int sumMax=mass[Arg.getA()];
        int beginCarent= Arg.getA();
        int sumCur=mass[Arg.getA()];
        if (mass.length<1 || mass==null) {
            throw new NullPointerException( "Null masiv");
        }
        if (mass.length<2) return mass[0];
        for (int i= Arg.getA();i<(Arg.getB()-1);i++){
            if(mass[i]==(mass[i+1]-inc)) sumCur+=mass[i+1];
            else {
                if (sumCur>sumMax){
                    sumMax=sumCur;
                }
                sumCur=mass[i+1];
            }
        }
        if (sumCur>sumMax) sumMax=sumCur;
        return sumMax;
    }
    public int getLeght(){ return mass.length;}
}