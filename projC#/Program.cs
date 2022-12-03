//Вызываю по порядку функции с решениями
twoval();
threeval();
provVal();
outVal();
//функция для ввода целых чисел
int inputdata(int x){
    Console.Write("Input value "+x+": ");
    int val=Convert.ToInt32(Console.ReadLine());
    return val;
}
//Задача 2: Напишите программу, которая на вход принимает два числа и выдаёт, какое число большее, а какое меньшее.
void twoval(){
    Console.WriteLine("Task 1:");
    int val1=inputdata(1);
    int val2=inputdata(2);
    if(val1>val2){
        Console.Write("Max value "+val1+", Min value"+val2+"\n");
    }else{
        Console.Write("Max value "+val2+", Min value "+val1+"\n");
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
    Console.Write("Max value "+maxVal+"\n");
}
//Задача 6: Напишите программу, которая на вход принимает число и выдаёт, является ли число чётным (делится ли оно на два без остатка).
void provVal(){
    Console.WriteLine("Task 3:");
    int val=inputdata(1);
    if(val % 2==0){
        Console.Write("Yes\n");
    }else{
        Console.Write("No\n");
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
}