package ProjAlgAndStructData.less2.controller;

import ProjAlgAndStructData.less2.module.EnteringUserData;
import ProjAlgAndStructData.less2.module.HeapSort;

public class Controller {
    private EnteringUserData userData;
    private HeapSort heapSort;

    public Controller(){
        heapSort = new HeapSort();
        userData = new EnteringUserData();
    }
    public void action(){
        heapSort.enterUserData(userData);
        heapSort.sorter();
        heapSort.printer();
        userData.scannerClose();
    }
}
