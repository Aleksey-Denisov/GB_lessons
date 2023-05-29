package ProjAlgAndStructData.less2.module;

import java.util.*;

public class HeapSort{
    private ArrayList<Integer> heapSort;
    private int amountOfElements;

    public HeapSort(){
        heapSort = new ArrayList<>();
    }
    public void enterUserData(EnteringUserData userData){
        amountOfElements = userData.consoleEnterInt("Enter the number of items to add: ");
        for(int idElementArray = 0; idElementArray < amountOfElements; idElementArray++){
            heapSort.add(userData.consoleEnterInt("Enter an element " + idElementArray + " into the list: "));
        }
    }
    public void sorter(){
        heapSort = heapSort(heapSort, heapSort.size());
    }
    private ArrayList<Integer> heapSort(ArrayList<Integer> sortList,int size){
        if (size == 1) return sortList;

        int lastParent = findLastParentIndex(size);

        for (int parent = lastParent; parent >= 0; parent--) {
            int leftChild = parent * 2 + 1;
            int rightChild = parent * 2 + 2;
            if (leftChild == size - 1) 
                rightChild = leftChild;
            int max = leftChild;
            if (sortList.get(rightChild) > sortList.get(max)) 
                max = rightChild;
            if (sortList.get(parent) < sortList.get(max)) 
                swapIndexes(sortList, max, parent);
        }
        swapIndexes(sortList, 0, size - 1);
        return heapSort(sortList, size - 1);
    }
    private void swapIndexes(ArrayList<Integer> sortList, int idElementA, int idElementB) {
        Collections.swap(sortList, idElementA, idElementB);
    }
    private int findLastParentIndex(int size){
        int idElement;
        if (size % 2 == 0){
            idElement = (size - 1) / 2;
        }else{
            idElement = (size - 2) / 2;
        }
        return idElement;
    }
    public void printer(){
        System.out.println(heapSort);
    }
}