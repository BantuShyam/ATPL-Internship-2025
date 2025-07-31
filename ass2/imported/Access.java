package imported;
public class Access {
    private String name1="kohli";
    public String name2="dhoni";
    protected String name3="rohit";
    String name4="gill";
    public static void main(String[] args) {
        Access a=new Access();
    System.out.println("private string is"+a.name1);
    System.out.println("public string is"+a.name2);
    System.out.println("protected string is"+a.name3);
    System.out.println("default string is"+a.name4);
    }
}