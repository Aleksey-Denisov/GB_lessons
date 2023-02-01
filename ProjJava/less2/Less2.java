package ProjJava.less2;
import java.util.Scanner;
import java.util.logging.*;

public class Less2 {
    public static void main(String[] args) {
        LogFile logFile = new LogFile();
        //Реализуйте алгоритм сортировки пузырьком числового массива, результат после каждой итерации запишите в лог-файл.
        ArrayBubble arrayBuble = new ArrayBubble(logFile);
        arrayBuble.bubbleSorter(logFile);
        arrayBuble.printer(logFile);
        //К калькулятору из предыдущего дз добавить логирование.
        Calculator calculator = new Calculator(logFile);
        calculator.performAnAction(logFile);
    }
}

class ArrayBubble {
    private int[] arrayInt;
    private int amountOfElements;
    private String forLog = "";
    private EnteringUserData userData = new EnteringUserData();

    public ArrayBubble(LogFile logFile){
        amountOfElements = userData.consoleEnterInt("Enter the size of the array: ", logFile);
        arrayInt = new int[amountOfElements];
        logFile.info("Buble sorted: An array of " + amountOfElements + " elements has been created\n");
        
        for(int idElementArray = 0; idElementArray < amountOfElements; idElementArray++){
            arrayInt[idElementArray] = userData.consoleEnterInt("Enter a value into an array element "+ idElementArray +": ", logFile);
            forLog += arrayInt[idElementArray] + " ";
        }
        logFile.info("Buble sorted: The user enters " + forLog + "\n");
    }

    public void printer(LogFile logFile){
        forLog = "";
        for (int idElementArray = 0; idElementArray < amountOfElements; idElementArray++){
            forLog += arrayInt[idElementArray] + " ";
        }
        logFile.info("Buble sorted: Complete array " + forLog + "\n");
    }

    private void toSwap(int first, int second){
        int dummy = arrayInt[first];
        arrayInt[first] = arrayInt[second];
        arrayInt[second] = dummy;
    }

    public void bubbleSorter(LogFile logFile){
        for (int out = amountOfElements - 1; out >= 1; out--){
            for (int in = 0; in < out; in++){
                if(arrayInt[in] > arrayInt[in + 1]){
                    logFile.info("Buble sorted: The elements of the array " + arrayInt[in] + " are replaced by " + arrayInt[in + 1] + "\n");
                    toSwap(in, in + 1);
                }
            }
        }
    }
}

class Calculator{
    private double numberA, nubmerB;
    private char choiceUser;
    private EnteringUserData userData = new EnteringUserData();

    public Calculator(LogFile logFile){
        numberA = userData.consoleEnterDouble("Enter number a: ", logFile);
        choiceUser = userData.consoleEnterAction("Enter action is + or - or / or * : ", logFile);
        nubmerB = userData.consoleEnterDouble("Enter number b: ", logFile);
        logFile.info("Simple calculator: User entered number " + numberA + " action " + choiceUser + " and number " + nubmerB + "\n");
    }
    public void performAnAction(LogFile logFile){
        switch(choiceUser){
            case '+':
                logFile.info("Simple calculator: Action result " + (numberA + nubmerB)+ "\n");
                break;
            case '-':
                logFile.info("Simple calculator: Action result " + (numberA - nubmerB)+ "\n");
                break;
            case '*':
                logFile.info("Simple calculator: Action result " + (numberA * nubmerB)+ "\n");
                break;
            case '/':
                logFile.info("Simple calculator: Action result " + (numberA / nubmerB)+ "\n");
                break;
        }
    }
}

class LogFile {
    private Logger logger = Logger.getLogger(LogFile.class.getName());
    private FileHandler fileHandler = null;

    public LogFile() {
        try {
            fileHandler = new FileHandler("ProjJava/less2/log.log", true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        fileHandler.setFormatter(new SimpleFormatter());
        logger.addHandler(fileHandler);
    }
    public void info(String message) {
        logger.info(message);
    }
    public void warning(String message) {
        logger.warning(message);
    }
}

class EnteringUserData{
    private Scanner in = new Scanner(System.in);
    //Ввод с клавиатуры только целочисленных чисел
    public int consoleEnterInt(String message, LogFile logFile){
        int valueInt;
        while(true){
            System.out.print(message);
            if(in.hasNextInt()){
                valueInt = in.nextInt();
                break;
            }else{
                logFile.warning(message + "Error enter user data\n");
                in.nextLine();
            }
        }
        return valueInt;
    }
    //Ввод с клавиатуры чисел с плавающей точкой
    public double consoleEnterDouble(String message, LogFile logFile){
        double doubleValue;
        while(true){
            System.out.print(message);
            if(in.hasNextDouble()){
                doubleValue = in.nextDouble();
                break;
            }else{
                logFile.warning(message + "Error enter user data\n");
                in.nextLine();
            }
        }
        return doubleValue;
    }
    //Ввод с клавиатуры действия для калькулятора
    public char consoleEnterAction(String message, LogFile logFile){
        char actionUser;
        while(true){
            System.out.print(message);
            actionUser = in.next().charAt(0);
            if(actionUser == '+' || actionUser == '-' || actionUser == '/' || actionUser == '*'){
                break;
            }else{
                logFile.warning(message + "Error enter user data\n");
                in.nextLine();
            }
        }
        return actionUser;
    }

    public void scannerClose(){
        in.close();
    }
}