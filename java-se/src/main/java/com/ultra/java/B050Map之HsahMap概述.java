package com.ultra.java;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.util.Map.Entry;

public class B050Map之HsahMap概述 {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		/**
		 * Map
		 * 1. Map 用于保存具有映射关系的数据，因此 Map 集合里保存着两组值，一组值用于保存 Map 里的 Key，另外一组用于保存 Map 里的 Value
		 * 2. Map 中的 key 和  value 都可以是任何引用类型的数据
		 * 3. Map 中的 Key 不允许重复，即同一个 Map 对象的任何两个 Key 通过equals()和hashCode()方法。方法比较中返回 false
		 * 4. Key 和 Value 之间存在单向一对一关系，即通过指定的 Key 总能找到唯一的，确定的 Value。
		 * 
		 * 5. HashMap 定义了 HashSet: HashMap 的键为 HashSet 里边的元素. 
		 * 
		 * HashMap：无序的hash表，键值无序。通过equals()和hashCode()方法判断key是否相等。
		 * Hashtable：和HashMap的区别：①线程安全②null不能作为key或value。Properties是Hashtable的子类。
		 * LinkedHashMap：和HashMap的区别按插入顺序排序。是HashMap的子类。
		 * TreeMap：按key排序，通过compareTo()判断能否添加，怎么添加。需要键的对象之间需要能够比较，所以就要实现Comparable接口或者创建TreeMap(Comparator comparator)类型的对象。你可以使用String作为键，String已经实现了Comparable接口。
		 *
		 */
		Map<String,MapPerson> map=new HashMap<String,MapPerson>();
		// 1.添加元素
		//put(key,value),putAll(map)
		map.put(null, new MapPerson("null",0));
		System.out.println(map.get(null));
		map.put(null,null);
		System.out.println(map.get(null));
		map.put("AA",new MapPerson("AA",10));
		map.put("AAA",new MapPerson("AA",10));
		//key相同，则覆盖原来的value
		//map.put("AAA",new MapPerson("AAA",10));
		map.put("BB",new MapPerson("BB",11));
		map.put("CC",new MapPerson("CC",12));
		map.put("DD",new MapPerson("DD",13));
		// 2.获取/遍历 元素
		//2.1通过keySet获取key的Set集合
		Set<String> set=map.keySet();
		for(String str:set){
			//get(key):根据key获取单个元素
			System.out.println(str+" : "+map.get(str));
		}
		//2.2通过values获取value的Collection集合
		Collection<MapPerson> collection=map.values();
		for(MapPerson mp:collection){
			System.out.println(mp);
		}
		//2.3通过entrySet()获取 此映射中包含的映射关系的 Set 视图
		Set<Entry<String, MapPerson>> set2=map.entrySet();
		for(Entry<String, MapPerson> entry:set2){
			System.out.println("key: "+entry.getKey()+"   value: "+entry.getValue());
		}
		// 3.移除元素
		map.remove("AA");
		// 4.工具方法
		// 4.1 size()
		// 4.2 containKey()
		// 4.3 containValue()
		// 4.3 isEmpty()
		System.out.println(map.size());
		System.out.println(map.containsKey("AAA"));
		System.out.println(map.containsKey("aaa"));
		System.out.println(map.containsValue(new MapPerson("AA",10)));
		Properties p=new Properties();
		p.load(new FileInputStream("db.properties"));
		System.out.println(p.getProperty("url"));
	}

}

class MapPerson{
	String name;
	int age;
	
	public MapPerson(String name, int age) {
		super();
		this.name = name;
		this.age = age;
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
		MapPerson other = (MapPerson) obj;
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
		return "MapPerson [name=" + name + ", age=" + age + "]";
	}
	
}
