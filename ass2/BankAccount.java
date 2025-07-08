public class BankAccount {
    double balance;
    String accno;
    BankAccount(String accno,double balance){
        this.accno=accno;
        this.balance=balance;
    }
    public void deposit(int money){
        balance+=money;
    }
     public void withdraw(int money){
        if(balance>0 && balance>money){
        balance-=money;
        }
        else{
            System.out.println("No sufficient funds");
        }
    }
     public void checkBalance(){
        System.out.println("Account Balance is "+balance);
    }
    public static void main(String[] args){
        BankAccount b1=new BankAccount("UB143",15000);
        b1.deposit(3000);
        b1.withdraw(4500);
        b1.checkBalance();
        BankAccount b2=new BankAccount("SBI1687",24000);
        b2.deposit(3600);
        b2.withdraw(4100);
        b2.checkBalance();
    }
}
