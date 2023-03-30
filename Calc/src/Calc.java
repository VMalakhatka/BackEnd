import java.util.Scanner;

public class Calc {
    static Scanner polin = new Scanner(System.in);
    public static void main(String[] args) {
        int i=1;
        while (i>=0) {
            Polinom calcPolinom = new Polinom();
            String nextPolinom;
            String line;
            System.out.println(" Можно посчитать выражение на подобии -5**3+3*(6-(55-24*2)*4)/4+sin(6)");
            System.out.println("Можно использовать круглые скобки знаки + - * / и ** ");
            System.out.println("Функции на английском языке на бодобии sin - аргументы обязательно в скобках    End  -завершение работы");
            nextPolinom = polin.nextLine();
            if (nextPolinom.equalsIgnoreCase("end")){
                System.out.println("Завершение работы");
                break;
            }
            char[] polinChar = new char[nextPolinom.length()];
            polinChar = nextPolinom.toCharArray();
            i=calcPolinom.transfer(polinChar, 0, polinChar.length, 1);
            System.out.println(" ------   Ответ - "+calcPolinom.polinomList.get(0).a );
        }

//        System.out.println(nextPolinom);
//        Scanner scanner = new Scanner(nextPolinom);
//        scanner.useDelimiter("[-+*/]");
//        while (scanner.hasNext()) {
//            line = scanner.next();
//            System.out.println(line);
//        }
    }
}
