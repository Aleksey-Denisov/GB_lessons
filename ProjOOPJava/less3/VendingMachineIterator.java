package ProjOOPJava.less3;
import java.util.*;

public class VendingMachineIterator implements Iterator<Product> {
    private ArrayList<Product> products;
    private int counter;

    public VendingMachineIterator(ArrayList<Product> products){
        this.products = products;
        counter = 0;
    }

    @Override
    public boolean hasNext() {
        return counter < products.size();
    }

    @Override
    public Product next() {
        return products.get(counter++);
    }
    
}
