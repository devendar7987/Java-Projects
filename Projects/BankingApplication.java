package Banking;
import java.util.*;

public class BankingApplication {

	public static void main(String[] args) {
            BankAccount obj1=new BankAccount("Thigulla Devendar","SB100081",1234);
            if(obj1.authenticatePin()) {
            	obj1.showMenu();
            }
            else {
            	System.out.println("Incorrect pin.Please check and try again.");
            }
	}

}
class BankAccount{
	int balance;
	int previousTransaction;
	String customerName;
	String customerId;
	int pin;
	
	BankAccount(String cName,String cId,int inputPin){
		this.customerName=cName;
		this.customerId=cId;
		this.pin=inputPin;
	}
	boolean authenticatePin() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Please enter your ATM pin:");
		int enteredPin=sc.nextInt();
		if(enteredPin==pin) {
			return true;
		}else {
			return false;
		}
	}
	void deposit(int amount) {
		if(amount > 0) {
		balance=balance+amount;
		previousTransaction=amount;
		System.out.println("Your A/C"+" "+customerId+" "+"is"+" "+"credited by Rs"+" "+amount);
		System.out.println("your current balance is:"+" "+balance);
		}
	}
	void withDraw(int amount) {
		if(amount > 0 && amount <= balance) {
		balance=balance-amount;
		previousTransaction=-amount;
		System.out.println("Your A/C"+" "+customerId+" "+"is"+" "+"debited by Rs"+" "+amount);
		System.out.println("your current balance is:"+" "+balance);

		}else {
			System.out.println("Insufficient bank balance");
			
		}
	}
	void getPreviousTransaction() {
		if(previousTransaction>0) {
			System.out.println("Money Deposited is:"+previousTransaction);
		}
		else if(previousTransaction<0){
			System.out.println("Money WithDrawn is:"+Math.abs(previousTransaction));
		}
		else {
			System.out.println("No Transaction Occured");
		}
	}
	void showMenu() {
		Scanner sc=new Scanner(System.in);
		char option='0';
		System.out.println("Welcome"+" "+customerName);
		System.out.println("Your Account No is"+" "+customerId);
		System.out.println();
		System.out.println("A.Check Balance");
		System.out.println("B.Deposit");
		System.out.println("C.WithDraw");
		System.out.println("D.PreviousTransaction");
		System.out.println("E.Exit");
		do {
			System.out.println("=========================================");
			System.out.println("Enter an option");
			System.out.println("=========================================");
			option=sc.next().charAt(0);
			
			switch(option) {
			case 'A':
				System.out.println("=========================================");
				System.out.println("Current Balance is:"+balance);
				System.out.println("=========================================");
				System.out.println();
				break;
			case 'B':
				System.out.println("=========================================");
				System.out.println("Enter an amount to Deposit");
				System.out.println("=========================================");
				int amount=sc.nextInt();
				deposit(amount);
				System.out.println();
				break;
			case 'C':
				System.out.println("=========================================");
				System.out.println("Enter an amount to WithDraw");
				System.out.println("=========================================");
				int amount2=sc.nextInt();
				withDraw(amount2);
				System.out.println();
				break;
			case 'D':
				System.out.println("=========================================");
				getPreviousTransaction();
				System.out.println("=========================================");
				System.out.println();
				break;
			case 'E':
				System.out.println("********************");
				break;
			default:
				System.out.println("Invalid option! Please choose a valid option");	
			}
			
		}while(option!='E');
		System.out.println("ThankYou for using our services");
	}
}
