import java.util.Scanner;

public class Calc {
    static Scanner polin = new Scanner(System.in);
    public static void main(String[] args) {
        Polinom calcPolinom=new Polinom();
        String nextPolinom;
        String line;
        nextPolinom=polin.nextLine();
        char[] polinChar = new char[nextPolinom.length()];
        polinChar= nextPolinom.toCharArray();
        calcPolinom.transfer(polinChar,0,polinChar.length,1);

//        System.out.println(nextPolinom);
//        Scanner scanner = new Scanner(nextPolinom);
//        scanner.useDelimiter("[-+*/]");
//        while (scanner.hasNext()) {
//            line = scanner.next();
//            System.out.println(line);
//        }
    }
}
