package dadaStructuresRobEdwardsSDSU;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedListD<E extends Comparable<E>> implements  Iterable<E>{

    private Node<E> head;
    private Node<E> tail;
    private int currentSize;

    public int getCurrentSize() {
        return currentSize;
    }

    public LinkedListD() {
        head = null;
        tail = null;
        currentSize = 0;
    }


    class Node<E> {
        Node<E> next;
        Node<E> previous;
        E data;

        public Node(E obj) {
            data = obj;
            next = previous = null;
        }
    }

    public void addFirst(E obj) {
        Node<E> node = new Node<E>(obj);
        if (head == null) {
            head = node;
            tail = node;
        } else {
            node.next = head;
            head.previous = node;
            head = node;
        }
        currentSize++;
    }

    public void addLast(E obj){
        Node<E> node = new Node<E>(obj);
        if (head == null) {
            head = node;
            tail = node;
        }else {
            node.previous= tail;
            tail.next=node;
            tail = node;
        }
        currentSize++;
    }

    public E removeFirst(){
        if(head==null){
            return null;
        }
        E temp = head.data;
        if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
            head.previous = null;//??
        }
        currentSize--;
        return temp;
    }

    public E removeLast(){
        if(head==null){
            return null;
        }
        E temp = tail.data;
        if(head ==tail){
            return removeFirst();
        }else{
            tail = tail.previous;
            tail.next=null;
        }
        currentSize--;
        return temp;
    }


    public E removeElement(E obj){
        Node<E> current=head;

        while(current!=null){
        if(obj.compareTo(current.data)==0){
            //remove first if one element in the list
            if (current == head) {
                return removeFirst();
            }
            //remove last if element at the end of the list
            if (current == tail) {
                return removeLast();
            }
            currentSize--;
            Node<E> prevNode = current.previous;
            Node<E> nextNode = current.next;
            prevNode.next =nextNode;
            nextNode.previous =prevNode;


            return current.data;
         }
            current = current.next;
        }
    return null;
    }

    public boolean contains(E obj){
        Node<E> current = head;
        while (current != null){
            if(current.data.compareTo(obj)==0){
                return true;
            }
            current=current.next;
        }
         return false;
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

    @Override
    public Iterator<E> iterator() {
        return new IteratorHelper();
    }

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

    @Override
    public String toString() {

        Node<E> temp = head;

        StringBuilder sb = new StringBuilder();

        while (temp != null) {
            sb.append(temp.data + " -> ");
            temp = temp.next;
        }
        return sb.toString();
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
