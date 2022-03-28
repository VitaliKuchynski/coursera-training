package InterviewCamp.linkedList;

// Easy: Find if a given Linked List has a cycle
public class CircularLinkedListCheck {


    static class Node {
        Node next;
        int data;

        public Node(int tmp) {
            data = tmp;
        }
    }

    public static boolean isCircularLinkedList(Node node) {

        if (node == null) {
            return false;
        }

        Node slow, fast;

        slow = fast = node;

        while (true) {

            slow = slow.next;

            if (fast.next != null) {
                fast = fast.next.next;
            } else {
                return false;
            }

            if(slow == null || fast == null) { // if either hits null..no loop
                return false;
            }

            if(slow == fast) { // if the two ever meet...we must have a loop
                return true;
            }
        }


    }
    public static void main(String[] a){

        Node n1 = new Node(34);
        Node n2 = new Node(25);
        Node n3 = new Node(31);
        Node n4 = new Node(56);
        Node n5 = new Node(45);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n1;


        System.out.println("Is it circular linked list: "+ isCircularLinkedList(n1));
    }

}
