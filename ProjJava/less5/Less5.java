package ProjJava.less5;
import java.util.*;
import java.util.stream.Collectors;

public class Less5 {
    public static void main(String[] args) {
        EnteringUserData userData = new EnteringUserData();
        //Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь несколько телефонов.
        System.out.println("Task1");
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.addElement(userData);
        phoneBook.printer();
        //Написать программу, которая найдет и выведет повторяющиеся имена с количеством повторений. Отсортировать по убыванию популярности.
        System.out.println("Task2");
        HashSort sortPeple = new HashSort();
        sortPeple.collectMap();
        sortPeple.sort();
        sortPeple.printer();
        //Реализовать алгоритм пирамидальной сортировки (HeapSort).
        System.out.println("Task3");
        HeapSort heapSort = new HeapSort();
        heapSort.enterUserData(userData);
        heapSort.sorter();
        heapSort.printer();
        // Написать метод, который переведёт данное целое число в римский формат.
        System.out.println("Task4");
        RomanNumerals romanNumerals = new RomanNumerals(userData);
        romanNumerals.convertToRoman();
        romanNumerals.printer();
        /*Взять набор строк, например, "Мороз и солнце день чудесный Еще ты дремлешь друг прелестный Пора красавица проснись."
        Написать метод, который отсортирует эти строки по длине с помощью TreeMap. Строки с одинаковой длиной не должны “потеряться”. */
        System.out.println("Task5");
        SortTree sortTree = new SortTree();
        sortTree.absolute();

        userData.scannerClose();
    }
}
class PhoneBook{
    private Map<String, ArrayList<String>> phoneBook;

    public PhoneBook(){
        phoneBook = new HashMap<>();
    }
    public void addElement(EnteringUserData userData){
        while(true){
            ArrayList<String> phoneNumber = new ArrayList<>();
            String subscriber = userData.consoleEnter("Enter the subscriber's name: ");
            if(phoneBook.containsKey(subscriber)){
                phoneNumber = phoneBook.get(subscriber);
            }
            phoneNumber.add(userData.consoleEnter("Enter phone number: "));
            phoneBook.put(subscriber, phoneNumber);
            if(userData.consoleEnterConfirm("continue? y or n: ")=='n'){
                break;
            }
        }
    }
    public void printer(){
        System.out.println(phoneBook);
    }
}
class HashSort{
    private HashMap<String,Integer> sortMap;
    private static final String[] listPeople = {
        "Иван Иванов",
        "Светлана Петрова",
        "Кристина Белова",
        "Анна Мусина",
        "Анна Крутова",
        "Иван Юрин",
        "Петр Лыков",
        "Павел Чернов",
        "Петр Чернышов",
        "Мария Федорова",
        "Марина Светлова",
        "Мария Савина",
        "Мария Рыкова",
        "Марина Лугова",
        "Анна Владимирова",
        "Иван Мечников",
        "Петр Петин",
        "Иван Ежов"};

    public HashSort(){
        sortMap = new HashMap<>();
    }
    public void collectMap(){
        for(String line : listPeople){
            int valReplayName = 1;
            String name = line.split(" ")[0];
            if(sortMap.containsKey(name)){
                valReplayName = sortMap.get(name);
                valReplayName++;
            }
            sortMap.put(name,valReplayName);
        }
    }
    public void sort(){
        sortMap = sortMap.entrySet().stream()
        .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
    }
    public void printer(){
        System.out.println(sortMap);
    }
}
class HeapSort{
    private ArrayList<Integer> heapSort;
    private int amountOfElements;

