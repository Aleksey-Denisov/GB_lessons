package ProjOOPJava.less6.model;

public class DeliveryAction {
    public void receivingAnOrder(){
        System.out.println("Receiving An Order");
    }
    public void deliveryOrder(){
        System.out.println("Delivery Order");
    }
}
    
class Bike extends DeliveryAction{
    public Bike(){
        System.out.println("Delivery on Bike");
    }
}
class ElectricScooter extends DeliveryAction{
    public ElectricScooter(){
        System.out.println("Delivery on Electric Scooter");
    }
}
class Foots extends DeliveryAction{
    public Foots(){
        System.out.println("Delivery on Foots");
    }
} 
class QuadCopter extends DeliveryAction{
    public QuadCopter(){
        System.out.println("Delivery on Quad Copter");
    }
} 

