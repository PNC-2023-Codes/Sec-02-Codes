package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ex04 {

	public static void main(String[] args) {
		// Streams
		System.out.println("--------------- Manejo de stream ---------------");
		List<Integer> numbers = new ArrayList<>();
		Collections.addAll(numbers, 1, 2, 4, 3, 55, 67, 99, 0, 10);
		System.out.println(numbers);
		
		System.out.println("--------------- For Each ---------------");
		numbers.stream()
			.forEach(number -> {
				System.out.println("Valor: " + number);
			});
		
		System.out.println("--------------- Map ---------------");
		List<Integer> numbersTimes2 = numbers.stream()
				.map(number -> number * 2)
				.collect(Collectors.toList());
		
		System.out.println(numbersTimes2);
	}

}
