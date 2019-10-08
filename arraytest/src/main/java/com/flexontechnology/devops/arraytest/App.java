package com.flexontechnology.devops.arraytest;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	KeyBoardReader key = new KeyBoardReader();
    	int[] array = key.reader();
    	for(int a: array) {
    		System.out.println(a);
    	}
    }
}
