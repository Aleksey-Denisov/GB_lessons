package ProjOOPJava.less1;

public class HotDrink extends Product{
    private int temperature;

    public HotDrink(String name,  double price){
        super(name, 100, "ml", price);
        this.temperature = 95;
    }
    public HotDrink(String name, double volume, double price){
        super(name, volume, price);
        this.temperature = 85;
    }
    public void showProduct(){
        super.showProduct(String.format("Temperature: %d°C", temperature));
    }
    public int getTemperatureProduct(){
        return temperature;
    }
    public double getVolumeProduct(){
        return super.getVolumeProduct();
    }
    public double getPriceProduct(){
        return super.getPriceProduct();
    }
    public String getNameProduct(){
        return super.getNameProduct();
    }
    public String getMeasureUnitProduct(){
        return super.getMeasureUnitProduct();
    }
}
