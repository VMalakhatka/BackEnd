import java.util.Scanner;

public class SubstringPrinter {


    public static void printSubstrings(String str) {


        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j <= str.length(); j++) {
                System.out.println(str.substring(i, j));
            }
        }
    }


    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите строку: ");

        String inputString = scanner.nextLine();

        System.out.println("Все подстроки строки:");
        printSubstrings(inputString);
        scanner.close();
    }
}
