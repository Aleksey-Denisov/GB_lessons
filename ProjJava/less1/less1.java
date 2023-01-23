package ProjJava.less1;
import java.util.Scanner;

public class less1 {
    public static void main(String[] args) {
        //Вычислить n-ое треугольного число(сумма чисел от 1 до n), n! (произведение чисел от 1 до n)
        SumAndMulty();
        //Вывести все простые числа от 1 до 1000
        SimpleNumbers();
        //Реализовать простой калькулятор
        SimpleCalculator();
        //*+Задано уравнение вида q + w = e, q, w, e >= 0. Некоторые цифры могут быть заменены знаком вопроса, например 2? + ?5 = 69.
        //Требуется восстановить выражение до верного равенства. Предложить хотя бы одно решение или сообщить, что его нет.
        SolEquation();
    }
    private static void SumAndMulty(){
        System.out.println("Task 1");
        int number =  ConsoleEnterInt("Enter number:");
        SumNumbers(number);
        FactotialNumbers(number);
    }
    private static void SimpleNumbers(){
        System.out.println("Task 2");
        boolean b = true;
        int sum = 0;
        for (int i = 2; i <= 1000; i++){
            for (int j = 2; j < i; j++){
                if (i % j == 0) {
                    b = false;
                    break;
                }
            }
            if(b){
                System.out.print(i + " ");
                sum++;
                if(sum % 30 ==0)
                    System.out.println();
            }else{
                b = true;
            }
        }
        System.out.println();
    }
    private static void SimpleCalculator(){
        System.out.println("Task 3");
        double a = ConsoleEnterDouble("Enter number a:");
        char d = ConsoleEnterAction("Enter action is + or - or / or *");
        double b = ConsoleEnterDouble("Enter number b:");
        PerfAction(a,b,d);

    }
    private static void SolEquation(){
        System.out.println("Task 4");
        System.out.println("Type expression q? + ?w = e");
        int q =  ConsoleEnterInt("Enter number q:");
        int w =  ConsoleEnterInt("Enter number w:");
        int e =  ConsoleEnterInt("Enter number e:");
        if(q > 0 && w > 0 && e > 0)
            MagicSol(q,w,e);
        else
            System.out.println("Error enter");
    }
    //Ввод с клавиатуры только целочисленных чисел
    private static int ConsoleEnterInt(String X){
        int a;
        Scanner in = new Scanner(System.in);
        while(true){
           try{
                System.out.println(X);
                a = in.nextInt();
                break;
            }
            catch(Exception ex){
                System.out.println("Error");
            }
        }
        return a;
    }
    //Ввод с клавиатуры чисел с плавающей точкой
    private static double ConsoleEnterDouble(String X){
        double d = 0;
        Scanner in = new Scanner(System.in);
        while(true){
            try{
                System.out.println(X);
                d = Double.parseDouble(in.nextLine());
                break;
            }
            catch(Exception ex){
                System.out.println("Error");
            }
        }
        return d;
    }
    //Ввод с клавиатуры действия для калькулятора
    private static char ConsoleEnterAction(String X){
        char a;
        Scanner in = new Scanner(System.in);
        while(true){
            try{
                System.out.println(X);
                a = in.next().charAt(0);
                if(a == '+' || a == '-' || a == '/' || a == '*')
                    break;
                else
                    System.out.println("Error");
            }
            catch(Exception ex){
                System.out.println("Error");
            }
        }
        return a;
    }
    private static void MagicSol(int a, int b, int c){
        //Учитываем что первое число всегда двузначное, решение в целом всегда может быть я думаю, но скажем если число получается отрицательное, то решения нет
        int res = c - (a * 10 + b);
        if(res>0){
            int res1 = res / 10;
            int res2 = res % 10;
            System.out.println(a + "? + ?" +  b + " = " + c);
            System.out.println((a * 10 + res2) + " + " + (res1 * 10 + b) + " = " + c);
        }else{
            System.out.println("No solution");
        }
    }
    private static void PerfAction(double a, double b, char d){
        switch(d){
            case '+':
                System.out.println(a + b);
                break;
            case '-':
                System.out.println(a - b);
                break;
            case '*':
                System.out.println(a * b);
                break;
            case '/':
                System.out.println(a / b);
                break;
        }
    }
    private static void SumNumbers(int x){
        int sumNumbers = 0;
        for(int i = 1; i <= x; i++){
            sumNumbers += i;
        }
        System.out.println("The sum of numbers up to "+ x + " is "+ sumNumbers);
    } 
    private static void FactotialNumbers(int x){
        int multiply = 1;
        for(int i=2;i<=x;i++){
            multiply *= i;
        }
        System.out.println( x + "! is "+ multiply);
    }

}