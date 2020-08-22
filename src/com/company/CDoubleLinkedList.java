package com.company;

public class CDoubleLinkedList {
    Node head;
    int count=0;

    public void insertsort(int data, int Piriorty) {
        Node node = new Node(data, Piriorty);
        if (node != null) {
            if (head == null) {
                head = node;
                head.previous = head.next = node;
            } else if (node.piriorty >= head.piriorty) {
                if (node.piriorty > head.piriorty){
                    head.previous.next = node;
                    node.previous = head.previous;
                    node.next = head;
                    head.previous = node;
                    head = node;
                }else{
                    head.next.previous = node;
                    node.next = head.next;
                    head.next = node;
                    node.previous = head;
                }
            } else if (head.previous.piriorty >= node.piriorty) {
                head.previous.next = node;
                node.previous = head.previous;
                node.next = head;
                head.previous = node;
            } else {
                Node temp = head;
                boolean value = true;
                do {
                    if (temp.piriorty < node.piriorty) {
                        temp = temp.previous;
                        temp.next.previous = node;
                        node.next = temp.next;
                        temp.next = node;
                        node.previous = temp;
                        value = false;
                    }
                    temp = temp.next;
                } while (value);
            }count++;
        }
    }

    public Node pop() {
        Node node = null;
        if (head != null) {
            count--;
            if (head == head.next) {
                node = head;
                head = null;
            } else {
                node = head.previous;
                node.previous.next = head;
                head.previous = node.previous;
            }
        }
        return node;
    }

    public int Counter() {

        return count;
    }


}
