public class Person {
   void action(){
        System.out.println("Person ");
    }
    public static void main(String[] args){
        Person p1=new Person();
        p1.action();
        Person p2=new Teacher();
        p2.action();
        Person p3=new Student();
        p3.action();
}
}

class Teacher extends Person{
    void action(){
        System.out.println("Teacher teaches");
    }
}
class Student extends Person{
    public void action(){
        System.out.println("Student listens");
    }

}
