// 2022/1/16 10:49

package com.pininkara.collections;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class Collection_ {
    public static void main(String[] args) {
        List<Book> list = new ArrayList<>();
        list.add(new Book("傲慢与偏见","简·奥斯汀",21));
        list.add(new Book("战争与和平","列夫·尼古拉耶维奇·托尔斯泰",12));
        list.add(new Book("红与黑","司汤达",33));
        list.add(new Book("红楼梦","曹雪芹",14));
        list.add(new Book("动物庄园","乔治·奥威尔",10));

        Stream<Book> stream=list.stream();
        stream.sorted(Comparator.comparing(Book::getPrice).reversed())
                .forEach(System.out::println);
    }
}

@Data
@NoArgsConstructor
@AllArgsConstructor
class Book{
    private String name;
    private String author;
    private int price;
}
