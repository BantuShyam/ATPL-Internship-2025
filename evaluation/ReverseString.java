
//section-A question2

package evaluation;

import java.util.Scanner;

public class ReverseString {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		String original=scanner.nextLine();
		char[] character=original.toCharArray();
		String reversed="";
		for(int i=character.length-1;i>=0;i--) {
			reversed=reversed +character[i];
		}
		System.out.println("Reversed String is "+reversed);
	}
}
