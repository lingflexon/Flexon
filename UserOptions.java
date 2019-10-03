package coreJava;

import coreJava.BankAccount.BankBuilder;

public class UserOptions {
	public void showBalance(BankAccount account) {
		System.out.println(account.getBalance());
	}
	public void depositMoney(BankAccount account, double money) {
		System.out.println("before: "+ account.getBalance());
		account.deposit(money);
		System.out.println("after: "+ account.getBalance());
	}
	public void withdrawMoney(BankAccount account, double money) {
		System.out.println("before: "+ account.getBalance());
		account.withdraw(money);
		System.out.println("after: "+ account.getBalance());	
	}
	
	public void Exit(BankAccount account) {
		System.out.println("Exit");
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
		UserOptions user = new UserOptions();
		user.showBalance(acc);
		
		

	}

}
