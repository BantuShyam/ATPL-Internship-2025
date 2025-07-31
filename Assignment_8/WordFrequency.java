import java.io.*;
import java.util.*;

public class WordFrequency {
    public static void main(String[] args) {
        String inputFile  = "input.txt";
        String outputFile = "word_frequencies.txt";

        Map<String, Integer> wordCounts = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.toLowerCase().split("\\W+");
                for (String word : words) {
                    if (!word.isEmpty()) {
                        wordCounts.put(word, wordCounts.getOrDefault(word, 0) + 1);
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading from " + inputFile + ": " + e.getMessage());
            return;
        }
        List<Map.Entry<String, Integer>> sortedEntries = new ArrayList<>(wordCounts.entrySet());

        sortedEntries.sort(
            Comparator.comparingInt(Map.Entry<String, Integer>::getValue)
                      .reversed()                                         
                      .thenComparing(Map.Entry::getKey)                   
        );
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            for (Map.Entry<String, Integer> entry : sortedEntries) {
                writer.write(entry.getKey() + " : " + entry.getValue());
                writer.newLine();
            }
            System.out.println("Word frequencies written to " + outputFile);
        } catch (IOException e) {
            System.err.println("Error writing to " + outputFile + ": " + e.getMessage());
        }
    }
}
