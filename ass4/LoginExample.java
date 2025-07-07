import java.util.Scanner;
class LoginFailedException extends Exception {
    public LoginFailedException(String message) {
        super(message);
    }
}

public class LoginExample {
    public static void login(String username, String password) throws LoginFailedException {
        String Username = "admin";
        String Password = "pass123";

        if (!username.equals(Username) || !password.equals(Password)) {
            throw new LoginFailedException("Invalid username or password.");
        }

        System.out.println("Login successful!");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter username: ");
        String user = sc.nextLine();

        System.out.print("Enter password: ");
        String pass = sc.nextLine();

        try {
            login(user, pass);
        } catch (LoginFailedException e) {
            System.out.println("Login failed: " + e.getMessage());
        }

        sc.close();
    }
}
