import java.util.Optional;
import java.util.Scanner;
import java.util.function.Supplier;
public class LazyConfigLoader {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter configuration value");
        String value=scanner.nextLine();
        Optional<String> configFromSource = value.isEmpty() ? Optional.empty(): Optional.of(value);
        Supplier<String> loadConfig = () -> {
            System.out.println("Loading config...");
            return "LoadedConfig";
        };
        String finalConfig = configFromSource.orElseGet(loadConfig);

        System.out.println("Final config: " + finalConfig);
    }
}