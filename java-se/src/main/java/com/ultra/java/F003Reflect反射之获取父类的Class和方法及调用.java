package com.ultra.java;

import java.lang.reflect.Method;

import org.junit.Test;

import com.ultra.java高级.Student;

public class F003Reflect反射之获取父类的Class和方法及调用 {
	
	@Test
	public void testGetSuperClass(){
		String className="com.java高级.Student";
		try {
			Class clazz=Class.forName(className);
			System.out.println(clazz.getSuperclass());
			System.out.println(clazz.getSuperclass().getSimpleName());
			System.out.println(clazz.getClassLoader().getParent());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	/*
	 * 通过某个类的对象，方法名，参数类型获取该方法(包括父类的私有方法)并调用
	 */
	public Object getSuperClassMethod(Object obj,String methodName,Object ...args){
		Method method=null;
		Class[] para=new Class[args.length];
		for(int i=0;i<args.length;i++){
			para[i]=args[i].getClass();
		}
		Class clazz=obj.getClass();
		for(int i=0;clazz!=null;clazz=clazz.getSuperclass(),i++){
			try {
				method=clazz.getDeclaredMethod(methodName,para);
				try {
					if(method.getModifiers()==2)
						method.setAccessible(true);
					if(i!=0)
						obj=clazz.newInstance();
					return method.invoke(obj, args);
				} catch(Exception e) {
					e.printStackTrace();
				}
			} catch (Exception e) {
				e.printStackTrace();
				}
			}
		return null;
		}
	@Test
	public void testGetSuperClassMethod(){
		Object obj=new Student();
		String methodName="printPerson";
		//"setCourse";
		Object[] args={new Student("范范",18)};
		//{"语文",3};
		System.out.println(getSuperClassMethod(obj, methodName, args));
		//System.out.println(new Object().equals(new Student()));
	}
}
