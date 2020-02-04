package tasks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class ArrayOfWords {

	public static final  int N = 3;
	
	public static String[] getMostRecurring(String text) {
		text = text.toLowerCase();
		List<String> list = new ArrayList<String>();
		Matcher m = Pattern.compile("[a-zA-Z]+(?:'[a-zA-Z]+)*").matcher(text);
		while (m.find()) {
			list.add(m.group());
		}
		Map<String, Integer> hm = new HashMap<>();
		for (int i = 0; i < list.size(); i++)
			hm.put(list.get(i), hm.get(list.get(i)) == null ? 1 :  hm.get(list.get(i)) + 1);
		
		List<Map.Entry<String, Integer>> list2 = new ArrayList<>(hm.entrySet());
		list2.sort((Entry<String, Integer> el1, Entry<String, Integer> el2) -> -Integer.compare(el1.getValue(), el2.getValue()));
		var unique = list2.stream().filter(el -> el.getValue()==1).collect(Collectors.toList());
		//list2.forEach(e -> System.out.println(e.getKey() + " :  " + e.getValue()));
		if (unique.size() < 3) return new String[] {};
		String [] result = new String[N];
		for (int i = 0; i < N; i++) {
			result[i] = list2.get(i).getKey();
		}		
		return result;
	}
	public static void main(String[] args) {
		String text = "This is a test String. It's nothing specail, so there's no need to be worried" +
						" about this exact string as it doesn't mean anything and it's created for the" +
						" purpose of demonstrating the function's work whether it returns the array needed" +
						" or not, something like that. It's fascinating!!!";
		
		String[] arr = getMostRecurring(text);
		Arrays.asList(arr).forEach(System.out::println); // it's the string

		String text2 = "another test";
		String[] arr2 = getMostRecurring(text2);
		Arrays.asList(arr2).forEach(System.out::println); // 
	}

}
