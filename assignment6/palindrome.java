import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class palindrome {
	static Deque<Character> original=new ArrayDeque<>();
	static boolean reverse(String s) {
		original.clear();
		StringBuilder sb= new StringBuilder();
		for(char c:s.toCharArray()) {
			original.add(c);
		}
		while(!original.isEmpty()) {
			sb.append(original.removeLast());
		}
		if(sb.toString().equals(s)) {
			return true;
		}
		else
			return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a word ");
		String word=sc.nextLine();
		if(reverse(word)) {
			System.out.println("Entered word is palindrome "+word);
		}
		else {
			System.out.println("Entered word is not palindrome "+word);
		}
	}

}
