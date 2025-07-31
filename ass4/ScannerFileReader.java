import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ScannerFileReader {
    public static void scanFile(String fileName) {
        try (Scanner scanner = new Scanner(new File(fileName))) {
            System.out.println("File Content:");
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        scanFile("sample.txt");
    }
}
