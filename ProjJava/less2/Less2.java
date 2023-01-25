package ProjJava.less2;
import java.util.Scanner;
import java.io.*;
import java.util.logging.*;

public class Less2 {
    public static void main(String[] args) {
        //Реализуйте алгоритм сортировки пузырьком числового массива, результат после каждой итерации запишите в лог-файл.
        //К калькулятору из предыдущего дз добавить логирование.
        //Поясните пожалуйста, почему создается два файла логирования, пишется в оба при этом
        //и в другом порядке не выполняется, что-то не понимаю
        simpleCalculator();
        bubleSort();
        /*
        Появляется ошибка как буд то не распознает имя класса
        Exception in thread "main" java.lang.NoClassDefFoundError: ProjJava/less2/Calculator
        at ProjJava.less2.Less2.simpleCalculator(Less2.java:19)
        at ProjJava.less2.Less2.main(Less2.java:12)
        Caused by: java.lang.ClassNotFoundException: ProjJava.less2.Calculator
        at java.base/jdk.internal.loader.BuiltinClassLoader.loadClass(BuiltinClassLoader.java:641)
        at java.base/jdk.internal.loader.ClassLoaders$AppClassLoader.loadClass(ClassLoaders.java:188)
        at java.base/java.lang.ClassLoader.loadClass(ClassLoader.java:521)
        ... 2 more
         */
    }
    private static void simpleCalculator(){
        Calculator calc = new Calculator();
        calc.performAnAction();
    }
    private static void bubleSort(){
        ArrayBubble arrayForSort = new ArrayBubble();
        arrayForSort.printer();
    }
}

class LogFile{
    private Logger logger = Logger.getLogger(LogFile.class.getName());
    private FileHandler fileHandler = null;

    public LogFile() {
        try {
            fileHandler = new FileHandler("ProjJava/less2/event.log", true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        fileHandler.setFormatter(new SimpleFormatter());
        logger.addHandler(fileHandler);
    }
    public void info(String message) {
        logger.info(message);
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
                System.out.print(message);
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
                System.out.print(message);
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

class Calculator{
    private LogFile eventLog = new LogFile();
    private FileOptions logFileWrite = new FileOptions();
    private EnteringUserData userData = new EnteringUserData();
    private double numberA, nubmerB;
    private char choiceUser;


    public Calculator(){
        numberA = userData.consoleEnterDouble("Enter number a: ");
        choiceUser = userData.consoleEnterAction("Enter action is + or - or / or * : ");
        nubmerB = userData.consoleEnterDouble("Enter number b: ");

        eventLog.info("Simple calculator: User entered number " + numberA + " action " + choiceUser + " and number " + nubmerB + "\n");
        logFileWrite.writeNewLineFile("Simple calculator: User entered number " + numberA + " action " + choiceUser + " and number " + nubmerB + "\n");
    }
    public void performAnAction(){
        switch(choiceUser){
            case '+':
                System.out.println(numberA + nubmerB);
                eventLog.info("Simple calculator: Action result " + (numberA + nubmerB)+ "\n");
                logFileWrite.writeNewLineFile("Simple calculator: Action result " + (numberA + nubmerB)+ "\n");
                break;
            case '-':
                System.out.println(numberA - nubmerB);
                eventLog.info("Simple calculator: Action result " + (numberA - nubmerB)+ "\n");
                logFileWrite.writeNewLineFile("Simple calculator: Action result " + (numberA - nubmerB)+ "\n");
                break;
            case '*':
                System.out.println(numberA * nubmerB);
                eventLog.info("Simple calculator: Action result " + (numberA * nubmerB)+ "\n");
                logFileWrite.writeNewLineFile("Simple calculator: Action result " + (numberA * nubmerB)+ "\n");
                break;
            case '/':
                System.out.println(numberA / nubmerB);
                eventLog.info("Simple calculator: Action result " + (numberA / nubmerB)+ "\n");
                logFileWrite.writeNewLineFile("Simple calculator: Action result " + (numberA / nubmerB)+ "\n");
                break;
        }
    }
}

class ArrayBubble{
    private LogFile eventLog = new LogFile();
    private FileOptions logFileWrite = new FileOptions();
    private EnteringUserData userData = new EnteringUserData();
    private int[] arrayInt;
    private int amountOfElements;
    private String forLog = "";

    public ArrayBubble(){
        amountOfElements = userData.consoleEnterInt("Enter the size of the array: ");
        arrayInt = new int[amountOfElements];

        logFileWrite.writeNewLineFile("Buble sorted: An array of " + amountOfElements + " elements has been created\n");
        eventLog.info("Buble sorted: An array of " + amountOfElements + " elements has been created\n");
        
        for(int idElementArray = 0; idElementArray < amountOfElements; idElementArray++){
            arrayInt[idElementArray] = userData.consoleEnterInt("Enter a value into an array element "+ idElementArray +": ");
            forLog += arrayInt[idElementArray] + " ";
        }

        logFileWrite.writeNewLineFile("Buble sorted: The user enters the value " + forLog + "\n");
        eventLog.info("Buble sorted: The user enters " + forLog + "\n");

        bubbleSorter();
    }

    public void printer(){
        forLog = "";
        for (int idElementArray = 0; idElementArray < amountOfElements; idElementArray++){
            System.out.print(arrayInt[idElementArray] + " ");
            forLog += arrayInt[idElementArray] + " ";
        }
        
        System.out.println();
        logFileWrite.writeNewLineFile("Buble sorted: Complete array " + forLog + "\n");
        eventLog.info("Buble sorted: Complete array " + forLog + "\n");
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
                    eventLog.info("Buble sorted: The elements of the array " + arrayInt[in] + " are replaced by " + arrayInt[in + 1] + "\n");
                    toSwap(in, in + 1);
                }
            }
        }
    }
}

