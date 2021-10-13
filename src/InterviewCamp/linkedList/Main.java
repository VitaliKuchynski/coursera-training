package InterviewCamp.linkedList;

public class Main {

    public static void main(String[] args) {


        Node head = new Node(null,34);
        Node n2 = new Node(null,25);
        Node n3 = new Node(null,31);
        Node n4 = new Node(null,56);
        Node n5 = new Node(null,45);
        Node tail = new Node(null,55);
        Node n6 = new Node(null,65);

        head.setNext(n2);
        n2.setNext(n3);
        n3.setNext(n4);
        n4.setNext(n5);
        n5.setNext(tail);
        tail.setNext(null);

        LinkedList linkedList = new LinkedList(head, tail);

        linkedList.append(n6);

        System.out.println(linkedList.get(7).getData());

    }
}
