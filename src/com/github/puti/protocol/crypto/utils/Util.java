package com.github.puti.protocol.crypto.utils;

import java.util.Random;

public class Util {

	public static String createToken(int range) {
		char[] chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQSTUVWXYZ0123456789!@#$%¨&*".toCharArray();
		StringBuilder stringBuilder = new StringBuilder(range);
		Random random = new Random();

		for (int i = 0; i < range; ++i) {
			char aChar = chars[random.nextInt(chars.length)];
			stringBuilder.append(aChar);
		}

		return stringBuilder.toString();
	}
	
	public static void print(String message) {
		System.out.println("[CryptoProcotol] "+message);
	}

}
