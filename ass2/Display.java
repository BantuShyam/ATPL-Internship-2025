
public class Display {
    void show(int a,int b){
        System.out.println("The integers are "+a+" and "+b);
    }
    void show(String a,String b){
        System.out.println("The Strings are "+a+" and "+b);
    }
    void show(int a[]){
        for(int i=0;i<a.length;i++){
        System.out.println(a[i]);
    }
}
    public static void main(String[] args){
        Display d=new Display();
        d.show(5,2);
        d.show("kohli","rohit");
        d.show(new int[]{1,4,6});

    }
}