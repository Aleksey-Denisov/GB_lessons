package ExceptionHandling.less1.module;

public class Module {
    //Деление на 0
    public void division(double firstNum, double secondNum){
        try{
            if(secondNum ==  0) throw new ArithmeticException("На ноль делить нельзя!!!");
            double result = firstNum/secondNum;
            System.out.printf("Результат деления %f на %f равен %f.\n", firstNum, secondNum, result);
        }catch(ArithmeticException ex){
            System.out.println(ex.getMessage());
        }

    }
    //Выход за границы массива
    public void printValueByIndex(int[] array, int index){
        try{
            if(index > array.length-1) throw new ArrayIndexOutOfBoundsException("Элемента под таким индексом не существует");
            else System.out.printf("Элемент с индексом %d равен %d.\n",index, array[index]);
        }catch(ArrayIndexOutOfBoundsException ex){
            System.out.println(ex.getMessage());
        }
    }
    //Пустой элемент
    public void printStringArray(String[] sArray){
        try{
            for (String item: sArray){
                if(item == null) throw new NullPointerException("Элемент отсутствует!!!");
                System.out.println(item);
            }
        }catch(NullPointerException ex){
            System.out.println(ex.getMessage());
        }
    }
    //Вычитание двух массивов в результирующий
    public int[] divArrays(int[] firstArray, int[] secondArray) {
        try{
            if(firstArray.length != secondArray.length) throw new RuntimeException("Длины массивов не равны!!!");
            int[] resultArr = new int[firstArray.length];
            for (int i = 0; i < resultArr.length; i++) {
                resultArr[i] = firstArray[i] - secondArray[i];
            }
            return resultArr;
        }catch(RuntimeException ex){
            System.out.println(ex.getMessage());
            return null;
        }
    }
    public  int[] divArrays2(int[] firstArray, int[] secondArray) {
        if (firstArray == null || secondArray == null) throw new RuntimeException("Нет массивов!!!");
        if(firstArray.length != secondArray.length) throw new RuntimeException("Длины массивов не равны!!!");
        int[] resultArr = new int[firstArray.length];
        for (int i = 0; i < resultArr.length; i++) {
            resultArr[i] = firstArray[i]/secondArray[i];
        }
        return resultArr;    
    }
}
