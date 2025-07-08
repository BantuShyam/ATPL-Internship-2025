public class Student {
     static String schoolName="St.Joseph's";
     Student(String s){
        this.schoolName=s;
     }
     void display(){
            System.out.println("School name is "+schoolName);
        }
    public static void main(String[] args) {
       Student s1=new Student("Bhashyam");
       Student s2=new Student("sri chaitanya");
       s1.display();
       s2.display();
    }
}
