package com.ultra.java;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class B030Set之TreeSet概述 {
	public static void main(String[] args) {
		Set<TreeSetPerson> set=new TreeSet<TreeSetPerson>();
		
		/*
		 * TreeSet: 
		 * 可以排序
		 * 自然排序：非插入的前后顺序排序，可以按指定的字段排序，由compareTo()方法的具体怎么实现决定。插入的类需要实现Comparable接口
		 * 定制排序：创建TreeSet的对象时，使用TreeSet(Comparator c)的构造函数，添加的元素类不需要实现任何接口。
		 * 1. 如果使用 TreeSet() 无参数的构造函数创建一个 TreeSet 对象, 则要求放入其中的元素的类必须实现 Comparable 接口
		 *    所以, 在其中不能放入 null 元素
		 * 2. 必须放入同样类的对象. 否则可能会发生类型转换异常.  
		 * 3. 两个对象通过 Comparable 接口 compareTo(Object obj) 方法的返回值来比较大小, 并进行升降序排列
		 * 4. 当需要把一个对象放入 TreeSet 中，重写该对象对应的 equals() 方法时，
		 *    应保证该方法与 compareTo(Object obj) 方法有一致的结果
		 *    能不能插入成功 只和compareTo()的返回结果有关，所以compareTo()方法的重写很重要：返回0不能插入，返回正数、负数可以
		 *    
		 * 5. 定制排序: 创建 TreeSet 对象时, 传入 Comparator 接口的实现类. 
		 *    要求: Comparator 接口的 compare 方法的返回值和 两个元素的 equals() 方法具有一致的返回值 
		 */
		//set.add(null);
		set.add(new TreeSetPerson("AA", 10));
		set.add(new TreeSetPerson("AA", 11));
		set.add(new TreeSetPerson("BB", 12));
		set.add(new TreeSetPerson("CC", 13));
		set.add(new TreeSetPerson("DD", 13));
		System.out.println(set.size());
		for(TreeSetPerson tsp:set){
			System.out.println(tsp);
		}	
		/*Comparator<TreeSetPerson2> comparator=new Comparator<TreeSetPerson2>() {			
			@Override
			public int compare(TreeSetPerson2 o1, TreeSetPerson2 o2) {
				if(o1 instanceof TreeSetPerson2&&o2 instanceof TreeSetPerson2){
					return o1.age-o2.age;//只比较成绩
				}else{
					throw new ClassCastException("转换失败");
				}
			}
		};*/
		Comparator comparator=new Comparator() {			
			@Override
			public int compare(Object o1, Object o2) {
				if(o1 instanceof TreeSetPerson2&&o2 instanceof TreeSetPerson2){
					TreeSetPerson2 tsp1=(TreeSetPerson2) o1;
					TreeSetPerson2 tsp2=(TreeSetPerson2) o2;
					return tsp1.age-tsp2.age;//只比较成绩
				}else{
					throw new ClassCastException("转换失败");
				}
			}
		};
		Set<TreeSetPerson2> set2=new TreeSet<TreeSetPerson2>(comparator);
		set2.add(new TreeSetPerson2("AA", 10));
		set2.add(new TreeSetPerson2("BB", 11));
		set2.add(new TreeSetPerson2("CC", 12));
		set2.add(new TreeSetPerson2("DD", 13));
		for(TreeSetPerson2 tsp:set2){
			System.out.println(tsp);
		}
	}
}

class TreeSetPerson implements Comparable<TreeSetPerson>{
	String name;
	int age;
	public TreeSetPerson(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}	
	@Override
	public String toString() {
		return "TreeSetPerson [name=" + name + ", age=" + age + "]";
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
		TreeSetPerson other = (TreeSetPerson) obj;
		if (age != other.age)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public int compareTo(TreeSetPerson o) {
		if(o instanceof TreeSetPerson){
			TreeSetPerson tsp=(TreeSetPerson)o;
			return this.age - tsp.age;//只比较成绩
			//return -this.name.compareTo(tsp.name);//只比较名字
		}else{
			throw new ClassCastException("不是一个Student对象. ");
		}
	}	
}

class TreeSetPerson2{
	String name;
	int age;

	public TreeSetPerson2(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}	
	@Override
	public String toString() {
		return "TreeSetPerson2 [name=" + name + ", age=" + age + "]";
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
		TreeSetPerson other = (TreeSetPerson) obj;
		if (age != other.age)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}	
}