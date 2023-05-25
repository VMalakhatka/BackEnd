
public class Table {
    public static void main(String[] args) {
        Massiv massiv=new Massiv(15);
        massiv.generate(18);
        System.out.println(massiv);
        massiv.delDubl();
        System.out.println(massiv);
        int[] massivData = {5,6,7,8,9,9,11,12,2,3,4,5,7,3,1,6,1,8,2,3,4,5,6,4,-12,6,8,4,1,4,5,6,7,8,9};
        Massiv massivWithNumber=new Massiv(massivData);
//        System.out.println(massivWithNumber);
//        massivWithNumber.delDubl();
//        System.out.println(massivWithNumber);
        Pair massivArgumentFollowing = new Pair(0,massivWithNumber.getLeght());
        massivWithNumber.MaxFollowing(massivArgumentFollowing,1);
        System.out.println("Max following in" + massivWithNumber);
        System.out.println("Snart " + massivArgumentFollowing.a +" lenght = "+massivArgumentFollowing.b);
        massivWithNumber.findMinPaar(massivArgumentFollowing);
        System.out.println(" In "+ massivWithNumber);
        System.out.println("min - "+massivArgumentFollowing.getA()+
                "  min second "+massivArgumentFollowing.getB());
        System.out.println("Max summ - "+
        massivWithNumber.MaxFollowingSum(new Pair(0,massivWithNumber.getLeght()),1)
        );
    }
}
