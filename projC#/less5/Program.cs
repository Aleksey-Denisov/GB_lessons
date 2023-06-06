using System;
arrRand();
arrPos();
arrDif();
//функция для ввода целых чисел
int inputdata(string x){
    bool prov=false;
    int val=0;
    while (!prov){
        try{
            Console.Write(x+": ");
            val=Convert.ToInt32(Console.ReadLine());
            prov=true;
        }
        catch{
            Console.WriteLine("Error numbers");
        }
    }
    return val;
}
//Задача 34: Задайте массив заполненный случайными положительными трёхзначными числами. Напишите программу, которая покажет количество чётных чисел в массиве.
void arrRand(){
    Console.WriteLine("Task 1:");
    int lenArr = inputdata("Enter lenght array");
    Random rnd = new Random();
    int[] arr = new int[lenArr];
    int val = 0;
    for(int i = 0; i < lenArr; i++){
        arr[i] = rnd.Next(100,999);
        if(arr[i] % 2 == 0){
            val++;
        }
    }
    Console.WriteLine("[{0}]", string.Join(", ", arr));
    Console.WriteLine("Number of even numbers in array is "+val);
}
//Задача 36: Задайте одномерный массив, заполненный случайными числами. Найдите сумму элементов, стоящих на нечётных позициях.
//Так как не указано для кого считать, считаю как это видит программа, то есть с 0. В 5 элементном массиве увидим сумму двух чисел на нечетных индексах.
//Если надо как для человека то есть с первого элемента, как нечетного, поменять if(i % 2 == 1) на  if(i % 2 == 0)
void arrPos(){
    Console.WriteLine("Task 2:");
    Random rnd = new Random();
    int lenArr = inputdata("Enter lenght array");
    int[] arr=new int[lenArr];
    int sum = 0;
    for(int i = 0; i < lenArr; i++){
        arr[i] = rnd.Next(0,9);
        if(i % 2 == 1){
            sum += arr[i];
        }
    }
    Console.WriteLine("[{0}]", string.Join(", ", arr));
    Console.WriteLine("Sum of numbers in odd position is "+sum);
}
//Задача 38: Задайте массив вещественных чисел. Найдите разницу между максимальным и минимальным элементов массива
//Не понял что такое вещественные числа, по этому на всякий случай сделал все с плавающей точкой
void arrDif(){
    Console.WriteLine("Task 3:");
    int lenArr = inputdata("Enter lenght array");
    double[] arr=new double[lenArr];
    double maxElement=0;
    double minElement=0;
    for(int i=0;i<lenArr;i++){
        bool prov=false;
        while (!prov){
            try{
                Console.Write("Enter element "+ i +" in array: ");
                arr[i]=Convert.ToDouble(Console.ReadLine());
                prov=true;
            }
            catch{
                Console.WriteLine("Error input");
            }
        }
        if(i==0){
            maxElement=arr[i];
            minElement=arr[i];
        }else if(maxElement<arr[i]){
            maxElement=arr[i];
        }else if(minElement>arr[i]){
            minElement=arr[i];
        }
    }
    Console.WriteLine("Difference between max and min elements "+(maxElement-minElement));
}