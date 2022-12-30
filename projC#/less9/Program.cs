rec();
sumEl();
akkerNum();
int inputInt(string x){
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
//Задача 64: Задайте значение N. Напишите программу, которая выведет все натуральные числа в промежутке от N до 1. Выполнить с помощью рекурсии.
void rec(){
    Console.WriteLine("Task 1:");
    int a = inputInt("Enter number");
    printVal(a);
    Console.WriteLine();
}
void printVal(int x){
    if(x > 1){
        Console.Write(x+",");
        x--;
        printVal(x);
    }else if(x == 1){
        Console.Write(x);
    }
}
//Задача 66: Задайте значения M и N. Напишите программу, которая найдёт сумму натуральных элементов в промежутке от M до N.
void sumEl(){
    Console.WriteLine("Task 2:");
    while(true){
        int m = inputInt("Enter number M");
        int n = inputInt("Enter number N");
        int sum;
        if(m<n){
            sum = sbSum(m,n);
            Console.WriteLine(sum);
            break;
        }else{
            Console.WriteLine("Error input");
        }
    }
}
int sbSum(int m, int n){
    if(m<n){
        return m + sbSum(m+1, n);
    }
    return m;
}
//Задача 68: Напишите программу вычисления функции Аккермана с помощью рекурсии. Даны два неотрицательных числа m и n.
void akkerNum(){
    Console.WriteLine("Task 3:");
    while(true){
        int m = inputInt("Enter number M");
        int n = inputInt("Enter number N");
        int result;
        if(m >= 0 && n >= 0){
            result = res(m,n);
            Console.WriteLine(result);
            break;
        }else{
            Console.WriteLine("Error input");
        }
    }
}
int res(int m, int n){
    if(m == 0)
        return n + 1;
    else if((m != 0) && (n == 0))
        return res(m - 1, 1);
    else
        return res(m - 1, res(m, n - 1));
}