package Linkedlist;

import java.util.NoSuchElementException;

public class LinkedList<T> {
    Node<T> head;

    public LinkedList(){
        this.head = null;
    }

    public void insert(T element){
        Node<T> addedNode = new Node<>(element);
        addedNode.element = element;
        addedNode.next = null;

        if(head == null){
            head = addedNode;
        }
        else{
            Node <T>n = head;  //Head'i bozmadan son elemanı bulcam
            while(n.next != null){
                n = n.next; //1 node ilerle
            }
            n.next = addedNode;
        }
    }

    public void show(){

        try{
            Node<T> n = head;
            while(n.next != null){
                System.out.println(n.element);
                n = n.next;
            }
            System.out.println(n.element);
        }
        catch(NullPointerException npe){
            System.out.println("List is empty");
        }
    }

    public void insertAtBeginning(T element){
        Node <T>addedNode = new Node<>(element);
        addedNode.element = element;
        addedNode.next = head;
        head = addedNode;
    }

    public void insertAt(int index, T element){
        Node<T> addedNode = new Node<>(element);
        addedNode.element = element;
        addedNode.next = null;

        Node<T> current = head;

        if(index == 0){ //Make it head
            addedNode.next = head;
            head = addedNode;
            return; //or else for the for loop
        }
        else if(index < 0){
            System.out.println("Invalid Index");
            return;
        }
        try{
        for(int i = 0; i < index - 1; i++){
            current = current.next;
        }
            addedNode.next = current.next;
            current.next = addedNode;
        }
        catch(NullPointerException npe){
            System.out.println("Exceeds the index");
        }
    }

    public void delete(int index){
        if(head == null){
            throw new NoSuchElementException();
        }
        head = head.next;
    }

    public int length(){
        int length = 1;
        if(head == null){
            return 0;
        }
        else{
            Node<T> current = head;
            while(current.next != null){
                current = current.next;
                length++;
            }
        }
        return length;

    }

    public void traverseList(){
        Node<T> prev = null;
        Node<T> current = head;
        Node<T> next = null;
        while(current != null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
    }
}
