package InterviewCamp.linkedList;

//Reverse a linked list.
// You should useO(1) space
public class ReverseLinkedListTechnique {

    public static Node reverse(Node head) {
        Node prev = null, current = head;

        while (current != null){
            Node next = current.getNext();
            current.setNext(prev);
            prev = current;
            current = next;
        }
        return prev;
    }

    public static void main(String[] args) {

        Node head = new Node(null,1);
        Node n2 = new Node(null,2);
        Node n3 = new Node(null,3);
        Node n4 = new Node(null,4);
        Node n5 = new Node(null,5);
        Node n6 = new Node(null,7);
        Node tail = new Node(null,70);

        head.setNext(n2);
        n2.setNext(n3);
        n3.setNext(n4);
        n4.setNext(n5);
        n5.setNext(n6);
        n6.setNext(tail);
        tail.setNext(null);

        System.out.println(ReverseLinkedListTechnique.reverse(head).getData());
    }

}
