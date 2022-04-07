package com.xyzcorp.bridge;

public class MyNode extends Node<Integer> {
    public MyNode(Integer data) {
        super(data);
        System.out.println("Invoked Constructor");
    }

    @Override
    public void setData(Integer data) {
        System.out.println("MyNode.setData");
        super.setData(data);
    }
}
