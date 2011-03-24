package com.alex.memcached;

import java.io.IOException;
import java.util.List;

public class GetKey {
	
	public static void main(String[] args) throws IOException {
		Object valorRecuperado = Cache.client.get("palavras");
		List<String> palavras = (List<String>) valorRecuperado;
		
		for(String palavra : palavras){
			System.out.println(palavra);
		}
	}
}
