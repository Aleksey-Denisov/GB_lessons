package ProjJava.less4;
import java.util.*;

public class Less4 {
    public static void main(String[] args) {
        EnteringUserData userData = new EnteringUserData();
        // Пусть дан LinkedList с несколькими элементами. Реализуйте метод, который вернет “перевернутый” список.
        ListOperation listflip = new ListOperation(userData);
        listflip.flipList();
        listflip.printer();
        /*Реализуйте очередь с помощью LinkedList со следующими методами:
        enqueue() - помещает элемент в конец очереди, 
        dequeue() - возвращает первый элемент из очереди и удаляет его, 
        first() - возвращает первый элемент из очереди, не удаляя.*/
        ListOperation listOperation = new ListOperation(userData);
        listOperation.enqueue(userData);
        listOperation.printer();
        listOperation.dequeue();
        listOperation.first();
        listOperation.printer();
        //В калькулятор добавьте возможность отменить последнюю операцию.
        SimpleCalculator calculator = new SimpleCalculator(userData);
        calculator.performAnAction();
        
        userData.scannerClose();
    }
}
class SimpleCalculator{
    private double userNumber1, userNumber2;
    private char userAction;

    public SimpleCalculator(EnteringUserData userData){
        userNumber1 = userData.consoleEnterDouble("Enter first value: ");
        userAction = userData.consoleEnterAction("Enter action is + or - or / or * : ");
        //Думал сколько раз предлагать пользователю менять действие, потом подумал логично что действия 4
        //пусть 4 раза и меняет или оставляет как есть.
        for(int idChoice = 0; idChoice < 4; idChoice++){
            if(userData.consoleEnterConfirm("Confirm the action, specify y or n: ") == 'n')
                userAction = userData.consoleEnterAction("Enter action is + or - or / or * : ");
            else
                break;
        }
        userNumber2 = userData.consoleEnterDouble("Enter second value: ");
    }
    public void performAnAction(){
        switch(userAction){
            case '+':
                System.out.println("Action result " + (userNumber1 + userNumber2));
                break;
            case '-':
                System.out.println("Action result " + (userNumber1 - userNumber2));
                break;
            case '*':
                System.out.println("Action result " + (userNumber1 * userNumber2));
                break;
            case '/':
                System.out.println("Action result " + (userNumber1 / userNumber2));
                break;
        }
    }
}
class ListOperation{
    private LinkedList<Integer> linkListInt;
    private int amountOfElements;

    public ListOperation(EnteringUserData userData){
        amountOfElements = userData.consoleEnterInt("Enter the length of the list: ");
        linkListInt = new LinkedList<Integer>();
        for(int idElementArray = 0; idElementArray < amountOfElements; idElementArray++){
            linkListInt.add(userData.consoleEnterInt("Enter a value into the list item "+ idElementArray +": "));
        }
    }
    public void flipList(){
        for(int idElementBegin = 0, idElementEnd = linkListInt.size() - 1; idElementBegin < idElementEnd; idElementBegin++, idElementEnd--){
            linkListInt.set(idElementBegin, linkListInt.get(idElementBegin) + linkListInt.get(idElementEnd));
            linkListInt.set(idElementEnd, linkListInt.get(idElementBegin) - linkListInt.get(idElementEnd));
            linkListInt.set(idElementBegin, linkListInt.get(idElementBegin) - linkListInt.get(idElementEnd));
        }
    }
    public void printer(){
        System.out.println(linkListInt);
    }
    public void enqueue(EnteringUserData userData){
        Queue<Integer> queue = linkListInt;
        queue.add(userData.consoleEnterInt("Add an element to the end of the queue: "));
    }
    public void dequeue(){
        Deque<Integer> deque = linkListInt;
        System.out.println("Get the first element and remove it from the list: " + deque.pollFirst());
    }
    public void first(){
        Deque<Integer> deque = linkListInt;
        System.out.println("Get the first element from the list: " + deque.getFirst());
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
    //Ввод с клавиатуры чисел с плавающей точкой
    public double consoleEnterDouble(String message){
        double doubleValue;
        while(true){
            System.out.print(message);
            if(in.hasNextDouble()){
                doubleValue = in.nextDouble();
                break;
            }else{
                System.out.println("Error enter user data");
                in.nextLine();
            }
        }
        return doubleValue;
    }
    //Ввод с клавиатуры действия для калькулятора
    public char consoleEnterAction(String message){
        char actionUser;
        while(true){
            System.out.print(message);
            actionUser = in.next().charAt(0);
            if(actionUser == '+' || actionUser == '-' || actionUser == '/' || actionUser == '*'){
                break;
            }else{
                System.out.println("Error enter user data");
                in.nextLine();
            }
        }
        return actionUser;
    }
    //Подтверждение действия для калькулятора
    public char consoleEnterConfirm(String message){
        char choiceUser;
        while(true){
            System.out.print(message);
            choiceUser = in.next().charAt(0);
            if(choiceUser == 'y' || choiceUser == 'n'){
                break;
            }else{
                System.out.println("Error enter user data");
                in.nextLine();
            }
        }
        return choiceUser;
    }
    public void scannerClose(){
        in.close();
    }
}
