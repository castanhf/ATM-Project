package atmPackage;

import java.io.*;
import java.util.*;

public class ATM {

	private int hundreds;
	private int fifties;
	private int twenties;
	private static boolean suspend;
	
	/**
	 * Default constructor that sets the ATM to zero
	 */
	public ATM() {
		this.hundreds = 0;
		this.fifties = 0;
		this.twenties = 0;		
	}

	/**
	 * Access method getHundreds()
	 * @return the int this.hundreds 
	 */
	public int getHundreds() {
		return hundreds;
	}
	
	/**
	 * Mutator method setHundreds which accepts one int parameter
	 * @param hundreds
	 */
	public void setHundreds(int hundreds) {
		this.hundreds = hundreds;
	}

	/**
	 * Access method getFifties()
	 * @return the int this.fifties 
	 */
	public int getFifties() {
		return fifties;
	}

	/**
	 * Mutator method setFifies which accepts one int parameter
	 * @param fifties
	 */
	public void setFifties(int fifties) {
		this.fifties = fifties;
	}

	/**
	 * Access method getTwenties()
	 * @return the int this.twenties 
	 */
	public int getTwenties() {
		return twenties;
	}

	/**
	 * Mutator method setTwenties which accepts one int parameter
	 * @param twenties
	 */
	public void setTwenties(int twenties) {
		this.twenties = twenties;
	}
	
	/**
	 * Constructor of type ATM. A constructor that initializes 
	 * the instance variables with the parameters.
	 * @param hundreds
	 * @param fifties
	 * @param twenties
	 */
	public ATM(int hundreds, int fifties, int twenties) {
		
		if (hundreds < 0 || fifties < 0 || twenties < 0) {
			throw new IllegalArgumentException();
		}
		
		this.hundreds = hundreds;
		this.fifties = fifties;
		this.twenties = twenties;
	}
	
	/**
	 * Constructor of type ATM. A constructor that initializes
	 * the instance variables with the other ATM parameter
	 * @param other
	 */
	public ATM(ATM other) {
		
		if (other.getHundreds() < 0 || other.getFifties() < 0 || other.getTwenties() < 0) {
			throw new IllegalArgumentException();
		}
		
		this.hundreds = other.getHundreds();
		this.fifties = other.getFifties();
		this.twenties = other.getTwenties();
	}
	
