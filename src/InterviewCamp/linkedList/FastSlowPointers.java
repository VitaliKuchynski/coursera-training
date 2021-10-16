package InterviewCamp.linkedList;

public class FastSlowPointers {


    public static void main(String[] args) {

        Node n1 = new Node(null,1);
        Node n2 = new Node(null,2);
        Node n3 = new Node(null,3);
        Node n4 = new Node(null,4);
        Node n5 = new Node(null,5);
        Node n6 = new Node(null,6);
        Node n7 = new Node(null,7);
        Node n8 = new Node(null,8);

        n1.setNext(n2);
        n2.setNext(n3);
        n3.setNext(n4);
        n4.setNext(n5);
        n5.setNext(n6);
        n6.setNext(n7);
        n7.setNext(n8);
        n8.setNext(n3);

        System.out.println(findCycleLength(n1));
    }

    public static boolean hasCycle(Node head) {

        Node fast = head, slow = head;

        while (fast != null) {
            fast = fast.getNext();
            if (fast == slow) {
                return true;
            }

            if (fast != null) {
                fast = fast.getNext();
                if (fast == slow) {
                    return true;
                }
            }
        slow = slow.getNext();
        }

        return false;
    }

    // Level: MediumGiven a linked list that has a cycle, find the length of the cycle.
    // The length is in number of nodes

    public static int findCycleLength(Node head) {

        Node fast = head, slow = head;

        while (fast != null) {
            fast = fast.getNext();
            if (fast == slow) {
               break;
            }

            if (fast != null) {
                fast = fast.getNext();
                if (fast == slow) {
                    break;
                }
            }
            slow = slow.getNext();
        }

        if (fast == null) {
            return -1;
        }

        fast = fast.getNext();
        int nodesPassed = 1;
        while (fast != slow) {
            fast = fast.getNext();
            nodesPassed++;
        }
        return nodesPassed;
    }
}