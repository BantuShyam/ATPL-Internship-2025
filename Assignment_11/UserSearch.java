import java.util.*;
import java.util.function.Function;

class User {
    private String name;
    private String email;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public Optional<String> getEmail() {
        return Optional.ofNullable(email);
    }
}

public class UserSearch {
    public static void main(String[] args) {
        List<User> users = Arrays.asList(
            new User("Shyam","shyam18@gmail.com"),
            new User("Balaram", null),
            new User("Sai", "sai21@gmail.com"),
            new User("Manoj", null)
        );

        String searchName = "Shyam";
        Function<String, String> toUpperCase = String::toUpperCase;
        users.stream()
            .filter(user -> user.getName().equalsIgnoreCase(searchName))
            .findFirst()
            .flatMap(User::getEmail)
            .map(toUpperCase)
            .ifPresentOrElse(
                email -> System.out.println("Uppercase Email: " + email),
                () -> System.out.println("Email not available or user not found")
            );
    }
}
