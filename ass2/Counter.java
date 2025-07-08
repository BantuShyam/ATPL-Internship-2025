public class Counter {
     static int count=1;
     Counter(){
        System.out.println("count is "+count);
        count++;
        }
    public static void main(String[] args) {
       Counter c1=new Counter();
       Counter c2=new Counter();
    }
    
}
