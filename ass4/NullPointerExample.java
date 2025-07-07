public class NullPointerExample {
    public static void main(String[] args){
    String text=null;
    try{
        System.out.println(text.length());
    }
    catch(NullPointerException e){
        System.out.println("the exception is : "+e.getStackTrace());
    }

}
}
