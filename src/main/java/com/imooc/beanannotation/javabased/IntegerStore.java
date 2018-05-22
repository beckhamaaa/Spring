package com.imooc.beanannotation.javabased;

public class IntegerStore implements Store<Integer> {
    public void init() {
        System.out.println("IntegerStore This is init.");
    }

    public void destroy() {
        System.out.println("IntegerStore This is destroy.");
    }
}
