package com.zhenglc.servicefeign.client;

import org.springframework.stereotype.Component;

/**
 * @Author: zhenglc
 * @Descriptions:
 * @Data: Created in 14:30 2019/9/4
 * @Modified By:
 * @Version:
 */
@Component
public class SchedualServiceHiHystric implements SchedualServiceHi{
	@Override
	public String sayHiFromClientOne(String name) {
		return "sorry "+name;
	}
}
