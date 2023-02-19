package ProjOOPJava.less2;
import java.util.*;

public class EnteringUserData {
    private Scanner in = new Scanner(System.in);
    //Ввод с клавиатуры только целочисленных чисел
    public int consoleEnterInt(String message, int size){
        int valueInt;
        while(true){
            System.out.print(message);
            if(in.hasNextInt()){
                valueInt = in.nextInt();
                if(valueInt < size){
                    in.nextLine();
                    break;
                }else{
                    System.out.println("Error enter user data");
                }
            }else{
                System.out.println("Error enter user data");
                in.nextLine();
            }
        }
        return valueInt;
    }
    public String consoleEnter(String message){
        String userData;
        while(true){
            System.out.print(message);
            userData = in.nextLine();
            if(userData != ""){
                break;
            }else{
                System.out.println("The entered value must not be missing");
            }
        }
        return userData;
    }
    public char consoleEnterConfirm(String message){
        char choiceUser;
        while(true){
            System.out.print(message);
            choiceUser = in.next().charAt(0);
            if(choiceUser == 'y' || choiceUser == 'n'){
                in.nextLine();
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
