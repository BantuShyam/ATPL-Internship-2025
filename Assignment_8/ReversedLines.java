import java.io.*;

public class ReversedLines {
    public static void main(String[] args) {
        String inputFile = "input.txt";
        String outputFile = "reversed.txt";

        try (
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))
        ) {
            String line;
            while ((line = reader.readLine()) != null) {
                String reversedLine = new StringBuilder(line).reverse().toString();
                writer.write(reversedLine);
                writer.newLine();
            }

            System.out.println("Reversed lines written to " + outputFile);

        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + inputFile);
        } catch (IOException e) {
            System.err.println("Error during file I/O: " + e.getMessage());
        }
    }
}
