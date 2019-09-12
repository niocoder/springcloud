package com.zhenglc.eurekaserver.tests;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @Author: zhenglc
 * @Descriptions:
 * @Data: Created in 9:59 2019/9/12/0012
 * @Modified By:
 * @Version:
 */
public class SpinLockDemo {
	private AtomicReference<Thread> atomicReference = new AtomicReference<>();

	public void myLock() {
		Thread thread = Thread.currentThread();
		System.out.println(thread.getName() + "\t come in ...");
		while (!atomicReference.compareAndSet(null,thread)) {
		}
	}

	public void myUnLock() {
		Thread thread = Thread.currentThread();
		System.out.println(thread.getName() + "\t invok myUnLock...");
		atomicReference.compareAndSet(thread, null);
	}

	public static void main(String[] args) {
		SpinLockDemo spinLockDemo = new SpinLockDemo();
		new Thread(() -> {
			spinLockDemo.myLock();
			try { TimeUnit.SECONDS.sleep(5); } catch (InterruptedException e) { e.printStackTrace(); }
			spinLockDemo.myUnLock();
		}, "AA").start();
		try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }
		new Thread(() -> {
			spinLockDemo.myLock();
			try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }
			spinLockDemo.myUnLock();
		}, "BB").start();
	}
}
