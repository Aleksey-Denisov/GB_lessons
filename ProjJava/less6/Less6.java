package ProjJava.less6;
import java.util.*;

public class Less6 {
    public static void main(String[] args) {
        EnteringUserData userData = new EnteringUserData();
        /*Подумать над структурой класса Ноутбук для магазина техники - выделить поля и методы. Реализовать в java
        Создать множество ноутбуков
        Написать метод, который будет запрашивать у пользователя критерий (или критерии) фильтрации и выведет ноутбуки, отвечающие фильтру. Критерии фильтрации можно хранить в Map. Например: “Введите цифру, соответствующую необходимому критерию:
        1 - ОЗУ
        2 - Объем ЖД
        3 - Операционная система
        4 - Цвет …
        Далее нужно запросить минимальные значения для указанных критериев - сохранить параметры фильтрации можно также в Map.
        Отфильтровать ноутбуки их первоначального множества и вывести проходящие по условиям.*/
        Laptops laptops = new Laptops(userData);
        laptops.addFilters(userData);
        laptops.findLaptop();
        laptops.print();

        userData.scannerClose();
    }
}
class Laptops{
    private ArrayList<Laptop> listLaptops;
    private Map<String, ArrayList<String>> filters; 
    private ArrayList<Laptop> findLaptops;
    private static final String[] CHARACTERISTICS = {
        "Name", //марка ноутбука, номер и т.д.
        "CPU", //Наименование процессора i7...
        "Core", //Количество ядер процессора
        "RAM", //Объем ОЗУ
        "HDD", //Объем ЖД
        "GPU", //Название видеоадаптера
        "GPU VALUE", //Объем видеоадаптера 
        "SSD", //Размер ССД
        "Color", //Цвет
        "Price" //Цена
    };

    public Laptops(EnteringUserData userData){
        listLaptops = new ArrayList<>();
        while(true){
            Laptop laptop = new Laptop(CHARACTERISTICS,userData);
            listLaptops.add(laptop);
            if(userData.consoleEnterConfirm("continue? y or n: ")=='n'){
                break;
            }
        }
    }
    public void print(){
        System.out.println("Initial list of laptops:");
        for(Laptop laptop : listLaptops){
            laptop.print();
        }
        System.out.println("Specified filter:\n" + filters);
        System.out.println("List of found laptops:");
        for(Laptop laptop : findLaptops){
            laptop.print();
        }
    }
    public void addFilters(EnteringUserData userData){
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
    public void findLaptop(){
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
}
class Laptop{
    private Map<String,String> laptop;

    public Laptop(String[] CHARACTERISTICS, EnteringUserData userData){
        laptop = new HashMap<>();
        for(String line : CHARACTERISTICS){
            laptop.put(line,userData.consoleEnter("Enter laptop " + line + ": "));
        }
    }
    public String getCharacteristic(String characteristic){
        return laptop.get(characteristic);
    }
    public void print(){
        System.out.println(laptop);
    }
}
class EnteringUserData{
    private Scanner in = new Scanner(System.in);
    //Ввод с клавиатуры только целочисленных чисел
    public int consoleEnterInt(String message, int size){
        int valueInt;
        while(true){
            System.out.print(message);
            if(in.hasNextInt()){
                valueInt = in.nextInt();
                if(valueInt < size){
                    in.nextLine();
                    break;
                }else{
                    System.out.println("Error enter user data");
                }
            }else{
                System.out.println("Error enter user data");
                in.nextLine();
            }
        }
        return valueInt;
    }
    public String consoleEnter(String message){
        String userData;
        while(true){
            System.out.print(message);
            userData = in.nextLine();
            if(userData != ""){
                break;
            }else{
                System.out.println("The entered value must not be missing");
            }
        }
        return userData;
    }
    public char consoleEnterConfirm(String message){
        char choiceUser;
        while(true){
            System.out.print(message);
            choiceUser = in.next().charAt(0);
            if(choiceUser == 'y' || choiceUser == 'n'){
                in.nextLine();
                break;
            }else{
                System.out.println("Error enter user data");
                in.nextLine();
            }
        }
        return choiceUser;
    }
    public void scannerClose(){
        in.close();
    }
}

