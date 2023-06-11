package ExceptionHandling.less3.module;

import java.io.IOException;

public class InsertData{
    private EnteringUD userData;
    public InsertData(){
        userData = new EnteringUD();
    }
    private String[] splitData(){
        while(true){
            try{
                String[] splitUserData = userData.consoleEnter("Укажите Фамилия Имя Отчество номертелефона: ").split(" ");
                if(splitUserData.length == 4)
                    return splitUserData;
                else if(splitUserData.length < 4){
                    throw new IOException("Введенных вами данных не достаточно проверьте правильность ввода!\n"
                    + "Пример правильного ввода: Иванов Иван Иванович 88005553535");
                }else if(splitUserData.length > 4){
                    throw new IOException("Введенные данные превышают количество требуемых параметров, проверьте правильность ввода!\n"
                    + "Пример правильного ввода: Иванов Иван Иванович 88005553535");
                }
            }catch(IOException ex){
                System.out.println(ex.getMessage());
            }
        }
    }
    public void checkType(){
        while(true){
            try{
                String[] splitUData = splitData();
                //Получилось костыльно и с кодировкой так и не довоевал
                int sumElem = 0;
                for(int idElement = 0; idElement < splitUData.length; idElement++){
                    if((idElement < 3 && splitUData[idElement].matches(".*\\p{InCyrillic}.*") || splitUData[idElement].matches("[A-Za-z]+")) 
                        || (idElement == 3 && splitUData[idElement].matches("[0-9]+"))){
                        sumElem++;
                    }else{
                        throw new IOException("Указаны неверные данные: " + splitUData[idElement]);
                    }
                }
                if(sumElem == 4){
                    new WriteFile(splitUData);
                    break;
                }
            }catch(IOException ex){
                System.out.println(ex.getMessage());
            }
        }
    }
}