package ProjOOPJava.less2;
import java.util.*;

public class Laptop extends AbstractLaptop{

    public Laptop(String[] userData, String[] CHARACTERISTICS){
        laptop = new HashMap<>();
        //Так как в этот раз не будет ввода данных пользователя, допустим что всегда длина массива характеристик, равна длине передаваемых данных
        for(int idElement = 0; idElement < CHARACTERISTICS.length; idElement++) {
            laptop.put(CHARACTERISTICS[idElement],userData[idElement]);
        }
    }
    @Override
    public String getCharacteristic(String characteristic) {
        return laptop.get(characteristic);
    }
    @Override
    public void print() {
        System.out.println(laptop);
    }
}
