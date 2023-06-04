package ExceptionHandling.less1.controller;
import ExceptionHandling.less1.module.Module;
public class Controller {
    private Module module;
    public Controller(){
        module = new Module();
        //1
        module.division(5.435,0.00);
        module.printValueByIndex(new int[]{1,2,3,45,634,65},22);
        module.printStringArray(new String[]{"234234","sdfgdfg",null,"ergfdg"});
        //2
        module.divArrays(new int[]{3,56,3,436,5,765,23}, new int[]{2,4,6,8,3});
        //3
        module.divArrays2(null, null);

    }
}
