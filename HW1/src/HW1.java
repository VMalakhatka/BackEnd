import java.util.Scanner;

public class HW1 {

    static Scanner sc = new Scanner(System.in);
    //Глобальные переменные -Чтобы создать такую
    // переменную в Java, необходимо в публичном классе создать публичную статическую переменную:
    static char chr;
    static byte dec_byte;
    static short sht;
    static int dec_int;
    static long dec_long;
    static float dec_float;
    //использование констант (глобальных переменных, доступных только для чтения)
    public static final double PI = 3.1415926535897932384626433832795;
    public static void main(String[] args) {
       // локальные
        double dec_double;
        boolean bln;

        System.out.println("Введите символ");
        chr=sc.nextLine().charAt(0);
        System.out.println("Введите число до 127 : ");
        dec_byte=sc.nextByte();
        System.out.println("Введите число до 32767 : ");
        sht=sc.nextShort();
        System.out.println("Введите число до 2_147_483_647 : ");
        dec_int=sc.nextInt();


        System.out.println("");
        System.out.println("|-------|---------|---------|----------|");
        System.out.println("|-char--|--byte---|--shot---|----int---|");
        System.out.printf("|---%1s---|---%3d---|--%5d--|%10d|",chr,dec_byte,sht,dec_int);
        System.out.println("");
        System.out.println("|-------|---------|---------|----------|");

    }
}
