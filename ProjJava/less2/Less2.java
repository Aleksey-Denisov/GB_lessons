package ProjJava.less2;
import java.util.Scanner;
import java.io.*;

public class Less2 {
    public static void main(String[] args) {
        //Реализуйте алгоритм сортировки пузырьком числового массива, результат после каждой итерации запишите в лог-файл.
        bubleSort();
        //К калькулятору из предыдущего дз добавить логирование.
        simpleCalculator();
    }
    private static void bubleSort(){
        ArrayBubble arrayForSort = new ArrayBubble();
        arrayForSort.printer();
    }
    private static void simpleCalculator(){
        Calc Calculator = new Calc();
        Calculator.performAnAction();
    }
}

class FileOptions{
    //Предположим, что я всегда хочу писать в этот файл если его не окажется создам новый
    public FileOptions(){
        File logActions = new File("ProjJava/less2/log.txt");
        if(!logActions.exists()){
            try{
                boolean created = logActions.createNewFile();
                if(created){
                    System.out.println("File has been created");
                }  
            }catch(IOException ex){
                System.out.println(ex.getMessage());
            }
        }
    }
    //Думал сделать больше методов для работы с файлами, пока не требуется
    public void writeNewLineFile(String actions){
        try(FileWriter writeToFile = new FileWriter("ProjJava/less2/log.txt", true)){
            writeToFile.write(actions);
            writeToFile.flush();
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}
class EnteringUserData{
    //Ввод с клавиатуры только целочисленных чисел
    public int consoleEnterInt(String message){
        int value;
        Scanner in = new Scanner(System.in);
        while(true){
           try{
                System.out.print(message);
                value = in.nextInt();
                break;
            }
            catch(Exception ex){
                System.out.println("Error");
            }
        }
        return value;
    }
    //Ввод с клавиатуры чисел с плавающей точкой
    public double consoleEnterDouble(String message){
        double doubleValue;
        Scanner in = new Scanner(System.in);
        while(true){
            try{
                System.out.println(message);
                doubleValue = Double.parseDouble(in.nextLine());
                break;
            }
            catch(Exception ex){
                System.out.println("Error");
            }
        }
        return doubleValue;
    }
    //Ввод с клавиатуры действия для калькулятора
    public char consoleEnterAction(String message){
        char actionUser;
        Scanner in = new Scanner(System.in);
        while(true){
            try{
                System.out.println(message);
                actionUser = in.next().charAt(0);
                if(actionUser == '+' || actionUser == '-' || actionUser == '/' || actionUser == '*')
                    break;
                else
                    System.out.println("Error");
            }
            catch(Exception ex){
                System.out.println("Error");
            }
        }
        return actionUser;
    }
}

class ArrayBubble{
    private FileOptions logFileWrite = new FileOptions();
    private EnteringUserData userData = new EnteringUserData();
    private int[] arrayInt;
    private int amountOfElements;

    public ArrayBubble(){
        amountOfElements = userData.consoleEnterInt("Enter the size of the array: ");
        arrayInt = new int[amountOfElements];
        logFileWrite.writeNewLineFile("Buble sorted: An array of " + amountOfElements + " elements has been created\n");
        append();
    }

    private void append(){
        for(int idElementArray = 0; idElementArray < amountOfElements; idElementArray++){
            arrayInt[idElementArray] = userData.consoleEnterInt("Enter a value into an array element "+ idElementArray +": ");
            logFileWrite.writeNewLineFile("Buble sorted: The user enters the value " + arrayInt[idElementArray] + " into array element " + idElementArray + "\n");
        }
        bubbleSorter();
    }

    public void printer(){
        logFileWrite.writeNewLineFile("Buble sorted: Complete array ");
        for (int i = 0; i < amountOfElements; i++){
            System.out.print(arrayInt[i] + " ");
            logFileWrite.writeNewLineFile(arrayInt[i] + " ");
        }
        logFileWrite.writeNewLineFile(" \n");
        System.out.println();
    }

    private void toSwap(int first, int second){
        int dummy = arrayInt[first];
        arrayInt[first] = arrayInt[second];
        arrayInt[second] = dummy;
    }

    private void bubbleSorter(){
        for (int out = amountOfElements - 1; out >= 1; out--){
            for (int in = 0; in < out; in++){
                if(arrayInt[in] > arrayInt[in + 1]){
                    logFileWrite.writeNewLineFile("Buble sorted: The elements of the array " + arrayInt[in] + " are replaced by " + arrayInt[in + 1] + "\n");
                    toSwap(in, in + 1);
                }
            }
        }
    }
}

class Calc{
    private FileOptions logFileWrite = new FileOptions();
    private EnteringUserData userData = new EnteringUserData();
    private double numberA, nubmerB;
    private char choiceUser;


    public Calc(){
        numberA = userData.consoleEnterDouble("Enter number a:");
        choiceUser = userData.consoleEnterAction("Enter action is + or - or / or *");
        nubmerB = userData.consoleEnterDouble("Enter number b:");
        logFileWrite.writeNewLineFile("Simple calculator: User entered number " + numberA + " action " + choiceUser + " and number " + nubmerB + "\n");
    }
    public void performAnAction(){
        switch(choiceUser){
            case '+':
                System.out.println(numberA + nubmerB);
                logFileWrite.writeNewLineFile("Simple calculator: Action result " + (numberA + nubmerB)+ "\n");
                break;
            case '-':
                System.out.println(numberA - nubmerB);
                logFileWrite.writeNewLineFile("Simple calculator: Action result " + (numberA - nubmerB)+ "\n");
                break;
            case '*':
                System.out.println(numberA * nubmerB);
                logFileWrite.writeNewLineFile("Simple calculator: Action result " + (numberA * nubmerB)+ "\n");
                break;
            case '/':
                System.out.println(numberA / nubmerB);
                logFileWrite.writeNewLineFile("Simple calculator: Action result " + (numberA / nubmerB)+ "\n");
                break;
        }
    }
}
