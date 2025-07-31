

public class Book{
    String title;
    String author;
    int price;
    double finalPrice;

//    Book(String title,int price,double discountPercent){
//         this.title=title;
//         this.price=price;
//         this.discount=discountPercent;
//    }
public void discount(String name,int price,double discount){
    this.finalPrice=price-(price*discount/100);
    System.out.println(name+" final price is "+finalPrice);
}
   

    public static void main(String[] args){
        Book b1=new Book();
        b1.discount("java",150,12.5);
        Book b2=new Book();
        b2.discount("python",100,9.5);
        Book b3=new Book();
        b3.discount("dbms",500,25);


    }
}