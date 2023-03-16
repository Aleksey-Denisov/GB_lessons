package ProjOOPJava.less6.controller;
import ProjOOPJava.less6.model.*;
import ProjOOPJava.less6.service.DelivetyEnum;

public class DeliveryController {
    public DeliveryAction delivery(DelivetyEnum type){
        DeliveryAction action = DeliveryBuild.getTransport(type);
        action.receivingAnOrder();
        action.deliveryOrder();
        System.out.println("Delivery Complite");
        return action;
    }
}
