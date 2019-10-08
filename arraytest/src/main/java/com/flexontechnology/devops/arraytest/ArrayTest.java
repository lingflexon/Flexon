package com.flexontechnology.devops.arraytest;

import java.util.Arrays;

public class ArrayTest {
	
	public int[] sortDescend(int [] array) {
		if(array == null || array.length <= 1) {
			return array;
		}
		sort(array, 0, array.length-1);
		return array;
		
	}
	public void sort(int[] array, int start, int end) {
		if(start >= end) {
			return;
		}
		int index = quickSort(array, start, end);
		sort(array, start, index-1);
		sort(array, index+1, end);
	}
	public int quickSort(int[] array, int start, int end) {
		int index = start + (int)(Math.random()*(end-start+1));
		int value = array[index];
		swap(array, index, end);
		int i = start; 
		int j = end-1;
		while(i<= j) {
			if(array[i] >= value) {
				i++;
			}else if(array[j]< value) {
				j--;
			}else {
				swap(array, i++, j--);
			}
		}
		swap(array, i, end);
		return i;
	}
	public void swap(int[] array, int i, int j) {
		int t = array[i];
		array[i]= array[j];
		array[j]= t;
	}
	


//	reverseArray method and return the reverse order of entered Array elements
//	sortIntegers should sort the array and return a new array containing the sorted numbers
	
	public int getInteger(int[] array, int target) {
		if(array == null || array.length ==0) {
			return -1;
		}
		for(int i =0; i<array.length;i++) {
			if(target == array[i]) {
				return i;
			}
		}
		return -1;
	}
	public void reverseArray(int[] array) {
		if(array == null || array.length ==0) {
			return ;
		}
		int start = 0;
		int end = array.length -1;
		while(start< end) {
			swap(array, start++, end--);
		}
	}
	public void printArray(int[] array) {
		if(array == null || array.length ==0) {
			System.out.println("there is no such array");
			return;
		}
		for(int a : array) {
			System.out.print(a+" ");
		}
	}
	public int findMin(int[] array) {
		if(array == null || array.length == 0) {
			return Integer.MAX_VALUE;
		}
		int res = Integer.MAX_VALUE;
		for(int a : array) {
			res = Math.min(a, res);
		}
		return res;
	}
	public int findMax(int[] array) {
		if(array == null || array.length == 0) {
			return Integer.MIN_VALUE;
		}
		int res = Integer.MIN_VALUE;
		for(int a : array) {
			res = Math.max(a, res);
		}
		return res;
	}
	
	public int[] sortIntegers(int[] array) {
		int [] arr =Arrays.copyOf(array, array.length);
		sortDescend(arr);
		return arr;
	}

}
