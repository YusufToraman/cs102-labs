package Linkedlist;

import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<String>();
        // list.insert("1");
        // list.insert("2");
        // list.insertAtBeginning("50");
        // list.insertAt(1, "300");
        // list.show();
        // list.traverseList();
        // System.out.println();
        // list.show();

        // StackByLinkedList<Integer> list = new StackByLinkedList<>();
        // list.push(10);
        // list.push(20);
        // list.push(30);
        // list.display();
        // System.out.println();
        // list.pop();
        // list.display();
        // System.out.println();
        // System.out.println(list.peek());

        // QueueByStack<Integer> queue = new QueueByStack<>();
        // queue.enqueue(1);
        // queue.enqueue(2);
        // queue.enqueue(3);
        // queue.enqueue(4);
        // System.out.println(queue.displayNextElement());
        // queue.dequeue();
        // System.out.println(queue.displayNextElement());
        // queue.dequeue();
        // queue.dequeue();
        // System.out.println(queue.displayNextElement());
        // queue.dequeue();
        // System.out.println(queue.displayNextElement());
        // queue.dequeue();

        QueueByLinkedList<Integer> queue2 = new QueueByLinkedList<>();
        queue2.enqueue(1);
        queue2.enqueue(2);
        queue2.enqueue(3);
        queue2.enqueue(4);
        System.out.println(queue2.displayNext());
        queue2.dequeue();
        queue2.dequeue();
        System.out.println(queue2.displayNext());
        queue2.dequeue();
        System.out.println(queue2.displayNext());
    }
}
