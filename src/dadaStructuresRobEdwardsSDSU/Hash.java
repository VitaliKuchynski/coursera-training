package dadaStructuresRobEdwardsSDSU;

import java.util.Iterator;


public class Hash<K, V>  implements Iterable<K>{

    int numElements, tableSize;
    double maxLoadFactor;
    java.util.LinkedList<HashElement<K, V>>[] hArray;

    public Hash(int tableSize){
        this.tableSize = tableSize;
        maxLoadFactor= 0.75;
        numElements = 0;

        hArray = (java.util.LinkedList<HashElement<K,V>>[]) new java.util.LinkedList [tableSize];

        for (int i = 0; i < tableSize; i++) {
            hArray [i] = new java.util.LinkedList<HashElement<K, V>>();
        }
    }


    class HashElement<K, V> implements Comparable<HashElement<K, V>> {
        K key;
        V value;

        public HashElement(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public int compareTo(HashElement<K, V> o) {
            return ((Comparable<K>) this.key).compareTo(o.key);
        }
    }

    public boolean add(K key, V value) {

        if((numElements/tableSize) > maxLoadFactor){
                resize(tableSize * 2);
        }

        HashElement<K, V> elem = new HashElement<>(key, value);
        int hashValue = key.hashCode();
        hashValue = hashValue & 0x7FFFFFFF;
        hashValue = hashValue % tableSize;

        hArray[hashValue].add(elem);
        numElements++;
        return true;
    }

    public boolean remove(HashElement<K, V> hashElement) {

        int hashValue = hashElement.key.hashCode();
        hashValue = hashValue & 0x7FFFFFFF;
        hashValue = hashValue % tableSize;

        hArray[hashValue].remove(hashElement);
        numElements--;
        return true;
    }

    public V getValue(K key) {
        int hashVal = key.hashCode();
        hashVal = hashVal & 0x7FFFFFFF;
        hashVal = hashVal % tableSize;
        for (HashElement<K, V> el : hArray[hashVal]) {

            if (((Comparable<K>)key).compareTo((el.key))==0){
                return el.value;
            }
        }
        return null;
    }

    public void resize(int newSize){

        java.util.LinkedList<HashElement<K, V>>[] newArray = (java.util.LinkedList<HashElement<K,V>>[]) new java.util.LinkedList [newSize];

        for (int i = 0; i < newSize; i++) {
            newArray [i] = new java.util.LinkedList<>();
        }

        for (K key : this) {
            V value = getValue(key);
            HashElement<K, V> el = new HashElement<>(key, value);
            int hashVal = key.hashCode();
            hashVal = hashVal & 0x7FFFFFFF;
            hashVal = hashVal % tableSize;
            newArray[hashVal].add(el);
        }
        hArray = newArray;
        tableSize = newSize;
    }

    @Override
    public Iterator<K> iterator() {
        return new IteratorHelper<>();
    }

    class IteratorHelper<T> implements Iterator<T> {

        T[] keys;
        int position;

        public IteratorHelper() {
            keys = (T[]) new Object[numElements];
            int p = 0;

            for (int i = 0; i < tableSize; i++) {

                java.util.LinkedList<HashElement<K, V>> list = hArray[i];
                for (HashElement<K, V> h: list) {
                    keys[p++] = (T) h.key;
                }
            }
            position = 0;
        }


        @Override
        public boolean hasNext() {
            return position < keys.length;
        }

        @Override
        public T next() {
            if (!hasNext()){
                return null;
            }

            return keys[position++];
        }
    }

    public static void main(String[] args) {

       Hash<Integer, String> hash = new Hash<>(5);
        hash.add(1, "1");
        hash.add(2, "2");
        hash.add(3, "23");

        for (int i = 0; i < hash.tableSize; i++) {
            System.out.println(hash.getValue(i));
        }


    }

}
