package dadaStructuresRobEdwardsSDSU;


public class Main {
    public static void main(String[] args) {


        LinkedListD<Integer> linkedListD = new LinkedListD<Integer>();
        linkedListD.addLast(4);
        linkedListD.addFirst(1);
        linkedListD.addFirst(3);
        linkedListD.addLast(8);
        linkedListD.addLast(0);
        linkedListD.addLast(6);

        for(Integer element: linkedListD){
            System.out.println(element);
        }
        System.out.println(linkedListD.getCurrentSize());
        System.out.println(linkedListD.contains(0));
        System.out.println(linkedListD);

    }

}
