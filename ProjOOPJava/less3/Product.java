package ProjOOPJava.less3;

public class Product {
    private double volume, price;
    private String name, measureUnit;

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
    public double getVolumeProduct(){
        return volume;
    }
    public double getPriceProduct(){
        return price;
    }
    public String getNameProduct(){
        return name;
    }
    public String getMeasureUnitProduct(){
        return measureUnit;
    }
}
