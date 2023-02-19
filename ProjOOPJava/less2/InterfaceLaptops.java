package ProjOOPJava.less2;

public interface InterfaceLaptops {
    public static final String[] CHARACTERISTICS = {
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

    public void addLaptops(Laptop laptop);

    public void addFilters(EnteringUserData userData);

    public void findLaptop();

    public void print();

}
