package com.xyzcorp.containers;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class BoxTest {
    @Test
    void testBoxInstantiation() {
        Box<Integer> box = new Box<>(30);
    }

    @Test
    void testBoxInstantiationWithString() {
        Box<String> box = new Box<>("Hello");
    }

    @Test
    void testBoxGetContent() {
        Box<String> box = new Box<>("Hello");
        String result = box.contents();
        assertThat(result).isEqualTo("Hello");
    }

    @Test
    void testBoxGetContent2() {
        Box<Integer> box = new Box<>(4);
        Integer result = box.contents();
        assertThat(result).isEqualTo(4);
    }

    @Test
    void testFactoryBoxWithInteger() {
        Box<Integer> box = Box.of(10);
        assertThat(box.contents()).isEqualTo(10);
    }

    @Test
    void testFactoryBoxWithString() {
        Box<String> box = Box.of("Foo");
        assertThat(box.contents()).isEqualTo("Foo");
    }

    @Test
    void testMap() {
        Box<String> box = Box.of("Foo");
        Box<Integer> resultBox = box.map(String::length);
        assertThat(resultBox).isEqualTo(Box.of(3));
    }


    @Test
    void testMap2() {
        Box<Integer> box = Box.of(10);
        Box<String> resultBox = box.map(i -> i + "!");
        assertThat(resultBox).isEqualTo(Box.of("10!"));
    }

//    @Test
//    void testMap3() {
//        Box<Object> box = Box.of(10);
//        Box<String> resultBox = box.map(i -> i.toString() + "!");
//        assertThat(resultBox).isEqualTo(Box.of("10!"));
//    }

    @Test
    void testSortingOfBoxes() {
        List<Box<Integer>> sorted =
            Stream.of(
                      Box.of(10), Box.of(3),
                      Box.of(1), Box.of(2))
                  .sorted().collect(Collectors.toList());
        System.out.println(sorted);
    }
}
