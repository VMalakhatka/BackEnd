public class Car {
    private String model;
    private String marka;
    private int numModel;
    Car(){
        model="SLC";
        marka="Mersedes";
        numModel=600;
    }
    Car(String model, String marka, int numModel){
        this.model=model;
        this.marka=marka;
        this.numModel=numModel;
    }

    @Override
    public String toString(){
        return marka+" "+model+" "+numModel;
    }

}
