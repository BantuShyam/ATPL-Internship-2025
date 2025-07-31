import java.util.*;
public class VectorEx {
    public static void main(String[] args) {
        Vector<Double> v=new Vector<Double>();
        Scanner s= new Scanner(System.in);
        System.out.println("Enter the elements ");
        for(int i=0;i<4;i++)
        {
            double d=s.nextDouble();
            v.add(d);

        }
        Enumeration<Double> e=v.elements();
         System.out.println("The Elements in vector are : ");
        while(e.hasMoreElements()){
            System.out.println(e.nextElement()+" ");
        }

s.close();

    }
}
