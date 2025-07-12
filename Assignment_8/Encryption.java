import java.io.*;
import java.util.Scanner;

public class Encryption {
    private static final String file = "encrypted.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a message to encrypt: ");
        String plain = scanner.nextLine();                                                                          
        String encrypted = toggleCase(reverse(plain));
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            bw.write(encrypted);
            System.out.println("Encrypted text written to " + file);
        } catch (IOException e) {
            System.err.println("Error writing file: " + e.getMessage());
            return;
        }
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String cipher = br.readLine();
            if (cipher == null) {
                System.err.println("File is empty  nothing to decrypt.");
                return;
            }
            String decrypted = reverse(toggleCase(cipher));
            System.out.println("Decrypted message: " + decrypted);
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
    private static String reverse(String text) {
        return new StringBuilder(text).reverse().toString();
    }
    private static String toggleCase(String text) {
        StringBuilder sb = new StringBuilder(text.length());
        for (char ch : text.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                sb.append(Character.toLowerCase(ch));
            } else if (Character.isLowerCase(ch)) {
                sb.append(Character.toUpperCase(ch));
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}