	/**
	 * This method accepts a parameter of type Object
	 * This is a method that returns true if this ATM
	 *  object is exactly the same as the other ATM object
	 * @param other
	 * @return boolean
	 */
	public boolean equals(Object other) {
		if (equals((ATM) other) == true) {
			return true;
		}
		return false;
	}
	
		
	/**
	 * This method accepts a parameter of type ATM
	 * A method that returns true if this ATM 
	 * object is exactly the same as the other ATM object
	 * @param other
	 * @return boolean
	 */
	public boolean equals(ATM other) {
		if (this.hundreds == other.getHundreds()) {
			if (this.fifties == other.getFifties()) {
				if (this.twenties == other.getTwenties()) {
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * This static method accepts two parameters, both of type ATM
	 * This method returns true if both of ATM are exactly the same
	 * @param other1
	 * @param other2
	 * @return boolean
	 */
	public static boolean equals(ATM other1, ATM other2) {
		if (other1.getHundreds() == other2.getHundreds()) {
			if (other1.getFifties() == other2.getFifties()) {
				if (other1.getTwenties() == other2.getTwenties()) {
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * This method accepts one parameter of type ATM
	 * This is a method that returns 1 if  “this” ATM object 
	 * is greater than (based upon the total in the ATM)
	 * the other ATM object; 
	 * returns -1 if the “this” ATM object is less than the other ATM; 
	 * returns 0 if the “this” ATM object is equal to the other ATM object
	 * @param other
	 * @return int. Either -1, 0, or 1
	 */
	public int compareTo(ATM other) {
		int totalATM = (this.hundreds * 100) + (this.fifties * 50) + (this.twenties * 20);
		int totalOtherATM = (other.getHundreds() * 100) + (other.getFifties() * 50) + (other.getTwenties() * 20);
		
		if (totalATM > totalOtherATM) {
			return 1;
		}
		else if (totalATM < totalOtherATM) {
			return -1;
		}
		return 0;
	}
	
	/**
	 * This static method accepts two parameters, both of type ATM
	 * A method that returns other1 if ATM object other1 is greater
	 * than ATM object other2;
	 * returns -1 if the ATM object other1 is less than ATM other2;
	 * returns 0 if the ATM object other1 is equal to ATM object other2
	 * @param other1
	 * @param other2
	 * @return int. Either -1, 0, or 1
	 */
	public static int compareTo(ATM other1, ATM other2) {
		int totalOtherOne = (other1.getHundreds() * 100) + (other1.getFifties() * 50) + (other1.getTwenties() * 20);
		int totalOtherTwo = (other2.getHundreds() * 100) + (other2.getFifties() * 50) + (other2.getTwenties() * 20);
		
		if (totalOtherOne > totalOtherTwo) {
			return 1;
		}
		else if (totalOtherOne < totalOtherTwo) {
			return -1;
		}
		return 0;
		
	}
	
	/**
	 * This void method accepts three different int parameters
	 * This is a method that adds the parameters to the instance variables
	 * to this ATM object
	 * @param hundreds
	 * @param fifties
	 * @param twenties
	 */
	public void putIn(int hundreds, int fifties, int twenties) {
		
		if (hundreds < 0 || fifties < 0 || twenties < 0) {
			throw new IllegalArgumentException();
		}
		
		if (suspend == false) {
		
		this.hundreds += hundreds;
		this.fifties += fifties;
		this.twenties += twenties;
		}
	}
	
	/**
	 * This void method accepts one parameter of type ATM
	 * This is a method that adds ATM other to the this ATM object
	 * @param other
	 */
	public void putIn(ATM other) {
		
		if (other.getHundreds() < 0 || other.getFifties() < 0 || other.getTwenties() < 0) {
			throw new IllegalArgumentException();
		}
		
		if (suspend == false) {		
		
		this.hundreds += other.getHundreds();
		this.fifties += other.getFifties();
		this.twenties += other.getTwenties();
		}
	}
	
	/**
	 * This void method accepts three different int parameters
	 * This is a method that subtracts the parameters from the "this" ATM object
	 * @param hundreds
	 * @param fifties
	 * @param twenties
	 */
	public void takeOut(int hundreds, int fifties, int twenties) {
		
		if (hundreds < 0 || fifties < 0 || twenties < 0) {
			throw new IllegalArgumentException();
		}
		
		if (suspend == false) {		
		
		this.hundreds -= hundreds;
		this.fifties -= fifties;
		this.twenties -= twenties;
		}	
	}
	
	/**
	 * This void method accepts one parameter of type ATM
	 * This is a method that subtracts ATM "other" from "this" ATM object
	 * @param other
	 */
	public void subtract(ATM other) {
		this.hundreds -= other.hundreds;
		this.fifties -= other.fifties;
		this.twenties -= other.twenties;
	}
	
	/**
	 * This method accepts one int parameter
	 * This is a method that returns an ATM instance that has the number
	 * of hundreds, fifties, twenties that would sum to the "amount"  
	 * @param amount
	 * @return ATM
	 */
	public ATM takeOut(int amount) {
		ATM takeMoney = new ATM();
		int takeH = 0;
		int takeF = 0;
		int takeT = 0;
		
		if (amount < 0) {
			throw new IllegalArgumentException();
		}
		
		if (suspend == false) {
		
			if (amount % 10 == 0) {
			
				
				for (takeH = this.hundreds; takeH >= 0; takeH--) {
					for (takeF = this.fifties; takeF >= 0; takeF--) {
						for (takeT = this.twenties; takeT >= 0; takeT--) {
						
							if (takeH * 100 + takeF * 50 + takeT * 20 == amount) {
							
								takeMoney = new ATM(takeH, takeF, takeT);
								this.subtract(takeMoney);
							
								return takeMoney;
							}							
						}
					}
				}
			}
			else {
				return takeMoney;
			}
		}
		return takeMoney;
	}
	
	/**
	 * Accessor method
	 * @return int the sum of "this" hundreds, "this" fifties, and "this"
	 * twenties
	 */
	public int getAmount() {
		int totalAmount = this.hundreds * 100 + this.fifties * 50 + this.twenties * 20;
		
		return totalAmount;
	}
	
	/**
	 * This method returns a string that represents an ATM instantiation
	 */
	public String toString() {
		
		String h = "bills " + "\n";
		String f= "bills " + "\n";
		String t = "bills " +"\n";
		
		if (this.hundreds == 1) {
			h = "bill " + "\n";
		}
		if (this.fifties == 1) {
			f = "bill " + "\n";
		}
		if (this.twenties == 1) {
			t = "bill " +"\n";		
		}
		return this.hundreds + " hundred dollar " + h + this.fifties + " fifty dollar " + f + this.twenties + " twenty dollar " + t + "\n";
	}
	
	/**
	 * This void method accepts one parameter of type String
	 * This is a method that saves the "this" ATM to a file;
	 * The parameter "filename" is used for the name of the file
	 * @param fileName
	 */
	public void save(String fileName) {		
		File savingFile = new File(fileName);
		FileWriter out = null;
		try {
			out = new FileWriter(fileName);
			out.write(this.hundreds + " " + this.fifties + " " + this.twenties);
			out.close();
			System.out.println("File called " + fileName + " closed.");
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			if (out != null) {
				try {
					out.close();
				}
				catch (IOException ignore) {
					
				}
			}
			System.out.printf("File is located at %s%n", savingFile.getAbsolutePath());
		}
	}

	/**
	 * This void method accepts one parameter of type String
	 * This is a method that loads the "this" ATM object from a file;
	 * The parameter "filename" is used for the name of the file
	 * @param fileName
	 */
	public void load(String fileName) {			
		try {
			int h = 0;
				int f = 0;
				int t = 0;

				File sample = new File(fileName);
				Scanner fileReader = new Scanner(sample);

				h = fileReader.nextInt();
				f = fileReader.nextInt();
				t = fileReader.nextInt();

				System.out.println(h + " " + f + " " + t);
				
				this.hundreds = h;
				this.fifties = f;
				this.twenties = t;
				
			fileReader.close();
			}
			catch(Exception error) {
				System.out.println("File called " + fileName + " not found.");
			}
		}
	
	/**
	 * This static method accepts a parameter of type Boolean
	 * This is a method that turns 'off' or 'on' any takeOut/putIn methods
	 * @param on
	 */
	public static void suspend(Boolean on) {
		
		if (on) {
			suspend = true;
		}
		else {
			suspend = false;
		}
	}
	
		
	/**
	 * The main method to test the ATM class
	 * @param args
	 */
	public static void main(String[] args) {
		
		System.out.println("Testing ATM takeOut method\n" );
		
		ATM d = new ATM(2,1,3);
		System.out.println("ATM d = new ATM(2,1,3) \n" + d.toString( ) );
		ATM temp = d.takeOut(250);
		System.out.println ("ATM temp = d.takeOut(250)\n" + temp.toString() );
		System.out.println("Remaining in ATM:\n" + d.toString( ) );
	}
}
