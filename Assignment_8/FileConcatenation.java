import java.io.*;

public class FileConcatenation {
    public static void main(String[] args) {
        String file1 = "input.txt";
        String file2 = "input2.txt";
        String outputFile = "mergeFile.txt";

        try (
            BufferedReader reader1 = new BufferedReader(new FileReader(file1));
            BufferedReader reader2 = new BufferedReader(new FileReader(file2));
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))
        ) {
            String line;
            while ((line = reader1.readLine()) != null) {
                writer.write(line);
                writer.newLine();
            }
            while ((line = reader2.readLine()) != null) {
                writer.write(line);
                writer.newLine();
            }

            System.out.println("Files have been successfully concatenated into " + outputFile);

        } catch (FileNotFoundException e) {
            System.err.println("input files was not found: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("error occurred: " + e.getMessage());
        }
    }
}
