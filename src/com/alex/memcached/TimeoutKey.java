package com.alex.memcached;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TimeoutKey {

	public static void main(String[] args) throws IOException,
			InterruptedException {
		List<String> words = new ArrayList<String>();
		words.add("first");
		words.add("second");
		words.add("third");

		// Five seconds timeout
		Cache.getInstance().set("words", 5, words);

		System.out.println("Before cache timeout: "
				+ (Cache.getInstance().get("words") != null));
		Thread.sleep(6000);
		System.out.println("After cache timeout: "
				+ (Cache.getInstance().get("words") != null));
	}
}
