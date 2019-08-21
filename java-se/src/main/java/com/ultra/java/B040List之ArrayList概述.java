package com.ultra.java;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class B040List之ArrayList概述 {

	public static void main(String[] args) {
		List<ListPerson> list=new ArrayList<ListPerson>();
		/*
		 * List 代表一个元素有序、且可重复的集合，元素可以为null，集合中的每个元素都有其对应的顺序索引
		 * List 允许使用重复元素，可以通过索引来访问指定位置的集合元素。
		 * List 默认按元素的添加顺序设置元素的索引。
		 * ArrayList：是一个数组列表，因此其内部是使用一个“可变数组”来存放对象的，并且可以存放一切指定的对象。非线程安全
		 * LinkedList：并不是用普通的数组来存放数据的，而是使用结点<Node>来存放数据的，有一个指向链表头的结点first和一个指向链表尾的结点last。
		 * 对于数据频繁出入的情况下，并且要求操作要足够灵活，建议使用LinkedList；对于数组变动不大，主要是用来查询的情况下，可以使用ArrayList。
		 * Vector:它的内部也是使用数组来存放数据对象的 ，线程安全
		 * Vector与ArrayList唯一的区别是，Vector是线程安全的
		 */
		list.add(null);
		list.add(new ListPerson("AA",10));
		ListPerson lp=new ListPerson("AA",10);
		list.add(new ListPerson("BB",11));
		list.add(new ListPerson("CC",12));
		list.add(new ListPerson("DD",13));
		list.add(new ListPerson("EE",14));
		//add(index,Object o):添加元素到指定位置
		list.add(3,lp);
		//remove(Object o):移除首次出现的指定元素，如果存在
		list.remove(lp);
		//removeRange(int fromIndex, int toIndex):移除指定区间的元素
		System.out.println(list.size());
		
		Iterator<ListPerson> iterator=list.iterator();
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}
		
/*		for(ListPerson listPerson:list){
			System.out.println(listPerson);
		}
		
		for(int i=0;i<list.size();i++){
			//get(index)：获取元素
			System.out.println(list.get(i));
		}*/
		
		ListIterator<ListPerson> li=list.listIterator();
		while(li.hasNext()){
			System.out.println(li.next());
		}
		
		/**
		 *  void add(int index, Object ele)
		 *	boolean addAll(int index, Collection eles)
		 *	Object get(int index)
		 *	int indexOf(Object obj)
		 *	int lastIndexOf(Object obj)
		 *	Object remove(int index)
		 *	用ele代替index未知的元素
		 *	Object set(int index, Object ele)
		 *	截取list作为一个新的list fromIndex起始位置 包含；toIndex结束位置 不包含。
		 *	List subList(int fromIndex, int toIndex)
		 */
		System.out.println(list.indexOf(new ListPerson("AA",10)));
		System.out.println(list.lastIndexOf(new ListPerson("AA",10)));
	}
}

class ListPerson{
	String name;
	int age;
	
	public ListPerson(String name, int age) {
		super();
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
		ListPerson other = (ListPerson) obj;
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
	public String toString() {
		return "ListPerson [name=" + name + ", age=" + age + "]";
	}
	
}
