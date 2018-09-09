package com.zy.designs.iterator;

import java.util.ArrayList;
import java.util.List;

public class ConcreteAggregate<E> implements Aggregate<E>{

    private List<E> items = new ArrayList<E>();

    @Override
    public MyIterator CreateIterator() {
        return new ConcreteMyIterator(items);
    }

    public int Count(){
        return items.size();
    }

    public void add(E e){
        items.add(e);
    }

    public E get(int index){
        return items.get(index);
    }
}
