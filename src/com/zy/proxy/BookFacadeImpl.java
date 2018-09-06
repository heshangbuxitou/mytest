package com.zy.proxy;

public class BookFacadeImpl implements BookFacade{
    @Override
    public void addBook() {
        System.out.println("add book logic is running。。。");
    }

    @Override
    public void deleteBook() {
        System.out.println("delete book logic is running。。。");
    }
}
