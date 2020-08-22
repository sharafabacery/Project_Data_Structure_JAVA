package com.company;

public class Node {
     int data;
     int piriorty;
     Node next;
     Node  previous;



    public Node(int data, int piriorty) {
        this.data = data;
        this.piriorty = piriorty;
        next=previous=null;
    }


}
