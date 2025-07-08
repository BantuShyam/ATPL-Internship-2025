class Animal {
    void makeSound(){
        System.out.println("some sound");
    }
}
 class Dog extends Animal{
    void makeSound(){
        System.out.println("dog barks");
    }
}
class Cat extends Animal{
    void makeSound(){
        System.out.println("cat meows...");
    }
}
public class Cow extends Animal{
    void makeSound(){
        System.out.println("cow sounds");
    }
    public static void main(String[] args){
        Animal a1=new Dog();
        Animal a2=new Cat();
        Animal a3=new Cow();
        a1.makeSound();
        a2.makeSound();
        a3.makeSound();
        
    }
}
