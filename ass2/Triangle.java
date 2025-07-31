
abstract class Shape {
    abstract void area(); 
}
class Square extends Shape{
    double side;
    Square(double s){
        side=s;
    }
    void area(){
        System.out.println(side*side);
    }
}
class Triangle extends Shape{
    double base;
    double height;
    Triangle(double b,double h){
        base=b;
        height=h;
    }
    void area(){
         System.out.println(0.5*base*height);
    }
    public static void main(String[] args){
        Triangle t=new Triangle(10,10);
        t.area();
        Square s=new Square(5);
        s.area();
    }
}

