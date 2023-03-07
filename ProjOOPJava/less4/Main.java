package ProjOOPJava.less4;

public class Main {
    public static void main(String[] args) {
        VendingMachine<HotDrink> hd = new VendingMachine<>();
        hd.addProductToBox(new Tea("Earl Grey", 250, "ml", 110.75, 95));
        hd.addProductToBox(new Tea("Karkade", 250, "ml", 120.99, 95));
        hd.addProductToBox(new Coffee("Latte", 450, 70.25));
        hd.addProductToBox(new Coffee("Capuccino", 450, 70.5));
        hd.getProduct("Karkade");
        hd.getProduct(450);
        
        VendingMachine<Product> vm = new VendingMachine<>();
        vm.addProductToBox(new Snack("Croissant", 20, "gr", 50));
        vm.addProductToBox(new Snack("Lays", 100, "gr", 150));
        vm.addProductToBox(new Drink("Cola", 500, 90));
        vm.addProductToBox(new Drink("Pepsi", 500, 90));
        vm.addProductToBox(new Drink("Cola", 1, "l", 150));
        vm.addProductToBox(new Drink("Pepsi", 1, "l", 150));
        vm.getProduct(500);
        vm.getProduct("Croissant");
        vm.getProduct("Pepsi",1,150);
        vm.getProduct("Lays");

    }
}
