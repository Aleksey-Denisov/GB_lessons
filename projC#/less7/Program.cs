//mnArray();
//findInArr();
midlArr();
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
//Задача 47. Задайте двумерный массив размером m×n, заполненный случайными вещественными числами.
void mnArray(){
    Console.WriteLine("Task 1:");
    int m=inputInt("Enter number m");
    int n=inputInt("Enter number n");
    Random rnd = new Random();
    double[,] arr = new double[m,n];
    for(int i = 0; i < m; i++){
        for(int j = 0; j < n; j++){
            arr[i,j] = Math.Round(rnd.NextDouble() * (10 - 0) + 0,3);
            Console.Write("{0}\t",arr[i, j]);
        }
    Console.WriteLine();
    }
}
//Задача 50. Напишите программу, которая на вход принимает позиции элемента в двумерном массиве, и возвращает значение этого элемента или же указание, что такого элемента нет.
void findInArr(){
    Console.WriteLine("Task 2:");
    int m=inputInt("Enter number m");
    int n=inputInt("Enter number n");
    Random rnd = new Random();
    double[,] arr = new double[m,n];
    for(int i = 0; i < m; i++){
        for(int j = 0; j < n; j++){
            arr[i,j] = Math.Round(rnd.NextDouble() * (10 - 0) + 0,3);
            Console.Write("{0}\t",arr[i, j]);
        }
    Console.WriteLine();
    }
    int a = inputInt("Enter number a");
    int b = inputInt("Enter number b");
    if(a >= m){
        Console.WriteLine("Element does not exist");
    }else if(b >= n){
        Console.WriteLine("Element does not exist");
    }else{
        Console.WriteLine(arr[a,b]);
    }

}
//Задача 52. Задайте двумерный массив из целых чисел. Найдите среднее арифметическое элементов в каждом столбце.
void midlArr(){
    Console.WriteLine("Task 3:");
    int m=inputInt("Enter number m");
    int n=inputInt("Enter number n");
    int[,] arr = new int[m,n];
    double[] sum = new double[n];
    for(int i = 0; i < m; i++){
        for(int j = 0; j < n; j++){
            arr[i,j] = inputInt("Enter number in element array");
            sum[j]+=arr[i,j];
        }
    }
    for(int i = 0; i < n; i++){
        sum[i]=sum[i]/m;
    }
    Console.WriteLine("[{0}]", string.Join(", ", sum));
}