package coreJava;

import java.util.Scanner;

import coreJava.BankAccount.BankBuilder;
import coreJava.TreeNode.B;

public class TestMain {
// ve user options to Show Account Balance, Deposit Money, Withdraw Money and Exit out of program
	//Add some System.out.println's in all methods above as well.
	public static void showBalance(BankAccount account) {
		System.out.println(account.getBalance());
	}
	public static void depositMoney(BankAccount account, double money) {
		System.out.println("before: "+ account.getBalance());
		account.deposit(money);
		System.out.println("after: "+ account.getBalance());
	}
	public static void withdrawMoney(BankAccount account, double money) {
		System.out.println("before: "+ account.getBalance());
		account.withdraw(money);
		System.out.println("after: "+ account.getBalance());	
	}
	public static void showInfo(BankAccount account) {
		System.out.println(account.getInfo());
	}
	
	public static void Exit() {
		System.out.println("Good Bye");
	}
	
	public static void greeting() {
		System.out.println("Welcome to the Bank");
		System.out.println("User Options");
		System.out.println("0. Show Account Info");
		System.out.println("1. Show Account Balance");
		System.out.println("2. Deposite Money");
		System.out.println("3. Withdraw Money");
		System.out.println("4. Show deposit history");
		System.out.println("5. Show withdraw history");
		System.out.println("6. Exit");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		BankBuilder builder = new BankBuilder();
		builder.setAccount_number("123456");
		builder.setBalance(1000000);
		builder.setEmail("123@gmail.com");
		builder.setName("lingzhi");
		builder.setPhone("2134003365");
		BankAccount acc = builder.build();
		boolean flag = true;
		do {
			greeting();
			Scanner in = new Scanner(System.in);
			int num = in.nextInt();
			switch(num) {				
				case 0:
					showInfo(acc);
					break;
				case 1: showBalance(acc);
					break;
				case 2: 
					System.out.println("please input your money");
					double money = in.nextDouble();
					depositMoney(acc, money);
					break;
				case 3:
					System.out.println("please input your money");
					double mon = in.nextDouble();
					withdrawMoney(acc, mon);
					break;
				case 4:
					acc.showDepositHistory();;
					break;
				case 5:
					acc.showWithdrawHistory();;
					break;
				case 6: 
					Exit();
					flag = false;
					break;

				default:
					System.out.println("Wrong Command");
					System.out.println();
					System.out.println();
					break;
					
					
			}
		}while(flag);
		

				
		
		

	}

}
