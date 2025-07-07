class LoginFailedException extends Exception{
    public  LoginFailedException(String msg){
        super(msg);
    }
}
public class Login{
    public static void main(String[] args) {
        try{
                password("shy");
                System.out.println("login successful");
        }
        catch(LoginFailedException lg){
            System.out.println("error... "+lg.getMessage());
        }
        void password(String s){
            if(s.length()<3){
                throw new LoginFailedException("small password....");
            }
            else{
               System.out.println("Password is okkk...");
            }
        }
}
}
