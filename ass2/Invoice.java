interface Printable{
    void print();
}
class Document implements Printable {
    public void print(){
        System.out.println("Document is being printed");
    }
}
class Image implements Printable{
    public void print(){
        System.out.println("Image is being printed");
    }
}
class Invoice implements Printable{
    public void print(){
        System.out.println("Invoice is being printed");
    }
    public static void main(String[] args) {
        Printable d=new Document(); 
        d.print();
        Printable i=new Image();
        i.print(); 
        Printable in=new Invoice();
        in.print(); 
    }
}
