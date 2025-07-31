class Parent {
     Parent(){
        System.out.println("Parent class");
     }
}
class Child extends Parent{
    Child(){
        super();
        System.out.println("child class ");
    }
}
class Test {
    public static void main(String[] args) {
        Child c=new Child();
    }
}

