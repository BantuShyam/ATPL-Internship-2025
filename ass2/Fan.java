abstract class Appliance{
    abstract void turnOn(); 
    abstract void turnOff(); 
}
class  Tv extends Appliance {
    void turnOn(){
        System.out.println("TV is switched on");
    }
    void turnOff(){
        System.out.println("TV is switched off");
    }
}
class Fan extends Appliance{
    void turnOn(){
        System.out.println("Fan is switched on");
    }
    void turnOff(){
        System.out.println("Fan is switched off");
    }

    public static void main(String[] args){
        Tv t=new Tv();
        t.turnOn();
        t.turnOff();
        Fan f=new Fan();
        f.turnOn();
        f.turnOff();
    }
}
