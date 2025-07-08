public class Vehicle {
    String brand;
    int price;
    String colour;
   void start(){
        System.out.println("Vehicle ");
    }
    public static void main(String[] args){
        Vehicle v1=new Vehicle();
        v1.start();
         Vehicle v2=new Bike();
        v2.start();
         Vehicle v3=new Car();
        v3.start();
}

}
class Bike extends Vehicle{
    String brand="pulsar";
    int price=150000;
    void start(){
        System.out.println(brand+"bike of price "+price+"is started");
    }
}
class Car extends Vehicle{
     String brand="suzuki";
    int price=650000;
    
    public void start(){
        System.out.println(brand+"car of price "+price+"is started");
    }

}
