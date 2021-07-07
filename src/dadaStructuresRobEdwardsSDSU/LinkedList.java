package dadaStructuresRobEdwardsSDSU;


import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList <E extends Comparable<E>> implements Iterable<E>{

    private Node<E> head;
    private Node<E> tail;
    private int currentSize;

    public int getCurrentSize() {
        return currentSize;
    }

    public LinkedList() {
        head = null;
        tail = null;
        currentSize = 0;
    }

    class Node<E> {

        Node<E> next;
        E data;

        public Node(E ob) {
            data = ob;
            next = null;
        }
    }

    public void addFirst(E ob) {
        Node<E> node = new Node<E>(ob);
        node.next = head;
        head = node;
        currentSize++;
    }

    public void addLast(E ob) {
        Node<E> node = new Node<E>(ob);

        if (head == null) {
            head = tail = node;
            currentSize++;
            return;
        }
        tail.next = node;
        tail = node;
        currentSize++;
    }

    public E removeFirst() {

        if (head == null) {
            return null;
        }
        E temp = head.data;
        if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
        }
        currentSize--;
        return temp;
    }

    public E removeLast() {
        if (head == null) {
            return null;
        }
        if (head == tail) {
            return removeFirst();
        }
        Node<E> current = head, previous = null;
        while (current != tail) {
            previous = current;
            current = current.next;
        }
        previous.next = null;
        tail = previous;
        currentSize--;

        return current.data;
    }

    public E removeElement(E obj) {

        Node<E> current = head, previous = null;

        //if the list empty
        while (current != null) {
            if (((Comparable<E>) current.data).compareTo(obj) == 0) {
                //remove first if one element in the list
                if (current == head) {
                    return removeFirst();
                }
                //remove last if element at the end of the list
                if (current == tail) {
                    return removeLast();
                }
                currentSize--;
                previous.next = current.next;
                return current.data;
            }
            previous = current;
            current = current.next;
        }
        return null;
    }

    public boolean contains(E obj) {
        Node<E> current = head;

        //if the list empty
        while (current != null) {
            if (current.data.compareTo(obj) == 0) {
                return true;
            }
            current=current.next;
        }
        return false;
    }

    public E peekInMiddle(E obj) {
        Node<E> current = head;

        //if the list empty
        while (current != null) {
            if (current.data.compareTo(obj) == 0) {
                return current.data;
            }
            current=current.next;
        }
        return null;
    }

    public E peekFist(){
        if(head==null){
            return null;
        }
        return head.data;
    }
    public E peekLast(){
        if(tail==null){
            return null;
        }
        return tail.data;
    }

    public Iterator<E> iterator(){
       return  new IteratorHelper();
    }

    //allows to iterate through element of list
    class IteratorHelper implements Iterator<E>{

        Node<E> index;
        public IteratorHelper(){
            index=head;
        }

        @Override
        public boolean hasNext() {
            return (index!= null);
        }

        @Override
        public E next() {
            if(!hasNext()) {
                throw new NoSuchElementException();
            }
            E val = index.data;
            index = index.next;
            return val;
        }
    }
}