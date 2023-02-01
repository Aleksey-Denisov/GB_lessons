package ProjJava.less3;
import java.util.Iterator;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class Less3 {
    public static void main(String[] args) {
        EnteringUserData userData = new EnteringUserData();
        //Реализовать алгоритм сортировки слиянием
        ArrayMerge arrayMerge = new ArrayMerge(userData);
        arrayMerge.startSorter();
        arrayMerge.printer();
        //Пусть дан произвольный список целых чисел, удалить из него четные числа
        ListInt listInt = new ListInt();
        listInt.removeEvenNumbur();
        //Задан целочисленный список ArrayList. Найти минимальное, максимальное и среднее из этого списка.
        ListInt findValues = new ListInt(userData);
        findValues.findValues();

        userData.scannerClose();
    }
}
class ListInt{
    private ArrayList<Integer> listInt;
    private int amountOfElements;

    public ListInt(){
        Random random = new Random();
        amountOfElements = random.nextInt(5,10);
        listInt = new ArrayList<Integer>(amountOfElements);
        for(int idElementArray = 0; idElementArray < amountOfElements; idElementArray++){
            listInt.add(idElementArray, random.nextInt(999));
        }
        System.out.println("Inside list: " + listInt);
    }
    public ListInt(EnteringUserData userData){
        amountOfElements = userData.consoleEnterInt("Enter the size of the array list: ");
        listInt = new ArrayList<Integer>(amountOfElements);
        for(int idElementArray = 0; idElementArray < amountOfElements; idElementArray++){
            listInt.add(idElementArray, userData.consoleEnterInt("Enter a value into an array list element "+ idElementArray +": "));
        }
    }
    public void removeEvenNumbur(){
        Iterator<Integer> listIterator = listInt.iterator();
        while(listIterator.hasNext()){
            int idElementArray = listIterator.next();
            if(idElementArray % 2 == 0){
                listIterator.remove();
            }
        }
        System.out.println("Complete list: " + listInt);
    }
    public void findValues(){
        int minValue = listInt.get(0),
            maxValue = listInt.get(0),
            average = 0;
        for(int idElementArray : listInt){
            if(minValue > idElementArray){
                minValue = idElementArray;
            }
            if(maxValue < idElementArray){
                maxValue = idElementArray;
            }
            average += idElementArray;
        }
        System.out.println("Min value in list: " + minValue + "\nMax value in list: " + maxValue + "\nAverage value: " + (average / listInt.size()));
    }
}
class ArrayMerge{
    private int[] arrayInt;
    private int amountOfElements;

    public ArrayMerge(EnteringUserData userData){
        amountOfElements = userData.consoleEnterInt("Enter the size of the array: ");
        arrayInt = new int[amountOfElements];
        for(int idElementArray = 0;idElementArray < amountOfElements; idElementArray++){
            arrayInt[idElementArray] = userData.consoleEnterInt("Enter a value into an array element "+ idElementArray +": ");
        }
    }
    public void printer(){
        System.out.print("Complete array ");
        for (int idElementArray = 0; idElementArray < amountOfElements; idElementArray++){
            System.out.print(arrayInt[idElementArray] + " ");
        }
        System.out.println();
    }
    public void startSorter(){
        arrayInt = mergeSorter(arrayInt);
    }
    private int[] mergeSorter(int[] tempArrayA){

        if (tempArrayA.length < 2) {
            return tempArrayA;
        }
        int[] tempArrayB = new int[tempArrayA.length / 2];
        int[] tempArrayC = new int[tempArrayA.length - (tempArrayA.length / 2)];

        System.arraycopy(tempArrayA, 0, tempArrayB, 0, tempArrayA.length / 2);
        System.arraycopy(tempArrayA, tempArrayA.length / 2, tempArrayC, 0, tempArrayA.length - tempArrayA.length / 2);

        tempArrayB = mergeSorter(tempArrayB);
        tempArrayC = mergeSorter(tempArrayC);
        return mergeArray(tempArrayB, tempArrayC);
    }
    private int[] mergeArray(int[] tempArrayA, int[] tempArrayB){
        int[] tempArrayC = new int[tempArrayA.length + tempArrayB.length];
        int positionA = 0, positionB = 0, idElementArray = 0;

        while (positionA < tempArrayA.length && positionB < tempArrayB.length) {
            if (tempArrayA[positionA] <= tempArrayB[positionB]) {
                tempArrayC[idElementArray++] = tempArrayA[positionA++];
            }
            else {
                tempArrayC[idElementArray++] = tempArrayB[positionB++];
            }
        }
        while (positionA < tempArrayA.length) {
            tempArrayC[idElementArray++] = tempArrayA[positionA++];
        }
        while (positionB < tempArrayB.length) {
            tempArrayC[idElementArray++] = tempArrayB[positionB++];
        }
        return tempArrayC;
    }
 }
class EnteringUserData{
    private Scanner in = new Scanner(System.in);
    //Ввод с клавиатуры только целочисленных чисел
    public int consoleEnterInt(String message){
        int valueInt;
        while(true){
            System.out.print(message);
            if(in.hasNextInt()){
                valueInt = in.nextInt();
                break;
            }else{
                System.out.println("Error enter user data");
                in.nextLine();
            }
        }
        return valueInt;
    }

    public void scannerClose(){
        in.close();
    }
}
