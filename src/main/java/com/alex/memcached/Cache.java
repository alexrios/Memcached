package com.alex.memcached;

import java.io.IOException;
import java.net.InetSocketAddress;

import net.spy.memcached.MemcachedClient;

public class Cache {
	private static final String NAMESPACE = "CUSTOM:NAMESPACE";
	private static Cache instance = null;
	private static MemcachedClient client;

	private Cache() {
		try {
			client = new MemcachedClient(new InetSocketAddress("127.0.0.1",
					11211));
		} catch (IOException io) {
			io.printStackTrace();
		}
	}

	public static synchronized Cache getInstance() {
		if (instance == null) {
			System.out.println("Creating a new instance");
			instance = new Cache();
		}else{
			System.out.println("Reusing Instance: " + instance);
		}
		return instance;
	}

	public void set(String key, int timeout, final Object value) {
		getCache().set(NAMESPACE + key, timeout, value);
	}

	public Object get(String key) {
		Object cachedObject = getCache().get(NAMESPACE + key);
		if (cachedObject == null) {
			System.out.println("Cache MISS for KEY: " + key);
		} else {
			System.out.println("Cache HIT for KEY: " + key);
		}
		return cachedObject;
	}

	public Object delete(String key) {
		return getCache().delete(NAMESPACE + key);
	}

	public MemcachedClient getCache() {
		return client;
	}
}