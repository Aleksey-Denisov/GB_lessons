package ExceptionHandling.less2.module;

import java.io.*;
import java.util.*;

public class EnteringUserData {
    private Scanner in = new Scanner(System.in);
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public float consoleEnterFloat(String message){
        float floatValue;
        while(true){
            try{
                System.out.print(message);
                if(in.hasNextFloat()){
                    floatValue = in.nextFloat();
                    break;
                }else{
                    in.nextLine();
                    throw new IOException("Указанные данные не являются числом с плавающей точкой");
                }
            }catch(IOException|NumberFormatException ex){
                System.out.println(ex.getMessage());
            }
        }
        return floatValue;
    }
    public float altEnterFloat(String message){
        float value;
        while(true){
            System.out.print(message);
            try{
                value = Float.parseFloat(reader.readLine());
                break;
            }catch(IOException|NumberFormatException e) {
                System.out.println("Указанные данные не являются числом с плавающей точкой");
            }
        }
        return value;
    }
    public String consoleEnter(String message){
        String userData;
        while(true){
            System.out.print(message);
            try{
                userData = in.nextLine();
                if(userData.equals(""))
                    throw new RuntimeException("Введенная строка не должна быть пустой");
                else
                    break;
            }catch(RuntimeException ex){
                System.out.println(ex.getMessage());
            }
        }
        return userData;
    }
    public void scannerClose(){
        in.close();
    }
}
