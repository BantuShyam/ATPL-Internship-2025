public class Laptop {
    String brand;
     int ram;
    String processor;
    int price;
    Laptop(String brand,int ram,String processor){
        this.brand=brand;
        this.ram=ram;
        this.processor=processor;
    }
    Laptop(String brand,int price){
        this.brand=brand;
        this.price=price;
        System.out.println(brand+" laptop price is "+price);
    }
    void display(){
        System.out.println("laptop is of "+brand+" and RAM is"+ram);
    }
    public static void main(String[] args){
        Laptop l1=new Laptop("dell",8,"i5");
        l1.display();
        Laptop l2=new Laptop("hp",16,"i7");
        l2.display();
        Laptop l3=new Laptop("apple",130000);
}
}