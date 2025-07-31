public class Circle {
    private double radius;
    private double area;
    private double circumference;
    void setArea(double a){
        if(a!=0){
        this.radius=a;
        }
    }
    void getArea(){
        area=(Math.pow(radius,2))*3.14;
        System.out.println("Area is "+area);
    }
    void getCircumference(){
        circumference=2*3.14*radius;
        System.out.println("Circumference is "+circumference);
    }
    public static void main(String[] args) {
        Circle c=new Circle();
        c.setArea(3);
        c.getArea();
        c.getCircumference();
    }

}
