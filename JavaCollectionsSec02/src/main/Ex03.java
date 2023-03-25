package main;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Ex03 {

	public static void main(String[] args) {
		// Maps
		
		Map<Character, String> map = new HashMap<>();
		
		map.put('a', "nice 01");
		map.put('b', "nice 02");
		map.put('h', "nice 03");
		map.put('x', "nice 04");
		map.put('c', "nice 05");
		map.put('a', "nice 10");
		
		System.out.println(map);
		
		System.out.println("Valor a: " + map.get('a'));
		
		System.out.println("------------------------------");
		Iterator<Character> keyIterator = map.keySet().iterator();
		
		while(keyIterator.hasNext()) {
			Character key = keyIterator.next();
			String value = map.get(key);
			
			System.out.println("Valor " + key + ": " + value);
			
		}
	}

}
