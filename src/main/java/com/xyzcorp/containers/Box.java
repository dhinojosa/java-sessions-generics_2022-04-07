package com.xyzcorp.containers;

import java.util.Objects;
import java.util.StringJoiner;
import java.util.function.Function;

public class Box<E extends Comparable<E>> implements Comparable<Box<E>> {

    private final E e;

    protected Box(E e) {
        this.e = e;
    }

    public static <A extends Comparable<A>> Box<A> of(A a) {
        return new Box<>(a);
    }

    public E contents() {
        return e;
    }

    public <R extends Comparable<R>> Box<R> map(Function<? super E, ? extends R> function) {
        R result = function.apply(e);
        return new Box<>(result);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Box<?> box = (Box<?>) o;
        return Objects.equals(e, box.e);
    }

    @Override
    public int hashCode() {
        return Objects.hash(e);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Box.class.getSimpleName() + "[", "]")
            .add("e=" + e)
            .toString();
    }


    @Override
    public int compareTo(Box<E> o) {
        return o.e.compareTo(this.e);
    }
}
