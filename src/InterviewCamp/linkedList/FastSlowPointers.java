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

    // Level: Medium Given a linked list that has a cycle, find the length of the cycle.
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


    // Level: Medium Find the median node of a linked list. For example:1 -> 2 -> 3 -> 4 -> 5      Median node is 3.
    public static Node findMedian(Node head, Node tail) {

        if(head == null || tail == null) {
            return null;
        }

        Node fast = head, slow = head;

        while (fast.getNext() != null) {
            fast = fast.getNext();

            if (fast.getNext() != null) {
                fast = fast.getNext();
                slow = slow.getNext();
            }
        }
        return slow;
    }

    //  Level: MediumGiven a Linked List with a cycle, find the node where the cycle begins

    public static Node findCycleStart(Node head) {

        Node fast = head, slow = head;

        while (fast != null) {
            fast = fast.getNext();

            if (fast == slow) {
                break;
            }

            if (fast != null) {
                fast = fast.getNext();

                if (slow == fast) {
                    break;
                }
            }
            slow = slow.getNext();
        }

        // no cycle found
        if (fast == null){
            return null;
        }

        // find number nodes in cycle
        fast = fast.getNext();
        int cycleNodes = 1;
        while (fast != slow) {
            fast = fast.getNext();
            cycleNodes +=1;
        }

        //find start of cycle
        Node front = head, back = head;
        for (int i = 0; i < cycleNodes; i++) {
            front = front.getNext();
        }

        while (front != back) {
            front = front.getNext();
            back = back.getNext();
        }

        return front;
    }
}