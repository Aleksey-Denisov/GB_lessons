package ProjOOPJava.less4;

public abstract class HotDrink extends Product{
    private int temperature;

    public HotDrink(String name, double volume, double price){
        super(name, volume, price);
        this.temperature = 85;
    }
    public HotDrink(String name, double volume, String measureUnit, double price, int temperature){
        super(name, volume, measureUnit, price);
        this.temperature = temperature;
    }
    public void showProduct(String message){//костыль получился, возможно в другой раз поправлю
        super.showProduct(String.format("Temperature: %d°C", temperature));
    }
    public int getTemperature(){
        return temperature;
    }
    public double getVolume(){
        return super.getVolume();
    }
    public double getPrice(){
        return super.getPrice();
    }
    public String getName(){
        return super.getName();
    }
    public String getMeasureUnit(){
        return super.getMeasureUnit();
    }
}

class Coffee extends HotDrink{
    public Coffee(String name, double volume, double price){
        super(name, volume, price);
    }
}

class Tea extends HotDrink{
    public Tea(String name, double volume, String measureUnit, double price, int temperature){
        super(name, volume, measureUnit, price, temperature);
    }
}
