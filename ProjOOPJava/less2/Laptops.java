package ProjOOPJava.less2;
import java.util.*;

public class Laptops implements InterfaceLaptops {
    private ArrayList<Laptop> listLaptops;
    private Map<String, ArrayList<String>> filters; 
    private ArrayList<Laptop> findLaptops;

    public Laptops(){
        listLaptops = new ArrayList<>();
    }
    @Override
    public void addLaptops(Laptop laptop) {
        listLaptops.add(laptop);
    }
    @Override
    public void addFilters(EnteringUserData userData) {
        filters = new HashMap<>();
        while(true){
            ArrayList<String> characteristic = new ArrayList<>();
            for(int idElement = 0; idElement < CHARACTERISTICS.length; idElement++){
                System.out.print(CHARACTERISTICS[idElement] + ": " + idElement + " ");
            }
            int idCharacteristic = userData.consoleEnterInt("\nSpecify the number of the characteristic: ", CHARACTERISTICS.length);
            if(filters.containsKey(CHARACTERISTICS[idCharacteristic])){
                characteristic = filters.get(CHARACTERISTICS[idCharacteristic]);
            }
            characteristic.add(userData.consoleEnter("Enter characteristic: "));
            filters.put(CHARACTERISTICS[idCharacteristic], characteristic);
            if(userData.consoleEnterConfirm("continue? y or n: ")=='n'){
                break;
            }
        }
    }
    @Override
    public void findLaptop() {
        findLaptops = new ArrayList<>();
        for(Laptop laptop : listLaptops){
            int match = 0;
            for(Map.Entry<String, ArrayList<String>> lineMap : filters.entrySet()){
                String characteristic = laptop.getCharacteristic(lineMap.getKey());
                for(String charact : lineMap.getValue()){
                    //Получилось совсем костыльно, лучше не придумал
                    if(convertToDouble(charact) != -1 && convertToDouble(charact) < convertToDouble(characteristic)){
                        match++;
                        break;
                    }else if(charact.equals(characteristic)){
                        match++;
                        break;
                    }
                }
            }
            if(match == filters.size()){
                findLaptops.add(laptop);
            }
        }
    }
    private double convertToDouble(String string){
        double number = -1;
        try{
            number = Double.parseDouble(string);
        }catch(NumberFormatException e){
        }
        return number;
    }
    @Override
    public void print(){
        System.out.println("Specified filter:\n" + filters);
        System.out.println("List of found laptops:");
        for(Laptop laptop : findLaptops){
            laptop.print();
        }
    }
}
