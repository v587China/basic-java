package com.ultra.java;

import org.junit.Test;


public class B060Collections工具类 {

	/**
	 * 反射小结:
	 * 
	 * 1. Class: 是一个类; 一个描述类的类. 封装了描述方法的 Method, 描述字段的 Filed,
	 * 描述构造器的 Constructor 等属性.
	 * 
	 * 2. 如何得到 Class 对象:
	 * 2.1 Person.class
	 * 2.2 person.getClass()
	 * 2.3 Class.forName("com.atguigu.javase.Person")
	 * 
	 * 3. 关于 Method:
	 * 3.1 如何获取 Method:
	 * 1). getDeclaredMethods: 得到 Method 的数组.
	 * 2). getDeclaredMethod(String methondName, Class ... parameterTypes)
	 * 
	 * 3.2 如果调用 Method
	 * 1). 如果方法时 private 修饰的, 需要先调用 Method 的　setAccessible(true), 使其
	 * 变为可访问
	 * 2). method.invoke(obj, Object ... args);
	 * 
	 * 4. 关于 Field:
	 * 3.1 如何获取 Field: getField(String fieldName)
	 * 3.2 如何获取 Field 的值: 
	 * 1). setAccessible(true)
	 * 2). field.get(Object obj)
	 * 3.3 如何设置 Field 的值:
	 * field.set(Obejct obj, Object val)
	 * 
	 * 5. 了解 Constructor 和 Annotation 
	 * 
	 * 6. 反射和泛型.
	 * 6.1 getGenericSuperClass: 获取带泛型参数的父类, 返回值为: BaseDao<Employee, String>
	 * 6.2 Type 的子接口: ParameterizedType
	 * 6.3 可以调用 ParameterizedType 的 Type[] getActualTypeArguments() 获取泛型
	 * 参数的数组. 
	 * 
	 * 7. 搞定 ReflectinUtils 即可. 
	 *
	 */
	@Test
	public void testClass() {
		
	}

}
