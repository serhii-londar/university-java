package com.londar.Program;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;

public class Program {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter Some Setense :");
		String s = br.readLine();
		
		String[] wordsArray = s.split(" ");
		
		Map<String, Integer> dictionary = new HashMap<String, Integer>();
		HashSet<String> set = new HashSet<String>();
		
		for(int i = 0; i < wordsArray.length; i++) {
			if(set.contains(wordsArray[i])) {
				continue;
			} else {
				set.add(wordsArray[i]);
			}
			Integer repeatCount = 0;
			for(int j = 0; j < wordsArray.length; j++) {
				if(wordsArray[i].equals(wordsArray[j])) {
					repeatCount++;
				}
				
			}
			dictionary.put(wordsArray[i], repeatCount);
		}
		for(String word : set) {
			System.out.println(word + " - " + dictionary.get(word));
		}
	}
}
