package com.alex.memcached;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SetKey {
	
	public static void main(String[] args) throws IOException {
		List<String> lista = new ArrayList<String>();
		lista.add("Primeiro");
		lista.add("Segundo");
		lista.add("Terceiro");
		
		Cache.client.set("palavras", 3600, lista);
	}
}
