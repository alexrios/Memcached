package com.alex.memcached;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class CacheTest {
	
	private Cache cache = null;
	private List<String> words = null;
	private int twoSeconds = 2;
	private int tenSeconds = 10;
	private int twoSecondsInMillis = 2000;
	
	@SuppressWarnings("static-access")
	@Before
	public void setup(){
		cache = cache.getInstance();
		words = new ArrayList<String>();
		
		words.add("first");
		words.add("second");
		words.add("third");
		
		cache.set("words", twoSeconds, words);
	}
	
	@Test
	public void getKeyTest() {
		assertEquals(words, cache.get("words"));
	}
	
	@Test
	public void timeoutTest() throws InterruptedException {
		/* * Waiting for timeout is reached * */ 
		Thread.sleep(twoSecondsInMillis);
		assertEquals(null, cache.get("words"));
	}
	
	@Test
	public void removeTest() throws InterruptedException {
		cache.set("foo", tenSeconds, "bar");
		assertEquals("bar", cache.get("foo"));
		
		cache.delete("foo");
		assertEquals(null, cache.get("foo"));
	}
	
}
