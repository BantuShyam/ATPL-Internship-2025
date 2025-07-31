// Define the custom exception class
class LoginFailedException extends Exception {
    
    // Constructor that accepts a custom message
    public LoginFailedException(String message) {
        super(message); // Pass the message to the superclass (Exception)
    }
}


public class LoginSystem {
    public static void main(String[] args) {
        try {
            login("user", "wrongpassword");
        } catch (LoginFailedException e) {
            System.out.println("Login failed: " + e.getMessage());
        }
    }

    public static void login(String username, String password) throws LoginFailedException {
        if (!"correctpassword".equals(password)) {
            throw new LoginFailedException("Invalid login details");
        }
    }
}
