package ProjOOPJava.less5;

public class FactoryAction {
    public void receivingAnOrder(){
        System.out.println("Receiving An Order");
    }
    public void deliveryOrder(){
        System.out.println("Delivery Order");
    }
}

class Bike extends FactoryAction{
    public Bike(){
        System.out.println("Delivery on Bike");
    }
}
class ElectricScooter extends FactoryAction{
    public ElectricScooter(){
        System.out.println("Delivery on Electric Scooter");
    }
}
class Foots extends FactoryAction{
    public Foots(){
        System.out.println("Delivery on Foots");
    }
} 
class QuadCopter extends FactoryAction{
    public QuadCopter(){
        System.out.println("Delivery on Quad Copter");
    }
} 