    public HeapSort(){
        heapSort = new ArrayList<>();
    }
    public void enterUserData(EnteringUserData userData){
        amountOfElements = userData.consoleEnterInt("Enter the number of items to add: ");
        for(int idElementArray = 0; idElementArray < amountOfElements; idElementArray++){
            heapSort.add(userData.consoleEnterInt("Enter an element " + idElementArray + " into the list: "));
        }
    }
    public void sorter(){
        heapSort = heapSort(heapSort, heapSort.size());
    }
    private ArrayList<Integer> heapSort(ArrayList<Integer> sortList,int size){
        if (size == 1) return sortList;

        int lastParent = findLastParentIndex(size);

        for (int parent = lastParent; parent >= 0; parent--) {
            int leftChild = parent * 2 + 1;
            int rightChild = parent * 2 + 2;
            if (leftChild == size - 1) 
                rightChild = leftChild;
            int max = leftChild;
            if (sortList.get(rightChild) > sortList.get(max)) 
                max = rightChild;
            if (sortList.get(parent) < sortList.get(max)) 
                swapIndexes(sortList, max, parent);
        }
        swapIndexes(sortList, 0, size - 1);
        return heapSort(sortList, size - 1);
    }
    private void swapIndexes(ArrayList<Integer> sortList, int idElementA, int idElementB) {
        Collections.swap(sortList, idElementA, idElementB);
    }
    private int findLastParentIndex(int size){
        int idElement;
        if (size % 2 == 0){
            idElement = (size - 1) / 2;
        }else{
            idElement = (size - 2) / 2;
        }
        return idElement;
    }
    public void printer(){
        System.out.println(heapSort);
    }
}
class RomanNumerals{
    private Map<String, Integer> romanNums = new HashMap<String,Integer>(){{
        put("I", 1); put("IV", 4); put("V", 5); put("IX", 9); put("X", 10);
        put("XL", 40); put("L", 50); put("XC", 90); put("C", 100); 
        put("CD", 400); put("D", 500); put("CM", 900); put("M", 1000);
    }};
    private int userInt;
    private String resultRomanValue = "";
    public RomanNumerals(EnteringUserData userData){
        userInt = userData.consoleEnterInt("Enter the number: ");
    }
    private void sort(){
        romanNums = romanNums.entrySet().stream()
        .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
    }
    public void convertToRoman(){
        sort();
        while (userInt > 0) {
            for(Map.Entry<String, Integer> collectionsVals : romanNums.entrySet()){
                if(collectionsVals.getValue() <= userInt){
                    resultRomanValue += collectionsVals.getKey();
                    userInt -= collectionsVals.getValue();
                    break;
                }
            }
        }
    }
    public void printer(){
        System.out.println(resultRomanValue);
    }
}
class SortTree{
    private Map<Integer, ArrayList<String>> resultMap = new TreeMap<>();
    private String line = "Мороз и солнце день чудесный еще ты дремлешь друг прелестный пора красавица проснись";

    public void absolute(){
        for(String word : line.split(" ")){
            if (resultMap.containsKey(word.length()))
                resultMap.get(word.length()).add(word);
            else
                resultMap.putIfAbsent(word.length(), new ArrayList<>(List.of(word)));
        }
        for(Map.Entry<Integer, ArrayList<String>> entry : resultMap.entrySet()){
            System.out.printf("Lines by number %d of characters: %s\n", entry.getKey(), entry.getValue());
        }
    }

}
class EnteringUserData{
    private Scanner in = new Scanner(System.in);
    //Ввод с клавиатуры только целочисленных чисел
    public int consoleEnterInt(String message){
        int valueInt;
        while(true){
            System.out.print(message);
            if(in.hasNextInt()){
                valueInt = in.nextInt();
                in.nextLine();
                break;
            }else{
                System.out.println("Error enter user data");
                in.nextLine();
            }
        }
        return valueInt;
    }
    public String consoleEnter(String message){
        String userData;
        while(true){
            System.out.print(message);
            userData = in.nextLine();
            if(userData != ""){
                break;
            }else{
                System.out.println("The entered value must not be missing");
            }
        }
        return userData;
    }
    public char consoleEnterConfirm(String message){
        char choiceUser;
        while(true){
            System.out.print(message);
            choiceUser = in.next().charAt(0);
            if(choiceUser == 'y' || choiceUser == 'n'){
                in.nextLine();
                break;
            }else{
                System.out.println("Error enter user data");
                in.nextLine();
            }
        }
        return choiceUser;
    }
    public void scannerClose(){
        in.close();
    }
}
