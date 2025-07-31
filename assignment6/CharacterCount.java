
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CharacterCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        Map<Character,Integer> count=new HashMap<>();
        for(char ch:str.toCharArray()){
            if(ch!=' '){
                count.put(ch,count.getOrDefault(ch,0)+1);
            }
        }
        System.out.println("Character occurences ");
        for(Map.Entry<Character,Integer> entry:count.entrySet()){
            System.out.println(entry.getKey()+": " + entry.getValue());
        }
    }
}