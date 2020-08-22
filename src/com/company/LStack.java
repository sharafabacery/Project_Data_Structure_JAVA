package com.company;

public class LStack {
    Node tail;
    int count=0;

    public boolean push(int data ,int priorty) {
        boolean val = false;
        Node node = new Node(data,priorty);
        if (node != null) {
            node.previous = tail;
            tail = node;
            val = true;
            count++;
        }
        return val;
    }

    public Node pop() {
        Node temp = null;
        if (tail != null) {
            temp = tail;
            tail = tail.previous;
            count--;
        }
        return temp;
    }

    public int count() {

        return count;
    }







}
