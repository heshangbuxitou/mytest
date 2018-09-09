package com.zy.designs.iterator;

import java.util.List;

public class ConcreteMyIterator<E> implements MyIterator {
    List<E> list;
    int current;
    public <E> ConcreteMyIterator(List items) {
        list = items;
    }

    @Override
    public boolean hasNext() {
        return list.size() > current;
    }

    @Override
    public E next() {
        E e = list.get(current);
        current++;
        return e;
    }

}
