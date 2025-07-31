interface Moveable{
    void move();
}
class Car implements Moveable{
    public void move(){
        System.out.println("Car is moving");
    }
}
class Robot implements Moveable{
    public void move(){
        System.out.println("Robor is moving");
    }
}
class Drone implements Moveable{
    public void move(){
        System.out.println("drone is moving");
    }
    public static void main(String[] args) {
        Moveable c=new Car(); 
        c.move();
        Moveable r=new Robot(); 
        r.move();
        Moveable d=new Drone(); 
        d.move();
       
    }
}

