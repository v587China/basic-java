package com.ultra.java;

import com.ultra.pojo.Person;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.junit.Test;

import javax.swing.Timer;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * lambda 表达式有3个部分:
 * 1 ) 一个代码块
 * 2 ) 参数
 * 3 ) 自由变量的值,这是指非参数而且不在代码中定义的变量==>只能引用值不会改变的变量
 *
 * @author admin
 */
public class A040LambdaTest {


    @Test
    public void testInterface1() {
        String[] strings = {"123", "25", "7686", "92872", "b"};
        System.out.println(Arrays.toString(strings));
        Comparator<String> lengthComparator = new LengthComparator();
        Arrays.sort(strings, lengthComparator);
        System.out.println(Arrays.toString(strings));
    }

    @Test
    public void testInterface2() {
        String[] strings = {"123", "25", "7686", "92872", "b"};
        System.out.println(Arrays.toString(strings));
        Comparator<String> lengthComparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        };
        Arrays.sort(strings, lengthComparator);
        System.out.println(Arrays.toString(strings));
    }

    /**
     * lambda标准语法示例(String str1,String str2)->{//do somethings return}
     */
    @Test
    public void testLambda() {
        String[] strings = {"123", "25", "7686", "92872", "b"};
        System.out.println(Arrays.toString(strings));
        Comparator<String> lengthComparator = (String str1, String str2) -> {
            return str1.compareTo(str2);
        };
        Arrays.sort(strings, lengthComparator);
        System.out.println(Arrays.toString(strings));
    }

    @Test
    public void testLambda2() {
        String[] strings = {"123", "25", "7686", "92872", "b"};
        System.out.println(Arrays.toString(strings));
        Arrays.sort(strings, (String str1, String str2) -> {
            return str1.compareTo(str2);
        });
        System.out.println(Arrays.toString(strings));
    }

    /**
     * 参数类型可省略
     * 函数体只有一行可以省略{},和return(如果有返回值)
     */
    @Test
    public void testLambdaAbbr1() {
        String[] strings = {"123", "25", "7686", "92872", "b"};
        System.out.println(Arrays.toString(strings));
        Arrays.sort(strings, (str1, str2) -> str1.length() - str2.length());
        System.out.println(Arrays.toString(strings));
    }

    /**
     * 只有一个参数可以省略括号
     */
    @Test
    public void testLambdaAbbr2() {
        Timer t = new Timer(1000, event -> {
            System.out.println("At the tone,the time is " + new Date());
            Toolkit.getDefaultToolkit().beep();
        });
        t.start();
    }

    /**
     * 方法引用形式一
     * object::instanceMethod
     * 参数传递给方法
     */
    @Test
    public void testMethodReference() {
        Timer t0 = new Timer(1000, System.out::println);
        t0.start();

        ActionListener listener = System.out::println;
        Timer t1 = new Timer(1000, listener);
        t1.start();

        Timer t2 = new Timer(1000, System.out::println);
        t2.start();

        Timer t3 = new Timer(1000, event -> {
            System.out.println(event);
        });
        t3.start();
    }

    /**
     * 二 TODO方法引用形式
     * Class::staticMethod
     * 参数传递给方法
     */
    @Test
    public void testMethodReference2() {
        Error error = getBean(Error::buildError);
        System.out.println(error);
    }

    /**
     * 方法引用形式三
     * Class::instanceMethod
     * 第一个参数会成为方法的执行者
     * 第二个参数是方法的参数
     */
    @Test
    public void testMethodReference3() {
        String[] strings = {"123", "25", "7686", "92872", "b"};
        System.out.println(Arrays.toString(strings));
        Arrays.sort(strings, Comparator.comparingInt(String::length));
        System.out.println(Arrays.toString(strings));
    }

    @Test
    public void testMethodReference4() {
        Person[] persons = new Person[10];
        Arrays.sort(persons, Comparator.comparing(Person::getName));
        Arrays.sort(persons, Comparator.comparing(Person::getName).thenComparing(Person::getId));
        Arrays.sort(persons, Comparator.comparing(Person::getName, Comparator.comparingInt(String::length)));
    }

    @Test
    public void testConstructorReference() {
        List<String> names = new ArrayList<>();
        names.add("aa");
        Stream<Person> stream = names.stream().map(Person::new);
        List<Person> people = stream.collect(Collectors.toList());
        System.out.println(Arrays.toString(people.toArray()));
    }

    /**
     * Java有一个限制,无法构造泛型类型T的数组
     * 数组构造器引用对于克服这个限制很有用
     */
    @Test
    public void testConstructorReference2() {
        List<Person> people = new ArrayList<>();
        people.add(new Person("aa", 10));
        Person[] peopleArray = people.stream().toArray(Person[]::new);
        System.out.println(Arrays.toString(peopleArray));
    }

    @Test
    public void testLambdaRunnable() {
        run(() -> System.out.println("Hello world"));
    }

    private void run(Runnable runnable) {
        for (int i = 0; i < 5; i++) {
            runnable.run();
        }
    }

    @Test
    public void testLambdaSupplier() {
        Person person = getBean(Person::new);
        System.out.println(person);
    }

    private <T> T getBean(Supplier<T> supplier) {
        return supplier.get();
    }

    /**
     * TODO
     */
    @Test
    public void testLambdaConsumer() {
        Person person = new Person();
        accept(t -> t.setName("abc"), person).andThen(t -> t.setName("bcd"));
        System.out.println(person);
    }

    private <T> Consumer<T> accept(Consumer<T> consumer, T t) {
        consumer.accept(t);
        return consumer;
    }


    @Test
    public void map() {
        Map<String, String> maps = new HashMap<>(4);
        maps.put("a", "AA");
        maps.put("b", "BB");
        maps.put("c", "CC");
        maps.forEach((key, value) -> {
            System.out.println(key + ":" + value);
        });
    }
}


class LengthComparator implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        return o1.length() - o2.length();
    }
}

@Setter
@Getter
@ToString
@AllArgsConstructor
class Error {

    /**
     * 错误码
     */
    private int code;
    /**
     * 错误描述
     */
    private String message;

    /**
     * 错误码和错误信息
     *
     * @return Error
     */
    static Error buildError() {
        return new Error(404, "page is not found");
    }
}