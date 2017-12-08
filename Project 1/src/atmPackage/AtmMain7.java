package atmPackage;

public class AtmMain7 {

	public static void main(String[] args) {
		
		System.out.println("Testing ATM takeOut method\n" );
		
		ATM s2 = new ATM(3,50,2);
		System.out.println("ATM s2 = new ATM(3,50,2) \n" + s2.toString( ) );
		
		ATM temp = s2.takeOut(60);
		System.out.println ("ATM temp = s2.takeOut(110)\n" + temp.toString() );
		System.out.println("Remaining in ATM:\n" + s2.toString( ) );
	}

}