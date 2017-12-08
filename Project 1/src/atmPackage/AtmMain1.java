package atmPackage;

public class AtmMain1 {

	public static void main(String[] args) {
		
		System.out.println("Testing ATM constructor\n" );
		
		ATM s = new ATM(4,8,2);
		System.out.println("ATM s = new ATM(4,8,2) \n" + s.toString( ) );
		System.out.println( s.getAmount() + " dollars" );
	}

}