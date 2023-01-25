package ProjJava.less2;
import java.util.Scanner;
import java.util.logging.*;

public class Less2 {
    public static void main(String[] args) {
        LogFile logFile = new LogFile();
        //Реализуйте алгоритм сортировки пузырьком числового массива, результат после каждой итерации запишите в лог-файл.
        ArrayBubble ab = new ArrayBubble();
        ab.bubbleSorter(logFile);
        ab.printer(logFile);
        //К калькулятору из предыдущего дз добавить логирование.
        Calculator calc = new Calculator();
        calc.performAnAction(logFile);
    }
    
}

class ArrayBubble {
    private int[] arrayInt;
    private int amountOfElements;
    private String forLog = "";
    private EnteringUserData userData = new EnteringUserData();

    public ArrayBubble(){
        amountOfElements = userData.consoleEnterInt("Enter the size of the array: ");
        arrayInt = new int[amountOfElements];
        
        for(int idElementArray = 0; idElementArray < amountOfElements; idElementArray++){
            arrayInt[idElementArray] = userData.consoleEnterInt("Enter a value into an array element "+ idElementArray +": ");
            forLog += arrayInt[idElementArray] + " ";
        }
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
        logFile.info("Buble sorted: An array of " + amountOfElements + " elements has been created\n");
        logFile.info("Buble sorted: The user enters " + forLog + "\n");
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

    public Calculator(){
        numberA = userData.consoleEnterDouble("Enter number a: ");
        choiceUser = userData.consoleEnterAction("Enter action is + or - or / or * : ");
        nubmerB = userData.consoleEnterDouble("Enter number b: ");
    }
    public void performAnAction(LogFile logFile){
        logFile.info("Simple calculator: User entered number " + numberA + " action " + choiceUser + " and number " + nubmerB + "\n");
        switch(choiceUser){
            case '+':
                System.out.println(numberA + nubmerB);
                logFile.info("Simple calculator: Action result " + (numberA + nubmerB)+ "\n");
                break;
            case '-':
                System.out.println(numberA - nubmerB);
                logFile.info("Simple calculator: Action result " + (numberA - nubmerB)+ "\n");
                break;
            case '*':
                System.out.println(numberA * nubmerB);
                logFile.info("Simple calculator: Action result " + (numberA * nubmerB)+ "\n");
                break;
            case '/':
                System.out.println(numberA / nubmerB);
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
