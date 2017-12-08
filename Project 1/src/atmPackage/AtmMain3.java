package atmPackage;

public class AtmMain3 {

	public static void main(String[] args) {

		System.out.println("Testing ATM takeOut method\n");

		ATM s2 = new ATM(2, 1, 3);
		System.out.println("ATM s2 = new ATM(2,1,3) \n" + s2.toString());

		ATM temp = s2.takeOut(250);
		System.out.println("ATM temp = s2.takeOut(250)\n" + temp.toString());
		System.out.println("Remaining in ATM:\n" + s2.toString());
	}

}