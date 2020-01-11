package com.ultra.java;

import lombok.*;
import org.junit.Test;

import javax.swing.Timer;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.*;
import java.util.function.*;
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


    private static final int JD_MIN_NO = 1000;
    private static final int JD_NEW_BASE_NO = 10000;

    private static final String TY_PREFIX = "ty-";
    private static final String JD_PREFIX = "jd-";


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
            return str1.length() - str2.length();
        };
        Arrays.sort(strings, lengthComparator);
        System.out.println(Arrays.toString(strings));
    }

    @Test
    public void testLambda2() {
        String[] strings = {"123", "25", "7686", "92872", "b"};
        System.out.println(Arrays.toString(strings));
        Arrays.sort(strings, (String str1, String str2) -> {
            return str1.length() - str2.length();
        });
        System.out.println(Arrays.toString(strings));
    }

    /**
     * 参数类型可省略
     * 函数体只有一行可以省略{},return(如果有返回值),最后的分号
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
     * 参数省略,并且参数是方法的实参(如果有参数)
     */
    @Test
    public void testMethodReference() {
        ActionListener listener = System.out::println;
        Timer t = new Timer(1000, listener);
        t.start();
    }

    /**
     * 二 方法引用形式
     * Class::staticMethod
     * 参数省略,并且参数是方法的实参(如果有参数)
     */
    @Test
    public void testMethodReference2() {
        //无参
        Supplier<Person> personSupplier = Person::build;
        Person person = personSupplier.get();
        System.out.println(person);
        //有参
        Consumer<String> personConsumer = Person::print;
        personConsumer.accept("abc");
        System.out.println(personConsumer);
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
        ToIntFunction<String> toIntFunction = String::length;
        Arrays.sort(strings, Comparator.comparingInt(toIntFunction));
        System.out.println(Arrays.toString(strings));
    }

    @Test
    public void testMethodReference4() {
        Person[] persons = new Person[10];
        Arrays.sort(persons, Comparator.comparing(Person::getName));
        Arrays.sort(persons, Comparator.comparing(Person::getName).thenComparing(Person::getNo));
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
        Runnable runnable = () -> System.out.println("Hello world");
        runnable.run();
    }

    @Test
    public void testLambdaSupplier() {
        Supplier<Person> supplier = Person::new;
        Person person = supplier.get();
        System.out.println(person);
    }

    @Test
    public void testLambdaConsumer() {
        Person person = new Person();
        person.setName("abc");
        Consumer<Person> consumer = t -> t.setName(JD_PREFIX + t.getName());
        consumer.accept(person);
        System.out.println(person);
    }

    /**
     * Consumer andThen
     */
    @Test
    public void testLambdaConsumerAndThen() {
        Person person = new Person();
        person.setNo(1001);
        person.setName("abc");
        Consumer<Person> nameConsumer = t -> t.setName(JD_PREFIX + t.getName());
        Consumer<Person> noConsumer = t -> t.setNo(JD_NEW_BASE_NO + t.getNo());
        Consumer<Person> nameNoConsumer = nameConsumer.andThen(noConsumer);
        nameNoConsumer.accept(person);
        System.out.println(person);
    }

    @Test
    public void testLambdaBiConsumer() {
        Person person = new Person();
        person.setName("abc");
        BiConsumer<Person, String> biConsumer = (t, u) -> t.setName(u + t.getName());
        biConsumer.accept(person, JD_PREFIX);
        System.out.println(person);
    }

    @Test
    public void testLambdaBiConsumerAndThen() {
        Person person = new Person();
        person.setName("abc");
        person.setNo(1001);
        BiConsumer<Person, String> nameBiConsumer = (t, u) -> {
            t.setName(u + t.getName());
        };
        BiConsumer<Person, String> noBiConsumer = (t, u) -> {
            t.setNo(JD_NEW_BASE_NO + t.getNo());
        };
        BiConsumer<Person, String> nameNoBiConsumer = nameBiConsumer.andThen(noBiConsumer);
        nameNoBiConsumer.accept(person, JD_PREFIX);
        System.out.println(person);
    }

    @Test
    public void testFunction() {
        Person person = new Person();
        person.setNo(1001);
        person.setName("abc");
        Function<Person, Boolean> function = t -> {
            Integer no = t.getNo();
            if (no > JD_MIN_NO && no < JD_NEW_BASE_NO) {
                t.setNo(JD_NEW_BASE_NO + no);
                return true;
            }
            return false;
        };
        Boolean apply = function.apply(person);
        System.out.println(apply);
    }

    @Test
    public void testFunctionCompose() {
        Person person = new Person();
        person.setNo(1001);
        person.setName("abc");
        Function<Boolean, String> nameFunction = t -> {
            if (t) {
                return JD_PREFIX;
            }
            return TY_PREFIX;
        };
        Function<Person, Boolean> noFunction = t -> {
            Integer no = t.getNo();
            if (no < JD_MIN_NO) {
                return false;
            }
            if (no < JD_NEW_BASE_NO) {
                t.setNo(JD_NEW_BASE_NO + no);
            }
            return true;
        };
        Function<Person, String> prefixFunction = noFunction.andThen(nameFunction);
        String prefix = prefixFunction.apply(person);
        person.setName(prefix + person.getName());
        System.out.println(person);
    }

    @Test
    public void testFunctionAndThen() {
        Person person = new Person();
        person.setNo(1001);
        person.setName("abc");
        Function<Person, Boolean> noFunction = t -> {
            Integer no = t.getNo();
            if (no < JD_MIN_NO) {
                return false;
            }
            if (no < JD_NEW_BASE_NO) {
                t.setNo(JD_NEW_BASE_NO + no);
            }
            return true;
        };
        Function<Boolean, String> nameFunction = t -> {
            if (t) {
                return JD_PREFIX;
            }
            return TY_PREFIX;
        };
        Function<Person, String> prefixFunction = noFunction.andThen(nameFunction);
        String prefix = prefixFunction.apply(person);
        person.setName(prefix + person.getName());
        System.out.println(person);
    }

    @Test
    public void testFunctionIdentity() {
        Person person = new Person();
        person.setName("abc");
        Function<Person, Person> identity = Function.identity();
        Person apply = identity.apply(person);
        System.out.println(apply == person);
    }

    @Test
    public void testBiFunction() {
        Person person = new Person();
        person.setNo(1001);
        person.setName("abc");
        BiFunction<Person, String, Boolean> biFunction = (t, u) -> {
            if (t.getNo() > JD_MIN_NO) {
                t.setName(u + t.getName());
                return true;
            }
            return false;
        };
        Boolean apply = biFunction.apply(person, JD_PREFIX);
        System.out.println(apply);
    }

    @Test
    public void testUnaryOperator() {
        Person person = new Person();
        person.setName("abc");
        UnaryOperator<Person> unaryOperator = t -> {
            t.setName(JD_PREFIX + t.getName());
            return t;
        };
        person = unaryOperator.apply(person);
        System.out.println(person);
    }

    @Test
    public void testBinaryOperator() {
        Person person = new Person();
        person.setName("abc");
        Person newPerson = new Person();
        BinaryOperator<Person> binaryOperator = (t1, t2) -> {
            t2.setName(JD_PREFIX + t1.getName());
            return t2;
        };
        newPerson = binaryOperator.apply(person, newPerson);
        System.out.println(person);
        System.out.println(newPerson);
    }

    @Test
    public void testPredicate() {
        Person person = new Person();
        person.setName("abc");
        Predicate<Person> predicate = t -> t.getName().startsWith(JD_PREFIX);
        boolean result = predicate.test(person);
        System.out.println(result);
    }

    @Test
    public void testBiPredicate() {
        Person person = new Person();
        person.setName("jd-abc");
        BiPredicate<Person, String> predicate = (t, u) -> t.getName().startsWith(u);
        boolean result = predicate.test(person, JD_PREFIX);
        System.out.println(result);
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
@NoArgsConstructor
@AllArgsConstructor
class Person {

    private String name;
    private Integer no;

    public Person(String name) {
        this.name = name;
    }

    public static Person build() {
        return new Person();
    }

    public static void print(String name) {
        System.out.println(name);
    }
}