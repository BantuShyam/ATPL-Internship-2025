public class Library {
    String name="kohli";
    class Book{
        public void display(){
            System.out.println("Indian player");
        System.out.println("name is "+name);
        }
    }
    public static void main(String[] args) {
        Library lb=new Library();
        Library.Book b=lb.new Book();
        b.display();
    }
}
