package InterviewCamp.linkedList;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class SmallestSubarrayCoveringAllValues {

    public String getShortestSubString(String doc, HashSet<String> wordSet) {

        String result = null;

        HashMap<String, NodeDoubly> nodeMap = new HashMap<>();
        LinkedList linkedList = new LinkedList();

        WordIterator iter = new WordIterator(doc);

        while (iter.hasNext()) {
            WordIndex wordIndex = iter.next();
            String word = wordIndex.getWord();
            if (!wordSet.contains(word)) {
                continue;
            }

            if (nodeMap.containsKey(word)) {
                NodeDoubly toDelete = nodeMap.get(word);
                linkedList.delete(toDelete);
            }

            NodeDoubly newNode = new NodeDoubly(word, wordIndex.getIndex());
            linkedList.append(newNode);
            nodeMap.put(word, newNode);

            if (nodeMap.size() == wordSet.size()) {
                int startIndex = linkedList.head.getValue();
                int endIndex = linkedList.tail.getValue() + linkedList.tail.getKey().length() - 1;

                if (result == null || (endIndex - startIndex + 1) < result.length()) {
                    result = doc.substring(startIndex, endIndex + 1);
                }
            }
        }

        return result;

    }

    private class WordIndex {
        String word;
        int index;

        public WordIndex(String word, int index) {
            super();
            this.word = word;
            this.index = index;
        }

        public String getWord() {
            return word;
        }

        public void setWord(String word) {
            this.word = word;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }
    }
    /* * In this iterator, the position variable will always be at the start of the next * word in the string. */

    public class WordIterator implements Iterator<WordIndex> {
        String str;
        int position;

        public WordIterator(String str) {
            this.str = str;
            this.position = 0;
            // advance position to next alphabet in str
            advanceToNextAlphabet();
        }

        /*     * Advances the position variable to the next alphabet     */
        private void advanceToNextAlphabet() {
            while (position < str.length() && !Character.isAlphabetic(str.charAt(position))) {
                position++;
            }
        }

        @Override
        public boolean hasNext() {
            return position < str.length();
        }

        @Override
        public WordIndex next() {

            if (!hasNext()) {
                return null;
            }

            int wordStartIndex = position;
            // advance position to next non-alphabet
            while (position < str.length() && Character.isAlphabetic(str.charAt(position))) {
                position++;
            }

            int wordEndIndex = position - 1;
            advanceToNextAlphabet();
            return new WordIndex(str.substring(wordStartIndex, wordEndIndex + 1), wordStartIndex);
        }
    }

    public class LinkedList {

        NodeDoubly<String, Integer> head;
        NodeDoubly<String, Integer> tail;

        public LinkedList() {
            head = null;
            tail = null;
        }    /*     * This is the Append Function technique that we learned earlier.
         * In this case, we add a line - "toAdd.setPrev(tail);" - since this is a doubly     * linked list.     */

        public void append(NodeDoubly toAdd) {
            if (head == null) {
                head = toAdd;
            } else {
                tail.setNext(toAdd);
                toAdd.setPrev(tail);
            }
            tail = toAdd;
        }    /*     * Deletes a Node from a doubly linked list.     */

        public void delete(NodeDoubly toDelete) {
            if (toDelete == null) return;
            if (toDelete.getPrev() != null) toDelete.getPrev().setNext(toDelete.getNext());
            if (toDelete.getNext() != null) toDelete.getNext().setPrev(toDelete.getPrev());
            if (toDelete == tail) tail = toDelete.getPrev();
            if (toDelete == head) head = toDelete.getNext();
        }
    }

    public static void main(String[] args) {

        SmallestSubarrayCoveringAllValues smallestSub = new SmallestSubarrayCoveringAllValues();

        String doc = "one of the car and bike and one of those";

        HashSet<String> stringSet = new HashSet<>();
        stringSet.add("and");
        stringSet.add("of");
        stringSet.add("one");

        System.out.println(smallestSub.getShortestSubString(doc, stringSet));
    }

}
