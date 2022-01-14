// 2022/1/14 15:26

package com.pininkara.juc.function;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Test01 {
    public static void main(String[] args) {
        Function<String,String> function=s -> s+s;
        //Function<String,String> function=(s) -> {return s+s;};

        Predicate<String> predicate= String::isEmpty;

        Consumer<String> consumer= x -> System.out.println(x);

        Supplier<String> supplier=() ->"HelloWorld";

        System.out.println(predicate.test("aaa"));

        consumer.accept("hello");

        System.out.println(supplier.get());


    }
}
