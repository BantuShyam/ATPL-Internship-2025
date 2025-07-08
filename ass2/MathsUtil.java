public class MathsUtil {
    int a;
    int b;
    public void calculate(int a,int b){
        int c=a+b;
        System.out.println("addition value is"+c);
    }
    public void calculate(double a,double b){
        double c=a*b;
        System.out.println("Multiplication value is"+c);
    }
    public static void main(String args[]){
        MathsUtil mu=new MathsUtil();
        mu.calculate(5,4);
        mu.calculate(34.0,78.0);
    }
}
