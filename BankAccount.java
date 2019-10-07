package coreJava;

import java.sql.Timestamp;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import coreJava.BankAccount.BankBuilder;

public class BankAccount {
	private String account_number;
	private double balance;
	private String name;
	private String email;
	private String phone;
	private int deposit_count;
	private double accumulate_money;
	private TreeMap<Long, Double>deposit;
	private TreeMap<Long, Double>withdraw;
	
	

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
		this.deposit_count = 3;
		this.accumulate_money= 0;
		deposit = new TreeMap<>();
		withdraw = new TreeMap<>();
		
	}
	public boolean deposit(double money) {
		if(money > 500) {
			System.out.println("can not deposit money over 500");
			return false;
		}
		if(money < 50) {
			System.out.println("can not deposite money below 50");
			return false;
		}
		
		Date date = new Date(getTime());
		String s = getMidNight();
		if(s.equals(date.toString())) {
			deposit_count =0;
		}
		
		if(deposit_count >0) {
			this.balance += money;
			deposit.put(getTime(), money);
			deposit_count--;
			return true;
		}else {
			System.out.println("Reach your limitation(3) of the day");
			return false;
		}		
	}
	
	public boolean withdraw(double funds) {
		if(funds > balance) {
			System.out.println("Customer name: "+name+" ,Balance: "+balance);
			return false;
		}
		if(funds >1000) {
			System.out.println("Withdraw over 1000");
			return false;
		}
		Date date = new Date(getTime());
		String s = getMidNight();
		if(s.equals(date.toString())) {
			accumulate_money =0;
		}
		if(accumulate_money >=1000 || accumulate_money +funds >1000) {
			System.out.println("Can not withdraw money,you have daily limitation: "+ (1000-accumulate_money));
			return false;
		}
		this.balance -= funds;
		withdraw.put(getTime(), funds);
		accumulate_money+=funds;
		System.out.println("acc  "+ accumulate_money);
		System.out.println("Customer name: "+name+" ,Balance: "+balance + " ,Remaining daily limit"+ (1000 - accumulate_money));
		return true;
	}
	
	public static Long  getTime() {
		Date data= new Date();
		return data.getTime();
	}
	
	public void showDepositHistory() {
		if(deposit.size() ==0) {
			System.out.println("no deposit history by now");
			return;
		}
		for(Map.Entry<Long, Double> entry : deposit.entrySet()) {
			System.out.println("Deposit Time: " + new Date(entry.getKey()) + " ,Amount of Money: "+ entry.getValue());
		}
	}
	
	public void showWithdrawHistory() {
		if(withdraw.size() ==0) {
			System.out.println("no withdraw history by now");
			return;
		}
		for(Map.Entry<Long, Double>entry : withdraw.entrySet()) {
			System.out.println("WithDraw time: "+ new Date(entry.getKey()) + " ,Amount of Money: "+ entry.getValue());
		}
	}
	public static String getMidNight() {
		Calendar c = new GregorianCalendar();
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE,0);
		c.set(Calendar.SECOND, 0);
		Date d = c.getTime();
		return d.toString();
	}
	public String getInfo() {

		StringBuilder sb= new StringBuilder();
		sb.append("Customer Name:" + name +"\n");
		sb.append("Account Number" + account_number+"\n");
		sb.append("Balance:" + balance +"\n");
		sb.append("Email: " + email+"\n");
		sb.append("Phone Number:" +phone+"\n");
		Date date = new Date();
		Timestamp t = new Timestamp(date.getTime());
		sb.append("Date: "+ t);
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
		
		BankBuilder builder = new BankBuilder();
		builder.setAccount_number("123456");
		builder.setBalance(1000000);
		builder.setEmail("123@gmail.com");
		builder.setName("lingzhi");
		builder.setPhone("2134003365");
		BankAccount acc = builder.build();
		
//		StringBuilder sb= new StringBuilder();
//		sb.append("Customer Name:" +"\n");
//		sb.append("Account Number" +"\n");
//		System.out.print(sb.toString());
		
		acc.withdraw(1000);
		acc.withdraw(1);

		Calendar c = new GregorianCalendar();
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE,0);
		c.set(Calendar.SECOND, 0);
		Date d = new Date(getTime());
		System.out.println(d);
		System.out.println(getMidNight());
		
	}

}
