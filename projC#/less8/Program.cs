sortStrArr();
findMinSumRow();
multyMatrix();
tArr();
spArr();
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
//Задача 54: Задайте двумерный массив. Напишите программу, которая упорядочит по убыванию элементы каждой строки двумерного массива.
void sortStrArr(){
    Console.WriteLine("Task 1:");
    int m = inputInt("Enter number m");
    int n = inputInt("Enter number n");
    int[,] arr = new int[m, n];
    for(int i = 0; i < m; i++){
        for(int j = 0; j < n; j++){
            arr[i, j] = inputInt("Enter number in row " + i + " col " + j);
        }
        for(int j = 0; j < n; j++){
            for(int k = 0; k < n-1; k++){
                if(arr[i, k] < arr[i, k + 1]){
                    int temp = arr[i, k];
                    arr[i, k] = arr[i, k + 1];
                    arr[i, k + 1] = temp;
                }
            }
        }
    }
    for(int i = 0; i < m; i++){
        for(int j = 0; j < n; j++){
            Console.Write("{0}\t",arr[i, j]);
        }
    Console.WriteLine();
    }
}
//Задача 56: Задайте прямоугольный двумерный массив. Напишите программу, которая будет находить строку с наименьшей суммой элементов.
void findMinSumRow(){
    Console.WriteLine("Task 2:");
    int m = inputInt("Enter number m");
    int n = inputInt("Enter number n");
    int[,] arr = new int[m, n];
    int[] sumArr = new int[m];
    for(int i = 0; i < m; i++){
        for(int j = 0; j < n; j++){
            arr[i, j] = inputInt("Enter number in row " + i + " col " + j);
            sumArr[i] += arr[i, j];
        }
    }
    int minIndex = 0;
    int temp = sumArr[minIndex];
    for(int j = 1; j < m; j++){
        if(temp < sumArr[j]){
            temp = sumArr[j];
            minIndex = j;
        }
    }
    Console.WriteLine("The smallest sum of elements in a row {0}",minIndex);
}
//Задача 58: Задайте две матрицы. Напишите программу, которая будет находить произведение двух матриц.
void multyMatrix(){
    Console.WriteLine("Task 3:");
    int[,] a = newMat("Enter matrix A");
    int[,] b = newMat("Enter matrix B");
    multiplication(a, b);
}
int[,] newMat(string str){
    Console.WriteLine(str);
    int m = inputInt("Enter number m");
    int n = inputInt("Enter number n");
    int[,] x = new int[m,n];
    for(int i = 0; i < m; i++){
        for(int j = 0; j < n; j++){
            x[i, j] = inputInt("Enter number in row " + i + " col " + j);
        }
    }
    return x;
}
void printConsoleS(int[,] x){
    for(int i = 0; i < x.GetLength(0); i++){
        for(int j = 0; j < x.GetLength(1); j++){
            Console.Write("{0}\t",x[i, j]);
        }
    Console.WriteLine();
    }
}
void multiplication(int[,] a, int[,] b){
    if(a.GetLength(1) != b.GetLength(0)){
        Console.WriteLine("Matrices cannot be multiplied");
        return;
    } 
    int[,] c = new int[a.GetLength(0), b.GetLength(1)];
    for(int i = 0; i < a.GetLength(0); i++){
        for(int j = 0; j < b.GetLength(1); j++){
            for(int k = 0; k < b.GetLength(0); k++){
                c[i, j] += a[i, k] * b[k, j];
            }
        }
    }
    printConsoleS(c);
}
//Задача 60. ...Сформируйте трёхмерный массив из неповторяющихся двузначных чисел. Напишите программу, которая будет построчно выводить массив, добавляя индексы каждого элемента.
void tArr(){
    Console.WriteLine("Task 4:");
    int x = inputInt("Enter number x");
    int y = inputInt("Enter number y");
    int z = inputInt("Enter number z");
    if(x * y * z < 90){
        newArr(x, y, z);
    }else{
        Console.WriteLine("Error");
    } 
}
void newArr(int x, int y, int z){
    int[, ,] arr = new int[x,y,z];
    Random rnd = new Random();
    for(int i = 0; i < x; i++){
        for(int j = 0; j < y; j++){
            for(int k = 0; k < z; k++){
                int tempInt = rnd.Next(10,99);
                if(!(Contains(arr, tempInt))){
                    arr[i, j, k] = tempInt;
                }else{
                    k--;
                }
            }
        }
    }
    printConsoleT(arr);
}
void printConsoleT(int[, ,] arr){
    for(int i = 0; i < arr.GetLength(0); i++){
        for(int j = 0; j < arr.GetLength(1); j++){
            for(int k = 0; k < arr.GetLength(2); k++){
                Console.Write("{0}({1},{2},{3})\t",arr[i, j, k], i, j, k);
            }
            Console.WriteLine();
        }
        Console.WriteLine();
    }
}
bool Contains(int[, ,] arr, int a){
    for(int i = 0; i < arr.GetLength(0); i++){
        for(int j = 0; j < arr.GetLength(1); j++){
            for(int k = 0; k < arr.GetLength(2); k++){
                if (arr[i, j, k] == a) 
                    return true;
            }
        }
    }
    return false;
}
//Задача 62. Напишите программу, которая заполнит спирально массив 4 на 4.
void spArr(){
    Console.WriteLine("Task 4:");
    int n = inputInt("Enter number n");
    int[,] array = new int[n,n];
    int s = 1;
    int a = 2, b = 1;
    if(n % 2 == 1)
        n++;//Было лень искать стандартный метод округления в большую сторону при нечетных числах
    for(int i = 0; i < n / 2; i++){
        for (int y = i; y < array.GetLength(0) - i; y++) {
            array[i, y] = s;
            s++;
        }
        for (int x = b + i; x < array.GetLength(0) - i; x++) {
            array[x, array.GetLength(0) - b - i] = s;
            s++;
        }
        for (int y = array.GetLength(0) - a - i; y >= i; y--) {
            array[array.GetLength(0) - b - i, y] = s;
            s++;
        }
        for (int x = array.GetLength(0) - a - i; x > i; x--) {
            array[x, i] = s;
            s++;
        }
    }
    printConsoleS(array);
}
