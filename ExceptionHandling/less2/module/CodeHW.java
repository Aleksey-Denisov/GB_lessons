package ExceptionHandling.less2.module;

public class CodeHW {
    public void task2(){
        try {
            int d = 0;
            //В прошлой реализации не объявлен и не проинициализирован массив, так как все равно делится на 0
            //Без разницы какое число я укажу
            int[] intArray = new int[10];
            for (int idElement = 0; idElement < 10; idElement++) {
                intArray[idElement] = (int)(Math.random() * 100);
            }
            double catchedRes1 = intArray[8] / d;
            System.out.println("catchedRes1 = " + catchedRes1);
        } catch (ArithmeticException e) {
            System.out.println("Catching exception: " + e);
        }
    }
    public static void task3() throws Exception{
        try {
            int a = 90;
            int b = 3;
            System.out.println(a / b);
            printSum(23, 234);
            int[] abc = { 1, 2 };
            abc[3] = 9;
        } catch (NullPointerException ex) {
            System.out.println("Указатель не может указывать на null!");
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("Массив выходит за пределы своего размера!");
        } catch (Throwable ex) {
            System.out.println("Что-то пошло не так...");
        }
    }
    public static void printSum(Integer a, Integer b) throws ArithmeticException {
        System.out.println(a + b);
    }
}
