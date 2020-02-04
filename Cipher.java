package tasks;

import java.util.Arrays;
import java.util.stream.Collector;
import java.util.stream.IntStream;

public class Cipher {

	public static StringBuilder getNthValuesStringBuilder(String s) {
		return IntStream.range(0, s.length()).
				filter(i -> i % 2 == 0).
				mapToObj(s::charAt).
				collect(Collector.of(
			    StringBuilder::new,
			    StringBuilder::append,
			    StringBuilder::append));
	}
	
	public static String encrypt2(String s, int n) {
		if (s.isEmpty() || s == null || n <= 0) return s;
		
		String result = s.toLowerCase();
		for (int i = 0; i < n; i++) {
			StringBuilder list_of_odd = getNthValuesStringBuilder(result);
			StringBuilder list_of_even = getNthValuesStringBuilder(result.substring(1, result.length()));
			result = list_of_even.append(list_of_odd).toString();
		}
		return result;
	}
	
	public static String decrypt(String s, int n) {
		if (s.isEmpty() || s == null || n <= 0) return s;
		
		char arr[] = new char[s.length()];
		char temp[] = s.toCharArray();
		int index = 0;
		for (int j = 0; j < n; j++) {
			for (int i = 0; i < s.length(); i++) {
				index = i % 2 == 0 ? s.length() / 2 + i / 2 : i / 2;
				arr[i] = temp[index];
			}
			temp = Arrays.copyOf(arr, s.length());
		}
		return new String(temp);
	}
	
	public static String encrypt(String s, int n) {
		if (s.isEmpty() || s == null || n <= 0) return s;
		
		char[] arr = new char[s.length()];
		char[] temp = s.toLowerCase().toCharArray();
		int index = 0;
		for (int j = 0; j < n; j++) {
			for (int i = 0; i < s.length(); i++) {
				index = i % 2 == 0 ? s.length() / 2 + i / 2 : i / 2;
				arr[index] = temp[i];
			}
			temp = Arrays.copyOf(arr, s.length());
		}
		return new String(temp);
	}
	

	public static void main(String[] args) {
		String encrypted_string1 = encrypt("Abcdefghi", 1);
		String encrypted_string2 = encrypt("Abcdefghij", 2);
		

		// Alternative solutions - method encrypt2
//		String encrypted_string3 = encrypt2("Abcdefghij", 1);
//		String encrypted_string4 = encrypt2("Abcdefghij", 2);
		
		System.out.println("Encrypted once: " + encrypted_string1);
		System.out.println("Encrypted twice: " + encrypted_string2);
		
		System.out.println("Decrypted once: " + decrypt(encrypted_string1, 1));
		System.out.println("Decrypted twice: " + decrypt(encrypted_string2, 2));

		
	}

}
