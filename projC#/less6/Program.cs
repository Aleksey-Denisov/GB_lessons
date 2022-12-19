inputNum();
intersectionOfLine();
//функция для ввода целых чисел
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
double inputDoub(string x){
    bool prov=false;
    double val=0;
    while (!prov){
        try{
            Console.Write(x+": ");
            val=Convert.ToDouble(Console.ReadLine());
            prov=true;
        }
        catch{
            Console.WriteLine("Error numbers");
        }
    }
    return val;
}
//Пользователь вводит с клавиатуры M чисел. Посчитайте, сколько чисел больше 0 ввёл пользователь.
void inputNum(){
    Console.WriteLine("Task 1:");
    int val=inputInt("How many numbers will we enter?");
    double doub=0;
    int sum=0;
    for(int i=0;i<val;i++){
        doub=inputDoub("Enter element "+i);
        if(doub>0){
            sum++;
        }
    }
    Console.WriteLine("The user entered "+ sum +" numbers greater than zero");
}
//Напишите программу, которая найдёт точку пересечения двух прямых, заданных уравнениями y = k1 * x + b1, y = k2 * x + b2; значения b1, k1, b2 и k2 задаются пользователем.
void intersectionOfLine(){
    Console.WriteLine("Task 2:");
    double k1=inputDoub("Enter k1");
    double b1=inputDoub("Enter b1");
    double k2=inputDoub("Enter k2");
    double b2=inputDoub("Enter b2");
    double x = Math.Round(-(b1 - b2) / (k1 - k2),3);
    double y = Math.Round(k1 * x + b1,3);
    Console.WriteLine($"intersection in point: ({x};{y})");
}