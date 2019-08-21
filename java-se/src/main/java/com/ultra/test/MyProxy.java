package com.ultra.test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyProxy {

	Service target=null;
	public MyProxy(Service target){
		this.target=target;
	}
	public Service getServiceProxy(){
		Service proxy=(Service) Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),new InvocationHandler() {
			
			@Override
			public Object invoke(Object proxy, Method method, Object[] args)
					throws Throwable {
				System.out.println("开启事务");
				try {
					Object result=method.invoke(target, args);
					System.out.println("关闭事务");
					return result;
				} catch (Exception e) {
					e.printStackTrace();
					System.out.println("事务回滚");
				}
				return null;
			}
		});
		return proxy;
	}
}
