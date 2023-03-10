package ProjOOPJava.less5;

public class Main {
    public static void main(String[] args) {
        //реализовать оидн из паттернов (singleton -https://habr.com/ru/post/129494/, builder, fabric - https://habr.com/ru/post/556512/)
        //фабрика доставки
        Factory f = new Factory();
        f.delivery(FactoryEnum.BIKE);
        System.out.println("______________");
        f.delivery(FactoryEnum.FOOTS);
        System.out.println("______________");
        f.delivery(FactoryEnum.ELECTRICSCOOTER);
    }
}
