package atm;

import java.util.Scanner;

import javax.security.auth.login.AccountException;

class insufficientFundsException extends Exception{
	public insufficientFundsException(String message) {
		super(message);
	}
}
class inavalidAmountExecption extends Exception{
	public inavalidAmountExecption (String message) {
		super(message);
	}
}
class account{
	private static double balance;
	
	public account(double initialbalance) {
		balance = initialbalance;
	}

public static void deposit(double amount) {

	balance += amount;
}
public static double getBalance() {
    return balance;
}
public static void withdraw(double amount) throws insufficientFundsException, inavalidAmountExecption{
	if(amount <= 0) {
		throw new inavalidAmountExecption("invalid amount");
	}
	if(amount > balance) {
		throw new insufficientFundsException("valid amount");
	}
balance += amount;
}
public class Atm {

	public static void main(String[] args) throws inavalidAmountExecption, AccountException {
		int balance = 1000000;
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("select 1. withdraw");
			System.out.println("select 2. balance");
			System.out.println("select 4. deposit");
			System.out.println("select 4. exit");
			
			int select = sc.nextInt();
			
			switch(select) {
			case 1: Object acc;
				System.out.println("current balance: "+  account.getBalance());
			break;
			case 2:
                System.out.print("Enter the amount");
                double depositAmount = sc.nextDouble();
                account.deposit(depositAmount);
                System.out.println("Deposit done succesfull");
                break;
            case 3:
                System.out.print("Enter amt for withdraw ");
                double withdrawAmount = sc.nextDouble();
                try {
                    account.withdraw(withdrawAmount);
                    System.out.println("Withdrawal completed");
                } catch (insufficientFundsException e) {
                    System.out.println("Error: " + e.getMessage());
                }
                break;
            case 4:
                System.out.println("Thank you visit again ");
                System.out.println("pleace collect your card ");
                System.exit(0);
            default:
                System.out.println("pleace collect your card");
                break;
        }
System.out.println();
    }

		}

}}
	
