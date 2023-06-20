public class Hanoy {
    public static void main(String[] args) {
        final int hight=7;
        try {
            Tower A = new Tower(hight, true);
            Tower B = new Tower(hight,false);
            Tower C = new Tower(hight,false);
            System.out.println(A.outAllTower(B,C));
            new SortHanoy(hight,A,B,C).sortTower();
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
