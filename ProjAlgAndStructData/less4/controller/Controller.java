package ProjAlgAndStructData.less4.controller;
import ProjAlgAndStructData.less4.module.SelfHashMap;

public class Controller {
    private SelfHashMap<Integer, Integer> hm;
    private SelfHashMap<String, String[]> strArr;
    public Controller(){
        hm = new SelfHashMap<>();
        //Добавляем рандомные данные в хэшмап
        for (int idElement = 0; idElement < 20; idElement++) {
			int data = (int)(Math.random() * 100);
            hm.put(idElement, data);
		}
        System.out.println("Получение данных по ключу: " + hm.get(2));
        //Замена значения по ключу
        hm.replays(2, 2058);
        //Проверка наличия данных по значению
        if(hm.containsValue(2058)){
            System.out.println("Значение имеется");
        }
        System.out.println("Размер массива: " + hm.size());
        //Удаление данных по ключу
        hm.remove(2);
        //Проверка наличия данных по ключу
        if(!hm.containsKey(2)){
            System.out.println("По такому ключу данных нет");
        }
        System.out.println("Размер массива: " + hm.size());
        hm.printer();
        System.out.println("---------------------------------");
        //Для эксперимента с другими типами данных и массивом
        strArr = new SelfHashMap<>();
        strArr.put("Str", new String[]{"sfds2","234234"});
        strArr.put("sec", new String[]{"454","fbfgh"});
        if(strArr.containsKey("Str")){
            for(String s : strArr.get("Str")){
                System.out.println(s);
            }
        }
        strArr.remove("Str");
        strArr.replays("Str", new String[]{"sfds2","234234"});
    }
}
