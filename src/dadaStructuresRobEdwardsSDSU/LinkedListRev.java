package dadaStructuresRobEdwardsSDSU;

/**
 * Created by vitalikuchynski on 7/10/20.
 */
public class LinkedListRev<E> {

    class Node<E>{

        E data;
        Node<E> next;

        public Node(E obj){
            data = obj;
            next = null;
        }
    }

    private Node<E> head;
    private int currentSize;

    public LinkedListRev(){
        head = null;
        currentSize = 0;
    }

    public void addFirst(E obj){

        Node<E> node = new Node<E>(obj);

        node.next = head;
        head = node;
        currentSize++;
    }

}
