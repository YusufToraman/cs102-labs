package Linkedlist;

public class QueueByLinkedList<T> {
    Node<T> head;

    public void enqueue(T element){
        //belki head null'sa koşulu olabilir
        Node<T> current = new Node<>(element);
        current.element = element;
        current.next = head;
        head = current;
    }

    public void dequeue(){

        if(head == null || head.next == null){
            System.out.println("Cant be deleted");
            return;
        }

        Node<T> second_last = head;
        while (second_last.next.next != null)
            second_last = second_last.next;
 
        // Change next of second last
        second_last.next = null;
    }

    public T displayNext(){
        Node<T> curr = head;
        if(curr == null){
            return null;
        }
        while(curr.next != null){
            curr = curr.next;
        }
        return curr.element;
    }
}
