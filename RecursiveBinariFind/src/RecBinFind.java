public class RecBinFind {
    public static void main(String[] args) {
        Integer[] mas={1,2,3,5,6,7,8,9,10,15,17,22,33,44,55,66,77,77,77,88,99,111,222,333,444,555};
        findeElem<Integer> finde = new findeElem<>();
        System.out.println(finde.find(mas,17) + "  " + mas[finde.find(mas,17)]);
        String[] st={"aa","ab","cf","frt","rty","yujg"};
        findeElem<String> findeString=new findeElem<>();
        System.out.println(findeString.find(st,"cf") + "  " + st[findeString.find(st,"cf")]);
    }
}
