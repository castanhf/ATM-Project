package atmPackage;

public class AtmMain2 {

	public static void main(String[] args) {
		
		System.out.println("Testing ATM putIn method\n" );
		
		ATM s1 = new ATM();	
		System.out.println("ATM s1 = new ATM() \n" + s1.toString( ) );

		s1.putIn(10,2,3);
		System.out.println("s1.putIn(10,2,3) \n" + s1.toString() );

		s1.putIn(0,0,0);
		System.out.println("s1.putIn(0,0,0) \n" + s1.toString( ) );
	}

}