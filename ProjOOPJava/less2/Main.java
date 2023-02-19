package ProjOOPJava.less2;

public class Main {
    public static void main(String[] args) {
        /*Подумать над структурой класса Ноутбук для магазина техники - выделить поля и методы. Реализовать в java
        Создать множество ноутбуков
        Написать метод, который будет запрашивать у пользователя критерий (или критерии) фильтрации и выведет ноутбуки, отвечающие фильтру. Критерии фильтрации можно хранить в Map. Например: “Введите цифру, соответствующую необходимому критерию:
        1 - ОЗУ
        2 - Объем ЖД
        3 - Операционная система
        4 - Цвет …
        Далее нужно запросить минимальные значения для указанных критериев - сохранить параметры фильтрации можно также в Map.
        Отфильтровать ноутбуки их первоначального множества и вывести проходящие по условиям.*/
        EnteringUserData userData = new EnteringUserData();
        Laptops laptops = new Laptops();
        laptops.addLaptops(new Laptop(new String[]{"Asus", "Intel Core i5-11400H", "6", "8", "2000", "Nvidia RTX 3060", "8", "512", "black", "150000"}, InterfaceLaptops.CHARACTERISTICS));
        laptops.addLaptops(new Laptop(new String[]{"MSI", "AMD Ryzen 5 5600H", "6", "8", "1000", "GeForce GTX 1650", "4", "256", "black", "54999"}, InterfaceLaptops.CHARACTERISTICS));
        laptops.addLaptops(new Laptop(new String[]{"Lenovo", "AMD Ryzen 5 5600H", "6", "16", "1000", "GeForce RTX 3050", "4", "256", "black", "56999"}, InterfaceLaptops.CHARACTERISTICS));
        laptops.addLaptops(new Laptop(new String[]{"Asus", "Intel Core i7-12400H", "8", "32", "2000", "GeForce RTX 4060", "8", "1000", "gray", "129999"}, InterfaceLaptops.CHARACTERISTICS));
        laptops.addLaptops(new Laptop(new String[]{"MSI", "AMD Ryzen 7 5800H", "8", "16", "2000", "Radeon RX 6700M", "10", "1000", "gray", "100999"}, InterfaceLaptops.CHARACTERISTICS));

        laptops.addFilters(userData);
        laptops.findLaptop();
        laptops.print();
        
    }
}
