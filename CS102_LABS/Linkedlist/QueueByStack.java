package Linkedlist;

import java.util.Stack;

public class QueueByStack<T> implements Comparable<T>{
    Stack<T> stack1 = new Stack<>();
    Stack<T> stack2 = new Stack<>();

    public void enqueue(T element){

        while(!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }

        stack1.push(element);

        while(!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
    }

    public void dequeue(){
        if(stack1.isEmpty()){
            System.out.println("List is empty");
            return;
        }
        stack1.pop();
    }

    public T displayNextElement(){
        if(stack1.isEmpty()){
            return null;
        }
        return stack1.peek();
    }

    @Override
    public int compareTo(T o) {
    
        return 0;
    }
}
