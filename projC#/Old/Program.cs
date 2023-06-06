using System;
//Вызываю по порядку функции с решениями
twoval();
threeval();
provVal();
outVal();
secondVal();
thirdVal();
dayWeek();
//функция для ввода целых чисел
int inputdata(int x){
    bool prov=false;
    int val=0;
    while (!prov){
        try{
            Console.Write("Input value "+x+": ");
            val=Convert.ToInt32(Console.ReadLine());
            prov=true;
        }
        catch{
            Console.WriteLine("Error numbers");
        }
    }
    return val;
}
//Задача 2: Напишите программу, которая на вход принимает два числа и выдаёт, какое число большее, а какое меньшее.
void twoval(){
    Console.WriteLine("Task 1:");
    int val1=inputdata(1);
    int val2=inputdata(2);
    if(val1>val2){
        Console.WriteLine("Max value "+val1+", Min value"+val2);
    }else{
        Console.WriteLine("Max value "+val2+", Min value "+val1);
    }
}
//Задача 4: Напишите программу, которая принимает на вход три числа и выдаёт максимальное из этих чисел
void threeval(){
    Console.WriteLine("Task 2:");
    int[] val = new int[3];
    for(int i=0;i<3;i++){
        val[i]=inputdata(i+1);
    }
    int maxVal=val[0];
    for(int i=0;i<3;i++){
        if(maxVal<val[i])
            maxVal=val[i];
    }
    Console.WriteLine("Max value "+maxVal+"\n");
}
//Задача 6: Напишите программу, которая на вход принимает число и выдаёт, является ли число чётным (делится ли оно на два без остатка).
void provVal(){
    Console.WriteLine("Task 3:");
    int val=inputdata(1);
    if(val % 2==0){
        Console.WriteLine("Yes");
    }else{
        Console.WriteLine("No");
    }
}
//Задача 8: Напишите программу, которая на вход принимает число (N), а на выходе показывает все чётные числа от 1 до N.
void outVal(){
    Console.WriteLine("Task 4:");
    int val=inputdata(1);
    for(int i=1;i<=val;i++){
        if(i % 2==0){
            Console.Write(i+" ");
        }
    }
    Console.Write("\n");
}
//Задача 10: Напишите программу, которая принимает на вход трёхзначное число и на выходе показывает вторую цифру этого числа.
void secondVal(){
    Console.WriteLine("Task 5:");
    bool prov=false;
    int val=0;
    while (!prov){
        try{
            val=inputdata(1);
            if (val>99 && val<1000)
                prov=true;
        }
        catch{
            Console.WriteLine("Error numbers");
        }
    }
    string str=Convert.ToString(val);
    Console.WriteLine(str[1]);
}
//Задача 13: Напишите программу, которая выводит третью цифру заданного числа или сообщает, что третьей цифры нет.
void thirdVal(){
    Console.WriteLine("Task 6:");
    int val=inputdata(1);
    string str=Convert.ToString(val);
    if(str.Length>=3 && str[0]!='-')
        Console.WriteLine(str[2]);
    else if(str.Length>3 && str[0]=='-')
        Console.WriteLine(str[3]);
    else
        Console.WriteLine("Not third number");
}
//Задача 15: Напишите программу, которая принимает на вход цифру, обозначающую день недели, и проверяет, является ли этот день выходным.
void dayWeek(){
    Console.WriteLine("Task 7:");
    int val=inputdata(1);
    if(val<=7 && val>=6)
        Console.WriteLine("Yes");
    else if(val<=5 && val>=1)
        Console.WriteLine("No");
    else
        Console.WriteLine("Error number");
}