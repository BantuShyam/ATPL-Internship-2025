class Payment{
    void processPayment(){
        System.out.println("payment starts");
    }
}
class UpiPayment extends Payment{
    @Override
    void processPayment(){
        System.out.println("process is done through upi...");
    }
}
class CreditCardPayment extends Payment{
    void processPayment(){
        System.out.println("payment is done through credit card...");
    }
    public static void main(String[] args){
        Payment p=new Payment();
        p.processPayment();
         UpiPayment p1=new UpiPayment();
        p1.processPayment();
         CreditCardPayment p2=new CreditCardPayment();
        p2.processPayment();
    }
}