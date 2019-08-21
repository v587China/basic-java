package com.ultra.java;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.junit.Test;

import com.ultra.java高级.ProxyDao;
import com.ultra.java高级.ProxyDaoImpl;

public class F008Reflect反射之proxy动态代理 {
	final ProxyDao proxyDao=new ProxyDaoImpl();
	@Test
	public void testProxy(){
		ProxyDao proxy=(ProxyDao) Proxy.newProxyInstance(proxyDao.getClass().getClassLoader(),new Class[]{ProxyDao.class},new InvocationHandler() {
			
			@Override
			public Object invoke(Object proxy, Method method, Object[] args)
					throws Throwable {
				System.out.println("该方法是"+method.getName()+"在操作之前执行");
				Object obj=method.invoke(proxyDao, args);
				if(obj!=null)
					System.out.println("该方法的结果是"+obj);
				System.out.println("在操作之后执行");
				return obj;
			}
		});
		proxy.add(1, 2);
		proxy.mul(2, 5);
	}
}
