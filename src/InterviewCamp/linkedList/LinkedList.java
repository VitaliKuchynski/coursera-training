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
        this.head = null;
        this.tail = null;
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
                throw new IndexOutOfBoundsException("No node at index " + Integer.toString(n));
            }
        }
        return node;
    }
    // A function that adds a node to a linked list.
   // Level: EasyThe append function is especially useful in Linked List problems.
    // On the face, it is pretty simple.
    // But once you know it by heart, you can apply it to a ton of problems quickly
    public void append(Node toAdd) {

        if(head == null) {
            head = toAdd;
        } else {
            tail.setNext(toAdd);
        }
        tail = toAdd;
    }


    //(Level: Easy) You are given a Linked List with nodes that have values 0, 1 or 2.
    // Sort the linked list. For example,
    //Input: 1 -> 0 -> 2 -> 1 -> 2 -> 1
    //Output: 0 -> 1 -> 1 -> 1 -> 2 -> 2

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

    // (Level: Easy) Odd Even Linked List: Given a Linked List L, separate it into 2 Linked Lists.
    // One contains L's odd nodes and the other contains L's even nodes.
    // For example: Input: Head -> 1 -> 2 -> 3 -> 4 -> 5
    // Result 1: Head -> 1 -> 3 -> 5
    // Result 2: Head -> 2 -> 4
    //
    // Note: Odd and Even here refer to the node's position, not value.

    public static LinkedList getOddEven(LinkedList input) {

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

    public  void deleteNode(Node toDelete, Node prev) {
        if (toDelete == null) {
            return;
        }
        if (toDelete == head) {
            head = toDelete.getNext();
        } else if (toDelete == tail) {
            tail = prev;
        }

        if (prev != null) {
            prev.setNext(toDelete.getNext());
        }
    }

    public void deleteWithoutPrevNode(Node toDelete) {
        Node next = toDelete.getNext();
        if (next == null) {
            return;
        }

        toDelete.setData(next.getData());
        deleteNode(next, toDelete);

    }
}
