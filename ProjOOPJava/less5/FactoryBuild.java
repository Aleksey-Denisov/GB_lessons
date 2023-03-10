package ProjOOPJava.less5;

public class FactoryBuild {
    public static FactoryAction getTransport(FactoryEnum type){
        FactoryAction action = null;

        switch(type){
            case BIKE:
                action = new Bike();
                break;
            case ELECTRICSCOOTER:
                action = new ElectricScooter();
                break;
            case FOOTS:
                action = new Foots();
                break;
            case QUADCOPTER:
                action = new QuadCopter();
                break;
            default:
                break;
        }
        return action;
    }
}
