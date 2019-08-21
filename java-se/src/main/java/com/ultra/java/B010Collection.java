package com.ultra.java;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class B010Collection {
	public static void main(String[] args) {
		Collection<CollectionPerson> col1=new ArrayList<CollectionPerson>();
		Collection<CollectionPerson> col2=new ArrayList<CollectionPerson>();
		/*Collection接口是set和list的父接口
		 * 1.增加元素
		 * add()
		 * addAll()
		 */
		CollectionPerson p1=new CollectionPerson();
		col1.add(p1);
		
		System.out.println(col1.size());
		CollectionPerson p2=new CollectionPerson();
		CollectionPerson p3=new CollectionPerson();
		col1.add(p3);
		col1.add(p2);
		col2.add(p2);
		col2.add(p3);
		//col1.addAll(col2);
		System.out.println(col1.size());
		/*
		 * 2.获取集合元素
		 * 
		 */
		Iterator<CollectionPerson> iterator=col1.iterator();
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}
		for(CollectionPerson col:col1){
			System.out.println(col);
		}
		/*
		 * 3.检测集合
		 * size()
		 * contain():使用的equals()方法判断是否存在，可以重写equals()方法来控制
		 * containAll():只比较是否存在元素，不比较顺序
		 * isEmpty()
		 * clear()
		 */
		System.out.println(col1.contains(p1));
		System.out.println(col1.containsAll(col2));
		System.out.println(col1.isEmpty());
		//col1.clear();
		System.out.println(col1.isEmpty());
		/*
		 * 4.转化成数组
		 * toArray()
		 */
		Object[] p=col1.toArray();
		System.out.println(p.length);
		/*
		 * 5.移除元素
		 * remove():如果存在则移除
		 * removeAll():移除两给集合的交集
		 * retainAll():保留交集
		 * clear()
		 */
		col1.retainAll(col2);
		System.out.println(col1.size());
		col1.remove(p1);
		System.out.println(col1.size());
		col1.removeAll(col2);
		System.out.println(col1.size());
		col1.clear();
		System.out.println(col1.size());
	}

}

class CollectionPerson{
	
//	public boolean equals(Object obj) {
//		return false;
//	}
	
}