class Final1 {
    public final void finalMethod(){
        System.out.println("This is a final method");
    }
}
public class Final extends Final1{
    // void finalMethod(){
    //     System.out.println("Final method inside extended class");
    // }
    public static void main(String[] args) {
        Final f=new Final();
        f.finalMethod();
    }
}
