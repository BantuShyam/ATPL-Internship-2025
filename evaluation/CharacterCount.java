
//section-A question1

package evaluation;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CharacterCount {
	public static void main(String[] args) {
		Map<Character,Integer> count=new HashMap<>();
		Scanner scanner=new Scanner(System.in);
		String word=scanner.nextLine().toLowerCase();
		for(char ch:word.toCharArray()) {
			if(ch!=' ') {
			count.put(ch, count.getOrDefault(ch,0)+1);
			}
		}
		for(Map.Entry<Character,Integer> entry:count.entrySet()) {
			System.out.println(entry.getKey()+" has repeated "+entry.getValue()+" times ");
		}
		scanner.close();
		
	}
}
