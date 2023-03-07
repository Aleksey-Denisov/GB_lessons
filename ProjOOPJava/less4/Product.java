package ProjOOPJava.less4;

public abstract class Product {
    protected String name, measureUnit;
    protected double volume, price;

    public Product(String name, double volume, String measureUnit, double price){
        this.name = name;
        this.volume = volume;
        this.measureUnit = measureUnit;
        this.price = price;
    }
    public Product(String name, double volume, double price){
        this(name, volume, "ml", price);
    }
    public void showProduct(String message){
        System.out.printf( "%s %.2f %s price: %.2f %s\n",name, volume, measureUnit, price, message);
    }
    public double getVolume(){
        return volume;
    }
    public double getPrice(){
        return price;
    }
    public String getName(){
        return name;
    }
    public String getMeasureUnit(){
        return measureUnit;
    }
}

class Snack extends Product{
    public Snack(String name, double volume, String measureUnit, double price){
        super(name, volume, measureUnit, price);
    }
}
class Drink extends Product{
    public Drink(String name, double volume, String measureUnit, double price){
        super(name, volume, measureUnit, price);
    }
    public Drink(String name, double volume, double price){
        super(name, volume, price);
    }
}
