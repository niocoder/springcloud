package com.zhenglc.eurekaserver.tests;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @Author: zhenglc
 * @Descriptions:
 * @Data: Created in 14:15 2019/9/11/0011
 * @Modified By:
 * @Version:
 */
public class ArrayListUnsafeDemo {
	public static void main(String[] args) {
		// arraylistUnsafe();
		// setNoSafe();
		Map<String,String> strings = new ConcurrentHashMap<>();
		// cuncurrentModificationException
		for (int i = 0; i < 30; i++) {
			new Thread(() -> {
				strings.put(Thread.currentThread().getName(),UUID.randomUUID().toString().substring(0, 8));
				System.out.println(strings);
			}, String.valueOf(i)).start();
		}
	}

	private static void setNoSafe() {
		Set<String> strings = new CopyOnWriteArraySet<>();
		// cuncurrentModificationException
		for (int i = 0; i < 30; i++) {
			new Thread(() -> {
				strings.add(UUID.randomUUID().toString().substring(0, 8));
				System.out.println(strings);
			}, String.valueOf(i)).start();
		}
	}

	private static void arraylistUnsafe() {
		List<String> strings = new CopyOnWriteArrayList<>();
		// cuncurrentModificationException
		for (int i = 0; i < 30; i++) {
			new Thread(() -> {
				strings.add(UUID.randomUUID().toString().substring(0, 8));
				System.out.println(strings);
			}, String.valueOf(i)).start();
		}
	}
}
