package com.ultra.java高级;

public class ProxyDaoImpl implements ProxyDao {

	@Override
	public int add(int a, int b) {
		return a+b;
	}

	@Override
	public int sub(int a, int b) {
		return a-b;
	}

	@Override
	public void mul(int a, int b) {
		System.out.println(a*b);
	}

	@Override
	public void div(int a, int b) {
		System.out.println(a/b);
	}

}
