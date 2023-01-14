package Linkedlist;

public class StackByLinkedList<T> {
    Node<T> head;
    public StackByLinkedList(){
        this.head = null;
    }

    public void push(T element){
        //Add to first
        Node<T> addedNode = new Node<T>(element);
        addedNode.element = element;
        addedNode.next = head;
        head = addedNode;
    }

    public boolean isEmpty(){
        return head == null;
    }

    public T peek(){
        if(!isEmpty()){
            return head.element;
        }
        else{
            System.out.println("Stack is empty");
            return null;
        }
    }

    public void pop(){

        if(isEmpty()){
            System.out.println("List is empty");
        }

        else{
            head = head.next;
        }
    }

    public void display(){
        System.out.println("Top to bottom");
        Node<T> current = head;
        while(current != null){
            System.out.println(current.element);
            current = current.next;
        }
    }
}
