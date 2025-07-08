class Parent1 {
     void parentMethod(){
        System.out.println("Parent class method");
     }
}
class Child extends Parent1{
    @Override
    void parentMethod() {
        super.parentMethod();
        System.out.println("child class ");
    }
}
public class Test {
    public static void main(String[] args) {
        Child c=new Child();
        c.parentMethod();
    }
}
