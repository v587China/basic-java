package com.ultra.java;

public class A020操作符 {
    /*
     * 几乎所有的操作符都只能操作基本数据类型， 但是操作符"=","==","!="这些操作符能操作所有的对象， 除此之外，String类支持"+"和"+="。
     * 注意：System.out.println()中，"+"意味着“字符串连接”，如果 有必要，它还要执行“字符串转换”。
     */

    static void f(Letter y) {
        y.c = 'z';
    }

    public static void main(String[] args) {

        // 赋值操作符
        // 基本数据类型：eg：a=b,把a的内容复制给b，修改a的值不会影响b的值
        // 对象“赋值”：对一个对象操作时，我们真正操作的是对象的引用，赋值时实际
        // 是把应用复制到另一个地方,所以赋值后两个引用操作的是同一个对象。
        Letter x = new Letter();
        x.c = 'a';
        System.out.println("1:x.c:  " + x.c);
        // 此时传递的x的引用
        f(x);
        System.out.println("1:x.c:  " + x.c);

        // 算术操作符
        // +,-,*,/,%只能操作基本数据类型，但是+有字符串连接作用。
        // +,-作为一元操作符时，可以将较小类型的操作数转化为int。
        // +=,-=,*=,/=,%=有强转类型的功能。
        byte b = 1;
        // b=-b;不行，因为-把b的类型转化为了int类型.同+
        // b=b+1;不行 但是b+=1;可以
        b += 1;
        // b-=1;
        // b*=1;
        // b/=1;
        // b%=1;
        System.out.println(b);
        // 关系操作符
        // ==,!=适用于所有的基本数据类型，>,<,>=,<=适用于除boolean类型外的基本数据类型。
        // ==,!=还可以用于对象的比较，但是它比较的是对象的引用是否相同，而非对象的值是否相同。
        // 如果要比较对象的内容是否相同应使用equals方法
        Integer i1 = new Integer(1);
        Integer i2 = new Integer(1);
        System.out.println(i1 == i2);
        System.out.println(i1.equals(i2));
        // equals()默认比较的是引用而非内容，所以除非在自己的新类中覆盖equals()方法
        Letter l1 = new Letter();
        Letter l2 = new Letter();
        l1.c = l2.c;
        System.out.println(l1 == l2);
        System.out.println(l1.equals(l2));

        // 逻辑操作符
        // 与(&&)或(||)非(!)根据参数的逻辑关系产生一个布尔值，并且只能操作布尔值。
        // 注意：当在该使用String类型如果使用了布尔类型，布尔值会自动转成String类型的true、false
        boolean b2 = true;
        String s = "";
        s = s + b2;
        System.out.println(s);

        // 按位操作符
        // 操作整数基本数据类型的单个bit，即二进制。
        // &(与),|(或),^(异或)可以与=联合使用
        // &,|,^可以操作布尔值，但是它不会中途短路

        // 移位操作符
        // 移位操作符的运算对象也是二进制的位。只能用来处理整数类型(基本类型的一种)
        // <<左移操作符：按照操作符右侧指定的位数将操作符左侧的操作数向左移动(低位补0)。
        // >>有符号右移操作符：按照操作符右侧指定的位数将操作符左侧的操作数向右移动。若操作数为正，高位补；，操作数为负，高位补1。具有符号扩展功能，其符号不会改变（可能会置0）
        // >>>无符号右移操作符：按照操作符右侧指定的位数将操作符左侧的操作数向右移动。无论正负，高位补0。
        // 可以与=联合使用
        int ii = 512;
        ii = ii << 2;
        System.out.println(ii);
        ii = ii >> 4;
        System.out.println(ii);
    }
}

class Letter {
    char c;
}
