package com.ultra.java;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class B020Set之HashSet和LinkedHashSet概述 {
	
	public static void main(String[] args) {
		Set<HashSetPerson> set=new LinkedHashSet<HashSetPerson>();
						//new HashSet<HashSetPerson>();
		/*
		 * 1. Set 是 Collection 的子接口
		 * 2. Set 中不允许存放相同的元素. 判定相同元素的标准是, 对象用 equals()和hashCode() 方法, 两个方法均返回 true
		 * 3. HashSet(是使用HashMap的key实现的。)
		 * 3.1 基本特征:
		 * ①. 不能保证元素的排列顺序
		 * ②. HashSet 不是线程安全的
		 * ③. 集合元素可以使 null,最多存放一个null
		 * ④. 不允许存放相同的元素。对于 HashSet: 如果两个对象通过 equals() 方法返回 true，这两个对象的 hashCode 值也应该相同。
		 * 4. LinkedHashSet
		 * 4.1 基本特征:
		 * ①. 保证元素的排列顺序
		 * ②. LinkedHashSet 不是线程安全的
		 * ③. 集合元素可以使 null,最多存放一个null
		 * ④. 不允许存放相同的元素。对于 HashSet: 如果两个对象通过 equals() 方法返回 true，这两个对象的 hashCode 值也应该相同。
		 * 
		 */
		set.add(new HashSetPerson());
		boolean result1=set.add(null);
		boolean result2=set.add(null);
		System.out.println(result1+"  "+result2);
		System.out.println(set.size());
		set.add(new HashSetPerson());
		System.out.println(set.size());
		HashSetPerson p1=new HashSetPerson("ff",12);
		HashSetPerson p2=new HashSetPerson("ff",12);
		//重写equals()和hashCode()后,p1和p2不能都添加进去
		//重写equals()时，也要重写hashCode()方法
		set.add(p1);
		set.add(p1);
		set.add(p2);
		System.out.println(p1.hashCode()==p2.hashCode());
		System.out.println(p2.equals(p1));		
		System.out.println(set.size());
		HashSetPerson p3=new HashSetPerson("AA",13);
		set.add(p3);
		Iterator<HashSetPerson> iterator=set.iterator();
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}
	}
}

class HashSetPerson{
	String name;
	int age;
	public HashSetPerson() {
	}
	public HashSetPerson(String name, int age) {
		this.name = name;
		this.age = age;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HashSetPerson other = (HashSetPerson) obj;
		if (age != other.age)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "HashSetPerson [name=" + name + ", age=" + age + "]";
	}
	
}