class SystemUtils {
    static String log="loging";
    static class Logger{
        static void display(){
            System.out.print(log);
        }

    }
}
public class Nested{
    public static void main(String args[]){
        SystemUtils sys=new SystemUtils();
        SystemUtils.Logger log= new SystemUtils.Logger();
        SystemUtils.Logger.display();
    }
}