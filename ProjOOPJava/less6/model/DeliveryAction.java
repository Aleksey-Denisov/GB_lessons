package ProjOOPJava.less6.model;

public class DeliveryAction {
    public String receivingAnOrder(){
        return "Получил заказ";
    }
    public String deliveryOrder(){
        return "Заказ в доставке";
    }
    public String getTransport(){
        return "";
    }
}
    
class Bike extends DeliveryAction{
    public Bike(){
        getTransport();
    }
    public String getTransport(){
        return "Доставка выполняется на велосипеде";
    }
}
class ElectricScooter extends DeliveryAction{
    public ElectricScooter(){
        getTransport();
    }
    public String getTransport(){
        return "Доставка выполняется на электро самокате";
    }
}
class Foots extends DeliveryAction{
    public Foots(){
    }
    public String getTransport(){
        return "Доставка выполняется пешком";
    }
} 
class QuadCopter extends DeliveryAction{
    public QuadCopter(){
    }
    public String getTransport(){
        return "Доставка выполняется квадрокоптером";
    }
} 

