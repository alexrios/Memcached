package com.alex.memcached;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TimeoutKey {
	
	public static void main(String[] args) throws IOException, InterruptedException {
		List<String> lista = new ArrayList<String>();
		lista.add("Primeiro");
		lista.add("Segundo");
		lista.add("Terceiro");
		
		Cache.client.set("palavras", 5, lista);
		
		System.out.println("Antes do Timeout: " + (Cache.client.get("palavras") != null) );
		Thread.sleep(6000);
		System.out.println("Depois do Timeout: " + (Cache.client.get("palavras") != null) );
	}
}
