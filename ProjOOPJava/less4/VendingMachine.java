package ProjOOPJava.less4;
import java.util.*;

public class VendingMachine <T extends Product> implements Iterable<T> {
    private ArrayList<T> products;

    public VendingMachine(){
        products = new ArrayList<>();
    }

    public void addProductToBox(T product){
        if(!products.contains(product))
            this.products.add(product);
        else
            System.out.println("This item has already been added to the list:");
    }

    @Override
    public Iterator<T> iterator() {
        return new VendingMachineIterator<T>(products);
    }
    public void getProduct(String name){
        Iterator<T> iter = iterator();
        while(iter.hasNext()){
            var product = iter.next();
            if((product).getName().equals(name))
                product.showProduct("");
        }
    }
    public void getProduct(String name, double volume, double price){
        Iterator<T> iter = iterator();
        while(iter.hasNext()){
            var product = iter.next();
            if(product.getName().equals(name) && product.getVolume() == volume
            && product.getPrice() == price)
                product.showProduct("");
        }
    }
    public void getProduct(double volume){
        Iterator<T> iter = iterator();
        while(iter.hasNext()){
            var product = iter.next();
            if(product.getVolume() == volume)
                product.showProduct("");
        }
    }

}
