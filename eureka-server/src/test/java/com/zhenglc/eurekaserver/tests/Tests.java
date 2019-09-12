package com.zhenglc.eurekaserver.tests;

import org.junit.Test;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: zhenglc
 * @Descriptions:
 * @Data: Created in 8:54 2019/9/11/0011
 * @Modified By:
 * @Version:
 */
public class Tests {
	@Test
	public void atomicTest() {
		AtomicInteger atomicInteger = new AtomicInteger(5);
		atomicInteger.compareAndSet(5, 2019);
		atomicInteger.getAndIncrement();
		System.out.println(atomicInteger.get());
	}

	@Test
	public void listTest() {
		List list = null;
	}
}
