import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileReader {

    // Method to read file using try-with-resources
    public static void readFileSafely(String fileName) {
        // Try-with-resources block
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;

            System.out.println("File Content:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    // Main method
    public static void main(String[] args) {
        // Call the method with your file name
        readFileSafely("sample.txt");
    }
}
