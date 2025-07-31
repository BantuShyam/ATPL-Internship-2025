abstract class Shape{
   abstract void draw();
}

public class AnonymousClass2 {
    public static void main(String[] args) {
        Shape s=new Shape(){
            void draw(){
                System.out.println("draw circle shape.....");
            }
        };
        s.draw();
    }
    
}
