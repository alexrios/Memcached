package com.alex.memcached;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SetKey {

	public static void main(String[] args) throws IOException {
		List<String> words = new ArrayList<String>();
		words.add("first");
		words.add("second");
		words.add("third");

		Cache.getInstance().set("words", 3600, words);
	}
}
