using System;

numPow();
sumNum();
inputArr();
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
//Задача 25: Напишите цикл, который принимает на вход два числа (A и B) и возводит число A в натуральную степень B.
void numPow(){
    Console.WriteLine("Task 1:");
    int a = inputdata("Enter number A");
    int b = inputdata("Enter number B");
    //Console.WriteLine("The number A to the power of B is "+Math.Pow(a,b));
    int sum = 1;
    for(int i = 0; i < b; i++){
        sum *= a;
    }
    Console.WriteLine("The number A to the power of B is " + sum);
}
//Задача 27: Напишите программу, которая принимает на вход число и выдаёт сумму цифр в числе.
void sumNum(){
    Console.WriteLine("Task 2:");
    int val = inputdata("Enter number");
    int sum = 0;
    while(val > 0){
        sum += val % 10;
        val /= 10;
    }
    Console.WriteLine("Sum of all elements "+sum);
}
//Задача 29: Напишите программу, которая задаёт массив из 8 элементов и выводит их на экран.
void inputArr(){
    Console.WriteLine("Task 3:");
    int[] arr = new int[8];
    for(int i = 0; i < 8; i++){
        arr[i]=inputdata("Enter number in array "+i);
    }
    Console.WriteLine("[{0}]", string.Join(", ", arr));
}