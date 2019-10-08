package com.flexontechnology.devops.arraytest;

import java.util.Scanner;

public class KeyBoardReader {
	public int[] reader() {
		Scanner scan = new Scanner(System.in);
		System.out.println("please input the length of the array");
		int len = scan.nextInt();
		if(len <=0) {
			return null;
		}
		int[] array = new int[len];
		for(int i =0; i< len; i++) {
			System.out.println("please input your element for "+(i+1)+"th position");
			int value = scan.nextInt();
			array[i]= value;
		}
		return array;
	}

}
