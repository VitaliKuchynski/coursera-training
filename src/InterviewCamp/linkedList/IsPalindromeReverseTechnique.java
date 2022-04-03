package InterviewCamp.linkedList;

//Technique: Reverse a Linked ListLevel: Medium
// Is Palindrome: Given a Linked List, determine if it is a Palindrome.

public class IsPalindromeReverseTechnique {

    public static boolean isPalindrome(Node head) {
        if (head== null) {
            return false;
        }
        Node median = findMedian(head);
        Node last = reverse(median);

        Node start = head, end = last;

        while (start != null && end != null) {
            if (start.data != end.data) {
                return false;
            }
            start = start.next;
            end = end.next;
        }
        return true;
    }

    public static Node reverse(Node head) {

        Node prev = null, current = head;

        while (current != null) {
            Node next = current.getNext();
            current.setNext(prev);
            prev = current;
            current = next;
        }
        return prev;
    }

    public static Node findMedian(Node head) {

        Node fast = head, slow = head;

        while (fast.next != null) {
            fast = fast.next;
            if (fast.next == null) {
                break;
            }
            fast = fast.next;
            slow = slow.next;

        }
     return slow;
    }

    public static void main(String[] args) {

        Node head = new Node(null,1);
        Node n2 = new Node(null,2);
        Node n3 = new Node(null,3);
        Node n4 = new Node(null,4);
        Node n5 = new Node(null,3);
        Node n6 = new Node(null,2);
        Node tail = new Node(null,1);

        head.setNext(n2);
        n2.setNext(n3);
        n3.setNext(n4);
        n4.setNext(n5);
        n5.setNext(n6);
        n6.setNext(tail);
        tail.setNext(null);

        System.out.println(isPalindrome(head));
    }

}
