package InterviewCamp.linkedList;

import static InterviewCamp.linkedList.LinkedList.getOddEven;
import static InterviewCamp.linkedList.LinkedList.sortList;

public class Main {

    public static void main(String[] args) {


        Node n1 = new Node(null,1);
        Node n2 = new Node(null,2);
        Node n3 = new Node(null,3);
        Node n4 = new Node(null,4);
        Node n5 = new Node(null,5);
        Node n7 = new Node(null,6);
        Node n6 = new Node(null,7);

        n1.setNext(n2);
        n2.setNext(n3);
        n3.setNext(n4);
        n4.setNext(n5);
        n5.setNext(n7);
        n7.setNext(null);

        LinkedList linkedList = new LinkedList(n1, n7);

       linkedList.deleteNode(n1, n2);

        //System.out.println(linkedList.get(6).getData());

//        LinkedList l = getOddEven(linkedList);
//       // System.out.println(l.get(3).getData());

        for (int i = 1; i <= 6; i++) {

            System.out.println(linkedList.get(i).getData());
        }



    }
}
