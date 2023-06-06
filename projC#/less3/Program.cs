using System;
palindorm();
distancePoint();
cubeN();
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
//Напишите программу, которая принимает на вход пятизначное число и проверяет, является ли оно палиндромом.
void palindorm(){
    Console.WriteLine("Task 1:");
    bool prov=false;
    int val;
    string str;
    while (!prov){
        val=inputdata("Enter 5 digit number!");
        str=Convert.ToString(val);
        if (str.Length==5){
            for (int i = 0, j = str.Length - 1; i < j; i++, j--){
                if (str[i] != str[j]){
                    Console.WriteLine("The number is not a palindorm");
                    return;
                }
            }
            Console.WriteLine("The number is a palindorm");
            prov=true;
        }else{
            Console.WriteLine("Enter 5 digit number!");
        }
    } 
}
//Напишите программу, которая принимает на вход координаты двух точек и находит расстояние между ними в 3D пространстве.
void distancePoint(){
    Console.WriteLine("Task 2:");
    int[] a = new int[3];
    int[] b = new int[3];
    for(int i=0;i<3;i++){
        a[i]=inputdata("Enter coordinate "+i+" for point A");
    }for(int i=0;i<3;i++){
        b[i]=inputdata("Enter coordinate "+i+" for point B");
    }
    double distance = Math.Sqrt(Math.Pow(b[0] - a[0], 2) + Math.Pow(b[1] - a[1], 2) + Math.Pow(b[2] - a[2], 2));
    Console.WriteLine("Distance between points A and B = "+distance);      
}
//Напишите программу, которая принимает на вход число (N) и выдаёт таблицу кубов чисел от 1 до N.
void cubeN(){
    Console.WriteLine("Task 3:");
    int val=inputdata("Enter number N");
    for(int i=1; i<=val; i++){
        Console.Write(Math.Pow(i,3)+" ");
    }
}