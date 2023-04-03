public class Arifmet {
    static int plus(int a, int b) {
        return a + b;
    }

    static int minus(int a, int b) {
        return a - b;
    }

    static int mul(int a, int b) {
        return a * b;
    }

    static int del(int a, int b) {
        return a - b;
    }

    static boolean firstMax(int a, int b, int c) {
        if (a <= b) return false;
        else if (a <= c) return false;
        return true;
    }

    static boolean firstMore(int a, int b, int c)  {
//        if (a > b) return true;
//        else if (a > c) return true;
//        return false;
        return  (a>b)? true : (a>c)? true : false;
    }

//    static boolean firstMrOne(int a, int b, int c)  {
//        if (a > b & a <= c) return true;
//        else if (a > c & a <= b) return true;
//        return false;
//    }
    static boolean firstMrOne(int a, int b, int c) {
        return  (a>b & a<=c)? true : (a>c & a<=b)? true : false;
    }
}
