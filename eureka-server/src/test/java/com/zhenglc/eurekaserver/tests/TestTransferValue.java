package com.zhenglc.eurekaserver.tests;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @Author: zhenglc
 * @Descriptions:
 * @Data: Created in 16:41 2019/9/11/0011
 * @Modified By:
 * @Version:
 */
@Getter@Setter@NoArgsConstructor
class Person {
	private String id;
	private String personName;

	public Person(String personName) {
		this.personName = personName;
	}
}
public class TestTransferValue {
	public void changeVlue1(int age) {
		age = 30;
	}

	public void changeValue2(Person person) {
		person.setPersonName("xxx");
	}

	public void changeValue3(String str) {
		str = "xxx";
	}

	public static void main(String[] args) {
		TestTransferValue test = new TestTransferValue();
		int age = 20;
		test.changeVlue1(age);
		System.out.println("age..."+age);

		Person p = new Person("abc");
		test.changeValue2(p);
		System.out.println("personName..." + p.getPersonName());

		String str = "abc";
		test.changeValue3(str);
		System.out.println("String..."+str);
	}
}
