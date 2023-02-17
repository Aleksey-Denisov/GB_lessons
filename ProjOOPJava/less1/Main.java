package ProjOOPJava.less1;

public class Main {
    public static void main(String[] args) {
        /*Создать наследника реализованного класса ГорячийНапиток с дополнительным полем int температура.
        Создать класс ГорячихНапитковАвтомат реализующий интерфейс ТорговыйАвтомат и реализовать перегруженный метод getProduct(int name, int volume, int temperature) выдающий продукт соответствующий имени, объему и температуре
        В main проинициализировать несколько ГорячихНапитков и ГорячихНапитковАвтомат и воспроизвести логику заложенную в программе
        Все вышеуказанное создать согласно принципам ООП пройдённым на семинаре */
        VendingMachine vm = new VendingMachine();
        vm.addProductToBox(new Product("Pepsi", 490, "ml", 100));
        vm.addProductToBox(new Product("Pepsi", 1, "l", 180));
        vm.addProductToBox(new Product("Water Aqua", 1, "l", 90));
        vm.addProductToBox(new Product("Mirinda", 490, "ml", 100));
        vm.addProductToBox(new Product("Mirinda", 1, "l", 180));
        vm.getProduct("Pepsi");
        vm.getProduct("Mirinda", 1);
        HotDrinksVendingMachine hd = new HotDrinksVendingMachine();
        hd.addProductToBox(new HotDrink("Latte", 200, 80));
        hd.addProductToBox(new HotDrink("Latte", 300, 110));
        hd.addProductToBox(new HotDrink("Latte", 400, 150));
        hd.addProductToBox(new HotDrink("Capuccino", 200, 80));
        hd.addProductToBox(new HotDrink("Capuccino", 300, 110));
        hd.addProductToBox(new HotDrink("Capuccino", 400, 150));
        hd.addProductToBox(new HotDrink("Americano", 400, 100));
        hd.addProductToBox(new HotDrink("Espresso", 80));
        hd.addProductToBox(new HotDrink("RAF", 300, 150));
        hd.getProduct("Latte");
        hd.getProduct("Capuccino", 400);
        hd.getProduct("Espresso", 100, 95);
    }
}
