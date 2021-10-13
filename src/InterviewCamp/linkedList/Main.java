package InterviewCamp.linkedList;

import static InterviewCamp.linkedList.LinkedList.sortList;

public class Main {

    public static void main(String[] args) {


        Node head = new Node(null,0);
        Node n2 = new Node(null,1);
        Node n3 = new Node(null,1);
        Node n4 = new Node(null,0);
        Node n5 = new Node(null,2);
        Node tail = new Node(null,2);
        Node n6 = new Node(null,2);

        head.setNext(n2);
        n2.setNext(n3);
        n3.setNext(n4);
        n4.setNext(n5);
        n5.setNext(tail);
        tail.setNext(null);

        LinkedList linkedList = new LinkedList(head, tail);

        linkedList.append(n6);

        System.out.println(linkedList.get(2).getData());

        LinkedList l = sortList(linkedList);
        System.out.println(l.get(3).getData());

    }
}
