package atmPackage;

public class AtmMain6 {

	public static void main(String[] args) {

		System.out.println("Testing ATM takeOut method\n");

		ATM s2 = new ATM(1, 1, 4);
		System.out.println("ATM s2 = new ATM(1,1,4)\n" + s2.toString());

		ATM temp = s2.takeOut(110);
		System.out.println("ATM temp = s2.takeOut(110)\n" + temp.toString());
		System.out.println("Remaining in ATM:\n" + s2.toString());
	}
}