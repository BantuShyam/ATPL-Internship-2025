import java.util.*;

public class UniqueWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a sentence:");
        String sentence = scanner.nextLine();
        String[] words = sentence.toLowerCase().split("[\\s.:;]+");
        HashSet<String> uniqueWords = new HashSet<>();
        for (String word : words) {
            if (!word.isEmpty()) {
                uniqueWords.add(word);
            }
        }
        System.out.println("Unique words:");
        for (String word : uniqueWords) {
            System.out.println(word);
        }
        scanner.close();
    }
}