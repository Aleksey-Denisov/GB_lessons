package ProjOOPJava.less3;

public class Main {
    public static void main(String[] args) {
        /*Добавить к вендинговому аппарату возможность итерирования*/
        //Методы выдачи теперь работают через итерирование
        VendingMachine vm = new VendingMachine();
        vm.addProductToBox(new Product("Pepsi", 490, "ml", 100));
        vm.addProductToBox(new Product("Pepsi", 1, "l", 180));
        vm.addProductToBox(new Product("Water Aqua", 1, "l", 90));
        vm.addProductToBox(new Product("Mirinda", 490, "ml", 100));
        vm.addProductToBox(new Product("Mirinda", 1, "l", 180));
        vm.getProduct("Pepsi");
        vm.getProduct("Mirinda", 1);
    }
}
