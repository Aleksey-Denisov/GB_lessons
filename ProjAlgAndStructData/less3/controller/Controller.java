package ProjAlgAndStructData.less3.controller;

import ProjAlgAndStructData.less3.module.*;

public class Controller {
    private NodeList list;
    public Controller(){
        list = new NodeList();
        for (int idElement = 0; idElement < 10; idElement++) {
			int data = (int)(Math.random() * 100);
            list.addData(idElement, data);
		}
		System.out.println(list.toString());
		System.out.println(list.reverse());
    }
    
}
