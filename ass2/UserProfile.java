class User{
    private String username;
    private String password;
    private String email;
    void setUser(String user){
        this.username=user;
    }
    void getUser(){
        System.out.println("user is "+username);
    }
    void setPassword(String password){
        if(password.length()>3){
        this.password=password;
        }
    }
    void getPassword(){
        System.out.println("password is "+password);
    }
    void setEmail(String e){
        this.email=e;
    }
    void getEmail(){
        System.out.println("email is "+email);
    }

}
public class UserProfile extends User{
    public static void main(String[] args) {
        User u=new User();
        u.setUser("kohli");
        u.setPassword("nov51988");
        u.setEmail("kohli@18");
        u.getUser();
        u.getEmail();
        u.getPassword();
    }
}
