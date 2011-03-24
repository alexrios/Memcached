package com.alex.memcached;

import java.io.IOException;

public class RemoveKey {

	public static void main(String[] args) throws IOException {
		Cache.getInstance().delete("words");
	}
}
