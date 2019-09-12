package com.zhenglc.eurekaserver.tests;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Author: zhenglc
 * @Descriptions:
 * @Data: Created in 9:50 2019/9/12/0012
 * @Modified By:
 * @Version:
 */
class MyCache{
	private volatile Map<String, Object> map = new HashMap<>();
	private ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();

	public void put(String key, Object value) {
		rwl.writeLock().lock();
		try {
			System.out.println(Thread.currentThread().getName()+"\t 开始写入");
			try { TimeUnit.MICROSECONDS.sleep(300); } catch (InterruptedException e) { e.printStackTrace(); }
			map.put(key, value);
			System.out.println(Thread.currentThread().getName()+"\t 写入完成");
		} finally {
			rwl.writeLock().unlock();
		}
	}

	public void get(String key) {
		rwl.readLock().lock();
		try {
			System.out.println(Thread.currentThread().getName()+"\t 开始读取");
			try { TimeUnit.MICROSECONDS.sleep(300); } catch (InterruptedException e) { e.printStackTrace(); }
			Object result = map.get(key);
			System.out.println(Thread.currentThread().getName()+"\t 读取完成"+result);
		} finally {
			rwl.readLock().unlock();
		}
	}
}
public class ReadWriteLockDemo {
	public static void main(String[] args) {
		MyCache myCache = new MyCache();
		for (int i = 0; i < 5; i++) {
			int finalI = i;
			new Thread(() -> {
				myCache.put(String.valueOf(finalI), finalI);
			}, String.valueOf(i)).start();
		}
		for (int i = 0; i < 5; i++) {
			int finalI = i;
			new Thread(() -> {
				myCache.get(String.valueOf(finalI));
			}, String.valueOf(i)).start();
		}
	}
}
