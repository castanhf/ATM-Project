package atmPackage;

public class AtmMain4 {

	public static void main(String[] args) {
		
		System.out.println("Testing ATM save, load, and equals methods\n" );
		
		
		ATM s1 = new ATM (5, 4, 3);
		System.out.println("ATM s1 = new ATM(5,4,3) \n" + s1.toString( ) );

		s1.save("pizza");
		
		System.out.println();
		
		ATM s2 = new ATM();
		s2.load("pizza");
		
		System.out.println();
		System.out.println("s1.save(\"pizza\")\n" + s1.toString( ) );
		System.out.println("s2.load(\"pizza\")\n" + s2.toString( ) );

		if (s2.equals(new ATM(5,4,3))) 
		{
			System.out.println ("\nThe save, load, and equals methods work!");
		}
	}

}