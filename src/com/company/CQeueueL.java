package com.company;

public class CQeueueL {

    Node front,rear;
    int count;
    public  CQeueueL(){
        front=rear=null;
        count=0;
    }
    public Boolean EnQueue(int data,int piriorty){
        boolean x=false;
        Node node=new Node(data,piriorty);
        if (node!=null){
            if (front==null){
                front=rear=node;
                node.next=rear;
            }else {
                rear.next=node;
                rear=node;
            }
            x=true;
            count++;
        }
        return x;
    }
    public Node DeQueue(){
        Node node=front;
        if (front!=null)
        {
            if (front==rear){

                front=rear=null;
            }else {

                front=front.next;

            }
            count--;
        }
        return node;
    }

    public int count() {return count;
    }

}
