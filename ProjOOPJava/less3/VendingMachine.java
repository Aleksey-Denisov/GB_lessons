package ProjOOPJava.less3;
import java.util.*;

public class VendingMachine implements Iterable<Product>{
    private ArrayList<Product> products;
    
    public VendingMachine(){
        products = new ArrayList<>();
    }
    public void showProductsInBox(){
        System.out.println("Goods to buy:");
        for(Product product : products){
            product.showProduct();
        }
    }
    public void addProductToBox(Product product){
        if(!products.contains(product))
            this.products.add(product);
        else
            System.out.println("This item has already been added to the list:");
    }
    public void getProduct(String name, double volume, String measureUnit, double price){
        Iterator<Product> iter = iterator();
        while(iter.hasNext()){
            var product = iter.next();
            if(product.getNameProduct().equals(name) && product.getVolumeProduct() == volume
            && product.getMeasureUnitProduct().equals(measureUnit) && product.getPriceProduct() == price)
                product.showProduct();
        }
    }
    public void getProduct(String name, double volume, double price){
        Iterator<Product> iter = iterator();
        while(iter.hasNext()){
            var product = iter.next();
            if(product.getNameProduct().equals(name) && product.getVolumeProduct() == volume
            && product.getPriceProduct() == price)
                product.showProduct();
        }
    }
    public void getProduct(String name, double volume){
        Iterator<Product> iter = iterator();
        while(iter.hasNext()){
            var product = iter.next();
            if(product.getNameProduct().equals(name) && product.getVolumeProduct() == volume)
                product.showProduct();
        }
    }
    public void getProduct(String name){
        Iterator<Product> iter = iterator();
        while(iter.hasNext()){
            var product = iter.next();
            if(product.getNameProduct().equals(name))
                product.showProduct();
        }
    }
    @Override
    public Iterator<Product> iterator() {
        return new VendingMachineIterator(products);
    }
}
