package ExceptionHandling.less2.controller;

import ExceptionHandling.less2.module.CodeHW;
import ExceptionHandling.less2.module.EnteringUserData;

public class FunkUD {
    private EnteringUserData ud = new EnteringUserData();
    private CodeHW codeHW = new CodeHW();
    public FunkUD() throws Exception{
        //1
        System.out.println(ud.consoleEnterFloat("Введите число с плавающей точкой: "));
        //Решил испробовать алтернативный метод ввода данных, вроде по проще, не знаю чем может быть черевато
        //System.out.println(ud.altEnterFloat("Введите число с плавающей точкой: "));
        //2
        codeHW.task2();
        CodeHW.task3();
        //3
        System.out.println(ud.consoleEnter("Введите строку: "));
        ud.scannerClose();
    }
}
