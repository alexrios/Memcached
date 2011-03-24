package com.alex.memcached;

import java.io.IOException;
import java.net.InetSocketAddress;

import net.spy.memcached.MemcachedClient;

public class Cache {
	public static MemcachedClient client;
	
	public static void main(String[] args) throws IOException {
		 client = new MemcachedClient(new InetSocketAddress("127.0.0.1", 11211));
	}
}
