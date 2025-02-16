package InterviewCamp.arrays;

import java.util.*;

//Level: EasyGiven an array of integers,
// find a pair of integers that sums to a number Target.

public class ToSumHashSet {

    public static void main(String[] args) {

        int[] origArray = {0, 1, 2, 70, 11, 15, 7};

        System.out.println(Arrays.toString(twoSumBrutForce(origArray, 9)));

        System.out.println(Arrays.toString(twoSumUsingHashSet(origArray, 9)));

    }


    public static int[] twoSumBrutForce(int [] numbers, int target) {
        int[] returnPair = new int[2];

        if (numbers.length == 0){
            return null;
        }

        for (int i = 0; i <= numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if(numbers[i] + numbers[j] == target) {
                    returnPair[0] = numbers[i];
                    returnPair[1] = numbers[j];
                    return returnPair;
                }
            }
        }
        return null;
    }

    public static int[] twoSumUsingHashSet(int [] numbers, int target) {
        int [] returnPair = new int[2];
       Set<Integer> numberSet = new HashSet<>();

        if (numbers.length == 0 || numbers == null){
            return null;
        }

        for (int i = 0; i < numbers.length; i++) {
            if(numberSet.contains(target - numbers[i])){
                returnPair[0] = numbers[i];
                returnPair[1] = numbers[target - numbers[i]];
                return returnPair;
            } else {
                numberSet.add(numbers[i]);
            }
        }

        return null;
    }

    public List<int[]> findAllPairs(int [] arr, int target) {

        Deque<Integer> numberStack = new LinkedList<>();
        List<int[]> result = new ArrayList<>();

        for (int current: arr) {

            int con = target - current;

            if (numberStack.contains(con)) {
                result.add(new int[] {con, current});
            } else {
                numberStack.add(current);
            }

        }
        return result;
    }
}
