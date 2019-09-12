package com.zhenglc.eurekaserver.tests;

import java.util.concurrent.CountDownLatch;

/**
 * @Author: zhenglc
 * @Descriptions:
 * @Data: Created in 10:57 2019/9/12/0012
 * @Modified By:
 * @Version:
 */
public class CountDownLatchDemo {
	public static void main(String[] args) throws InterruptedException {
		CountDownLatch countDownLatch = new CountDownLatch(6);
		for (int i = 0; i < 6; i++) {
			new Thread(() -> {
				System.out.println(Thread.currentThread().getName() + "\t 离开");
				countDownLatch.countDown();
			}, String.valueOf(i)).start();
		}
		countDownLatch.await();
		System.out.println(Thread.currentThread().getName()+"\t 最后关闭");
	}
}
