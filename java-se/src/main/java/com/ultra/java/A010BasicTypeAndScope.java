package com.ultra.java;

import org.junit.Test;

import java.util.Arrays;

/**
 * 基本数据类型和作用域
 *
 * @author admin
 */
public class A010BasicTypeAndScope {

    /**
     * 基本数据类型的变量:生命周期是由它的作用域决定的,它的生命周期可以确定,它存放在堆栈中;
     * 对象引用:生命周期也是由它的作用域决定的,它的生命周期也可以确定,它也存放在堆栈中,
     * java对象:生命周期并不是由它的作用域决定的,当不再有引用指向一个对象时,这个对象就成为了一个垃圾,会在垃圾回收器执行时,被清理,对象的生命周期并不确定,它存放在堆中。
     */
    // 基本数据类型默认值
    /**
     * boolean默认false
     */
    private boolean b;
    /**
     * 在Java中,char类型描述了UTF-16编码中的一个代码单兀
     * char默认值\u0000
     * char类型的值可以表示为十六进制值,其范围从Unicode编码的\u0000到\uffff(不区分大小写;中文范围4E00-9FA5)
     * Unicode码扩展自ASCII字元集
     */
    private char c;
    /**
     * byte默认0(byte)
     */
    private byte by;
    /**
     * short默认0(short)
     */
    private short s;
    /**
     * int默认0
     */
    private int i;
    /**
     * long默认0L
     */
    private long l;
    /**
     * float默认0.0f
     */
    private float f;
    /**
     * double默认0.0d
     */
    private double d;
    /**
     * 对象默认null
     */
    private String str;

    /**
     * 基本数据类型默认值
     *
     * @param args null
     */
    public static void main(String[] args) {
        A010BasicTypeAndScope demo = new A010BasicTypeAndScope();
        System.out.println(demo.b);
        // 转义序列会在解析代码之前得到处理(\ u,表示特殊字符:\b,\t,\n,\r,\\,\",\')
        // \ u可以出现在加引号的字符常量或字符串之外(而其他所有转义序列不可以)
        // 特殊字符的转义序列如下
        // \b 退格 \u0008
        // \" 双引号 \u0022
        // \t 制表 \u0009
        // \' 单引号 \u0027
        // \n 换行 \u000a
        // \\ 反斜杠 \u005c
        // \r 回车 \u000d
        System.out.println(demo.c);
        System.out.println(demo.c == '\u0000');
        System.out.println(demo.by);
        System.out.println(demo.s);
        System.out.println(demo.i);
        System.out.println(demo.l);
        System.out.println(demo.f);
        System.out.println(demo.d);
        System.out.println(demo.str);
    }

    /**
     * 局部变量必须在赋值之后才能调用,没有初始化默认值
     */
    @Test
    public void testLocalVariable() {
        int i = 0;
        String s = null;
        System.out.println(i);
        System.out.println(s);
    }

    /**
     * 转移序列\ u
     */
    @Test
    public void testChar() {
        System.out.println('\u4EFF');
        System.out.println('\u0041');
    }

    /**
     * 在Unicode标准中,码点采用十六进制书写,并加上前缀U+;Unicode的码点可以分成17个代码级别
     * 第一个代码级别称为基本的多语言级别(basic multilingual plane),码点U+0000到U+FFFF
     * 其余的 16个级别码点从U+10000到U+10FFFF
     * UTF-16编码采用不同长度的编码表示所有Unicode码点.在基本的多语言级别中,每个字符用16位表示
     * 通常被称为代码单元(code unit);而辅助字符采用一对连续的代码单元进行编码
     */
    @Test
    public void testCodePoint() {
        String greeting = "Hello";
        // length方法将返回采用UTF-16编码表示的给定字符串所需要的代码单元数量
        int n = greeting.length();
        System.out.println(n);
        // 获取实际的长度,即码点数量
        int cpCount = greeting.codePointCount(0, n);
        System.out.println(cpCount);
        // 调用s.charAt(n)将返回位置n的代码单元,n介于0~s.length()-l之间
        char first = greeting.charAt(0);
        char last = greeting.charAt(4);
        System.out.println(first);
        System.out.println(last);

        // 第i个码点,应该使用下列语句
        int index = greeting.offsetByCodePoints(0, 3);
        int cp = greeting.codePointAt(index);
        System.out.println(index);
        System.out.println(cp);
    }

    /**
     * 码点转化char,String以及打印辅助字符码点
     */
    @Test
    public void testAssistCode() {
        int x = 0x1D546;
        String y = new String(Character.toChars(x));
        System.out.println(y);
        System.out.println((int) y.charAt(0));
        System.out.println((int) y.charAt(1));
    }

    /**
     * 字符串和码点相互转化
     */
    @Test
    public void testMutualConvert() {
        String str = "Hello";
        int[] codePoints = str.codePoints().toArray();
        System.out.println(Arrays.toString(codePoints));
        str = new String(codePoints, 0, codePoints.length);
        System.out.println(str);
    }

}
