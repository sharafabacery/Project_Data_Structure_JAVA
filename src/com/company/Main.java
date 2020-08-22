package com.company;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Random random = new Random();
        CDoubleLinkedList cDoubleLinkedList = new CDoubleLinkedList();
        LStack lStack = new LStack();
        CQeueueL cQeueueL1 = new CQeueueL();
        CQeueueL cQeueueL2 = new CQeueueL();
        CQeueueL cQeueueL3 = new CQeueueL();

        int data = 1;
        int count = 0;
        int piriorty = random.nextInt(5) + 1;
        while (count != 100) {
            int op = random.nextInt(4) + 1;
            if (op == 1 && data <= 100) {

                cQeueueL1.EnQueue(data, piriorty);
                data++;
                piriorty = random.nextInt(5) + 1;
            } else if (op == 2 && cQeueueL1.count() != 0) {
                Node node = cQeueueL1.DeQueue();
                if (lStack.count() == cQeueueL2.count() && lStack.count() == cDoubleLinkedList.Counter()) {
                    int rand = random.nextInt(3) + 1;
                    if (rand == 1) {
                        lStack.push(node.data, node.piriorty);
                    } else if (rand == 2) {
                        cDoubleLinkedList.insertsort(node.data, node.piriorty);
                    } else if (rand == 3) {
                        cQeueueL2.EnQueue(node.data, node.piriorty);
                    }

                } else {
                    int smallest = Math.min(lStack.count(), Math.min(cQeueueL2.count(), cDoubleLinkedList.Counter()));
                    if (smallest == lStack.count()) {
                        lStack.push(node.data, node.piriorty);
                    } else if (smallest == cDoubleLinkedList.Counter()) {
                        cDoubleLinkedList.insertsort(node.data, node.piriorty);
                    } else if (smallest == cQeueueL2.count()) {

                        cQeueueL2.EnQueue(node.data, node.piriorty);
                    }

                }
            } else if (op == 3 && (lStack.count() + cDoubleLinkedList.Counter() + cQeueueL2.count() > 0)) {

                Node node;
                if (lStack.count() == cQeueueL2.count() && lStack.count() == cDoubleLinkedList.Counter()) {
                    int rand = random.nextInt(3) + 1;

                    if (rand == 1) {

                        node = lStack.pop();
                        cQeueueL3.EnQueue(node.data, node.piriorty);
                    } else if (rand == 2) {

                        node = cDoubleLinkedList.pop();
                        cQeueueL3.EnQueue(node.data, node.piriorty);
                    } else if (rand == 3) {

                        node = cQeueueL2.DeQueue();
                        cQeueueL3.EnQueue(node.data, node.piriorty);
                    }

                } else {
                    int largest = Math.max(lStack.count(), Math.max(cQeueueL2.count(), cDoubleLinkedList.Counter()));

                    if (largest == lStack.count()) {
                        node = lStack.pop();
                        cQeueueL3.EnQueue(node.data, node.piriorty);
                    } else if (largest == cDoubleLinkedList.Counter()) {
                        node = cDoubleLinkedList.pop();
                        cQeueueL3.EnQueue(node.data, node.piriorty);
                    } else if (largest == cQeueueL2.count()) {
                        node = cQeueueL2.DeQueue();

                        cQeueueL3.EnQueue(node.data, node.piriorty);
                    }
                }
            } else if (op == 4 && cQeueueL3.count() > 0) {
                Node node=cQeueueL3.DeQueue();
                System.out.println(node.data+"       "+node.piriorty);
                count++;

            }
        }
        


    }
}