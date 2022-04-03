package InterviewCamp.linkedList;

import java.util.HashMap;

//Level: Hard Implement a data structure for a Least Recently Used (LRU) cache
public class LRUCache<K, V> {

    HashMap<K, Node<K, V>> map;

    Node<K, V> head;
    Node<K, V> tail;

    int cacheCapacity;

    public LRUCache(int cacheCapacity) {
        this.map = new HashMap<>();
        this.cacheCapacity = cacheCapacity;
    }

    //Read a value from cache
    public V read(K key) {
        Node<K, V> node = map.get(key);
        if (node == null) {
            return null;
        }

        remove(key); // remove from linked hash table
        add(node.getKey(), node.getValue()); // add back to front

        return node.getValue();
    }

    //Wright a value to cache
    public void write(K key, V value){
        if (map.size() == cacheCapacity) {
            remove(head.getKey());
        }
    // In this implementation, we create a new node every time.
    // If you want, you can also move the same node to the end.
        add(key, value);
    }

    //Remove a node to the end of the Linked Hash Table
    private void remove(K key){
        if (!map.containsKey(key)) {
            return;
        }
        Node<K, V> toRemove = map.get(key);
        removeFromLinkedList(toRemove);
        map.remove(key);
    }

    // Add a node to end of the Linked hash Table
    private void add(K key, V value){
        Node<K, V> newNode = new Node<>(key, value);
        appendToLinkedList(newNode);
        map.put(key, newNode);
    }
    // Add node to linked List
    public void appendToLinkedList(Node<K, V> toAdd){
        if (head == null) {
            head = toAdd;
        } else {
            tail.setNext(toAdd);
            toAdd.setPrev(tail);
        }
        tail = toAdd;
    }

    //Remove from linked list
    public void removeFromLinkedList(Node<K, V> toRemove){
        if (toRemove.getPrev() != null){
            toRemove.getPrev().setNext(toRemove.getNext());
        }

        if (toRemove.getNext() != null){
            toRemove.getNext().setPrev(toRemove.getPrev());
        }

        if (toRemove == head) {
            head = toRemove.getNext();
        }

        if (toRemove == tail) {
            tail = toRemove.getPrev();
        }
    }

    public class Node<K, V> {

        Node<K, V> next;
        Node<K, V> prev;
        K key;
        V value;

        public Node(K key, V value) {
            super();
            this.key = key;
            this.value =value;
        }

        public Node<K,V> getNext() {
            return next;
        }

        public void setNext(Node<K, V> next) {
            this.next = next;
        }

        public Node<K, V> getPrev() {
            return prev;
        }

        public void setPrev(Node<K, V> prev) {
            this.prev = prev;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {

        LRUCache<String, Integer> lruCache = new LRUCache<>(5);
        lruCache.write("test",2);
        System.out.println(lruCache.read("test"));
    }
}
