package main;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Ex02 {

	public static void main(String[] args) {
		System.out.println("--------------- Sets ---------------");
		
		Set<Integer> set1 = new HashSet<>();
		Integer[] numbers1 = new Integer[] {1, 2, 3, 4, 4, 5, 5, 6, 6, 10, 10, 10};
		
		Collections.addAll(set1, numbers1);
		System.out.println(set1);
		
		set1.add(1);
		set1.add(3);
		set1.add(7);
		
		System.out.println(set1);
		
		System.out.println("-------------------------------------");
		
		Set<Integer> set2 = new TreeSet<>();
		Integer[] numbers2 = new Integer[] {22, 10, 3, 6, 1, 0, 5};
		
		Collections.addAll(set2, numbers2);
		System.out.println(set2);
		
		set2.addAll(set1);
		
		System.out.println(set2);
	}
	
}
