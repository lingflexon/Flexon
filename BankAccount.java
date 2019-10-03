package coreJava;

public class BankAccount {
	private String account_number;
	private double balance;
	private String name;
	private String email;
	private String phone;
	

	public String getAccount_number() {
		return account_number;
	}
	public double getBalance() {
		return balance;
	}
	public String getName() {
		return name;
	}
	public String getEmail() {
		return email;
	}
	public String getPhone() {
		return phone;
	}
	public BankAccount(BankBuilder builder) {
		this.account_number = builder.account_number;
		this.balance = builder.balance;
		this.name = builder.name;
		this.email = builder.email;
		this.phone = builder.phone;
		
	}
	public boolean deposit(double money) {
		this.balance += money;
		return true;
	}
	
	public boolean withdraw(double funds) {
		if(funds > balance) {
			System.out.println("Customer name: "+name+" ,Balance: "+balance);
			return false;
		}
		this.balance -= funds;
		System.out.println("Customer name: "+name+" ,Balance: "+balance);
		return true;
	}
	public String getInfo(String account) {
		if(account == null || !account.equals(account_number)) {
			return null;
		}
		StringBuilder sb= new StringBuilder();
		sb.append("Customer Name:" + name +"\n");
		sb.append("Account Number" + account_number+"\n");
		sb.append("Balance:" + balance +"\n");
		sb.append("Email: " + email+"\n");
		sb.append("Phone Number:" +phone+"\n");
		return sb.toString();
		
	}
	
	static class BankBuilder{
		private String account_number;
		private double balance;
		private String name;
		private String email;
		private String phone;
		public void setAccount_number(String account_number) {
			this.account_number = account_number;
		}
		public void setBalance(double balance) {
			this.balance = balance;
		}
		public void setName(String name) {
			this.name = name;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public void setPhone(String phone) {
			this.phone = phone;
		}
		
		public BankAccount build() {
			return new BankAccount(this);
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringBuilder sb= new StringBuilder();

		sb.append("Customer Name:" +"\n");
		sb.append("Account Number" +"\n");
		System.out.print(sb.toString());
		

	}

}
