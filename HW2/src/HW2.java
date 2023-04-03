public class HW2 {
    public static void main(String[] args) {
        Car newCar= new Car();
        Car mazda= new Car("MZD","MAZDA",9);
        System.out.println(newCar);
        System.out.println(mazda);
        System.out.println(Arifmet.minus(6,3) + " " + Arifmet.mul(4,6));
        System.out.println(Arifmet.firstMax(5,3,2));
        System.out.println(Arifmet.firstMrOne(5,2,7));
        System.out.println(Arifmet.firstMrOne(5,2,1));
        System.out.println(Arifmet.firstMrOne(5,6,3));
        System.out.println(Arifmet.firstMrOne(1,2,3));
    }
}
