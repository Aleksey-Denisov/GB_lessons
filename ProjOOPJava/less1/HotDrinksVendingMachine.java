package ProjOOPJava.less1;
import java.util.*;

public class HotDrinksVendingMachine extends VendingMachine{
    private ArrayList<HotDrink> products;

    public HotDrinksVendingMachine(){
        products = new ArrayList<>();
    }
    public void addProductToBox(HotDrink product){
        if(!products.contains(product))
            this.products.add(product);
        else
            System.out.println("This item has already been added to the list:");
    }
    public void getProduct(String name){
        for(HotDrink product : products){
            if(product.getNameProduct().equals(name)){
                product.showProduct();
            }
        }
    }
    public void getProduct(String name, double volume){
        for(HotDrink product : products){
            if(product.getNameProduct().equals(name) && product.getVolumeProduct() == volume){
                product.showProduct();
            }
        }
    }
    public void getProduct(String name, double volume, int temperature){
        for(HotDrink product : products){
            if(product.getNameProduct().equals(name) && product.getVolumeProduct() == volume 
            && product.getTemperatureProduct() == temperature){
                product.showProduct();
            }
        }
    }
}