package InterviewCamp.linkedList;

public class NodeDoubly<K, V> {


    NodeDoubly<K, V> next;
    NodeDoubly<K, V> prev;
        K key;
        V value;

        public NodeDoubly(K key, V value) {
            super();
            this.key = key;
            this.value =value;
        }

        public NodeDoubly<K,V> getNext() {
            return next;
        }

        public void setNext(NodeDoubly<K, V> next) {
            this.next = next;
        }

        public NodeDoubly<K, V> getPrev() {
            return prev;
        }

        public void setPrev(NodeDoubly<K, V> prev) {
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
