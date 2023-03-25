package main;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class Ex01 {

	public static void main(String[] args) {
		// Lists
		System.out.println("--------------- Listas ---------------");
		
		List<Integer> numbers = new ArrayList<>();
		
		numbers.add(1);
		numbers.add(3);
		numbers.add(5);
		numbers.add(10);
		numbers.add(22);
		numbers.add(45);
		
		System.out.println(numbers);
		
		//For
		System.out.println("---------------------------------------");
		for(int i = 0; i < numbers.size(); i++) {
			int value = numbers.get(i);
			System.out.println("Valor " + i + ": " + value);
		}
		
		// Iterator
		System.out.println("---------------------------------------");
		Iterator<Integer> numberIterator = numbers.iterator();
		
		while(numberIterator.hasNext()) {
			int value = numberIterator.next();
			System.out.println("Valor: " + value);
		}
		
		System.out.println("--------------- Stacks ---------------");
		
		Stack<Integer> numbersStack = new Stack<>();
		
		numbersStack.push(10);
		numbersStack.push(23);
		numbersStack.push(45);
		numbersStack.push(67);
		numbersStack.push(14);
		numbersStack.push(87);
		
		System.out.println(numbersStack);
		
		System.out.println("---------------------------------------");
		
		for(int i=numbersStack.size(); i>0; i--) {
			int value = numbersStack.pop();
			
			System.out.println("Valor: " + value);
			System.out.println(numbersStack);
		}
		
	}

}
