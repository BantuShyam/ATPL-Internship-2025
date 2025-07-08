interface Greeting{
    public void sayHello();
}

public class AnonymousClass1 {
    public static void main(String[] args){
        Greeting g=new Greeting(){
            public void sayHello(){
                System.out.println("hello India....");
            }
        };
        g.sayHello();
    }
}
