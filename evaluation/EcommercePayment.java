

//Section-B Question2

package evaluation;
interface Payment{
	void pay();
}
class UpiPayment implements Payment{
	public  void pay() {
		System.out.println("Payment is done through UPI payment...");
	}
	
}
class CardPayment implements Payment{
	public  void pay() {
		System.out.println("Payment is done through card...");
	}
	
}
class CashOnDelivery implements Payment{
	public void pay() {
		System.out.println("Payment will be by cash on delivery...");
	}
	
}
public class EcommercePayment{
	
	public static void main(String[] args) {
		Payment upi=new UpiPayment();
		upi.pay();
		Payment card=new CardPayment();
		card.pay();
		Payment cod=new CashOnDelivery();
		cod.pay();
	}

}
