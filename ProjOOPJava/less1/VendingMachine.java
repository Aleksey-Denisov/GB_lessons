package ProjOOPJava.less1;
import java.util.*;

public class VendingMachine{
    private ArrayList<Product> products;
    
    public VendingMachine(){
        products = new ArrayList<>();
    }
    public void showProductsInBox(){
        System.out.println("Goods to buy:");
        for(Product product : products){
            product.showProduct("");
        }
    }
    public void addProductToBox(Product product){
        if(!products.contains(product))
            this.products.add(product);
        else
            System.out.println("This item has already been added to the list:");
    }
    public void getProduct(String name, double volume, String measureUnit, double price){
        for(Product product : products){
            if(product.getNameProduct().equals(name) && product.getVolumeProduct() == volume
            && product.getMeasureUnitProduct().equals(measureUnit) && product.getPriceProduct() == price)
                product.showProduct("");
        }
    }
    public void getProduct(String name, double volume, double price){
        for(Product product : products){
            if(product.getNameProduct().equals(name) && product.getVolumeProduct() == volume
            && product.getPriceProduct() == price)
                product.showProduct("");
        }
    }
    public void getProduct(String name, double volume){
        for(Product product : products){
            if(product.getNameProduct().equals(name) && product.getVolumeProduct() == volume)
                product.showProduct("");
        }
    }
    public void getProduct(String name){
        for(Product product : products){
            if(product.getNameProduct().equals(name))
                product.showProduct("");
        }
    }
}
