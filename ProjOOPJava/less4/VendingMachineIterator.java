package ProjOOPJava.less4;
import java.util.*;

public class VendingMachineIterator<T extends Product> implements Iterator<T> {
    private ArrayList<T> products;
    private int counter;

    public VendingMachineIterator(ArrayList<T> products){
        this.products = products;
        counter = 0;
    }

    @Override
    public boolean hasNext() {
        return counter < products.size();
    }

    @Override
    public T next() {
        return products.get(counter++);
    }
    
}
