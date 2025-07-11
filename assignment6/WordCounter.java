// package assignments;
import java.util.*;
public class WordCounter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String, Integer> wordCount = new HashMap<>();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter text (press Enter twice to finish):");
		int emptyCount=0;
		while (true) {
			String line = scanner.nextLine();
			   if (line.trim().isEmpty()) {
                emptyCount++;
                if (emptyCount == 2) {
                    break;
                }
                continue;
            } else {
                emptyCount = 0;
            }
			String[] words = line.split("\\W+");
			for (String word : words) {
				word = word.toLowerCase();
				if (!word.isEmpty()) {
					wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
				}
			}	
		}
		for(Map.Entry<String,Integer> entry:wordCount.entrySet()){
			System.out.println(entry.getKey() +" has occurred "+entry.getValue()+" times");
		}
	}

}
