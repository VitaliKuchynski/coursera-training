package InterviewCamp.linkedList;

public class LinkedList {

    Node head;
    Node tail;

    public LinkedList(Node head, Node tail) {
        super();
        this.head = head;
        this.tail = tail;
    }

    public LinkedList() {
        super();
    }

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public Node getTail() {
        return tail;
    }

    public void setTail(Node tail) {
        this.tail = tail;
    }

    public Node get(int n) {

        Node node = head;

        for (int i = 0; i < n - 1; i++) { // move forward n - 1 times
            if (node != null) {
                node = node.getNext();
            } else {
                throw new IndexOutOfBoundsException("No node at index " + Integer.toString(n));
            }

            if (node == null) {
                throw new IndexOutOfBoundsException("No node at index" + Integer.toString(n));
            }
        }
        return node;
    }

    public void append(Node toAdd) {

        if(head == null) {
            head = toAdd;
        } else {
            tail.setNext(toAdd);
        }
        tail = toAdd;
    }

    public static LinkedList sortList(LinkedList input) {

        if (input == null) {
            return new LinkedList();
        }
        LinkedList list0 = new LinkedList();
        LinkedList list1 = new LinkedList();
        LinkedList list2 = new LinkedList();

        Node current = input.head;

        while (current != null) {
            switch (current.getData()) {
                case 0: list0.append(current);
                break;
                case 1: list1.append(current);
                break;
                case 2: list2.append(current);
                break;
                default: throw new IllegalArgumentException("Invalid value: " + current.getData());
            }
            current = current.getNext();
        }

        //set tails to null
        if (list0.tail != null) {
            list0.tail.next = null;
        }
        if (list1.tail != null) {
            list1.tail.next = null;
        }
        if (list2.tail != null) {
            list2.tail.next = null;
        }


        //attached list in sequence
        LinkedList result = new LinkedList();
        appendList(list0, result);
        appendList(list1, result);
        appendList(list2, result);

        return result;
    }

    public static void appendList(LinkedList toAppend, LinkedList original) {
        if (toAppend == null || toAppend.head == null) {
            return;
        }

        original.append(toAppend.head);
        original.tail = toAppend.tail;
    }

    public LinkedList getOddEven(LinkedList input) {

        LinkedList odd = new LinkedList();
        LinkedList even = new LinkedList();

        Node current = input.head;
        int index = 0;

        while (current != null) {
            index++;
            LinkedList destination = index % 2 == 0 ? even : odd;
            destination.append(current);
            current = current.getNext();

        }

        if (even.getTail() != null) {
            even.getTail().setNext(null);
        }

        if (odd.getTail() != null) {
            odd.getTail().setNext(null);
        }

        LinkedList result = new LinkedList();
        appendList(odd, result);
        appendList(even, result);
       return result;

    }
}
