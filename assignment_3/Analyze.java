public class Analyze{
    public static void main(String[] args) {
        String s="Learning Java is fun and interesting";
        String[] words=s.split(" ");
        int wordCount=words.length;
        System.out.println("Number of words in string is " + wordCount);
        int first=s.indexOf('a');
        System.out.println("The position of first 'a' is: " + first);
        int last=s.lastIndexOf('a');
        System.out.println("The position of last 'a' is: " + last);
        System.out.println("Is Sentence starts with Learn "+s.startsWith("Learn"));
        System.out.println("Is Sentence ends with ing "+s.endsWith("ing"));
    }
}