package com.alex.memcached;

import java.io.IOException;
import java.util.List;

public class GetKey {

	public static void main(String[] args) throws IOException {
		Object value = Cache.getInstance().get("words");
		List<String> words = (List<String>) value;

		for (String word : words) {
			System.out.println(word);
		}
	}
}
