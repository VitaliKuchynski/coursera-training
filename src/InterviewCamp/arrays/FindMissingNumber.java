package InterviewCamp.arrays;

import java.util.Arrays;

public class FindMissingNumber {


    public int findMissing() {

    int [] ar = {1,2,3,4,6,7,8,9};

    int numberCount = 9;

    int s1 = (numberCount * (numberCount + 1) / 2);

    int s2 = Arrays.stream(ar).sum();

        return s1 - s2;
    }

    public int findMissingXOR() {
        int [] ar = {1,2,3,4,6,7,8,9};
        int numberCount = 9;
        int xorFull = 0;
        int xorArray = 0;

        for (int i = 1; i <= numberCount; i++) {
            xorFull ^= i;
        }

        for (int n: ar) {
            xorArray ^= n;
        }

        return xorFull ^ xorArray;
    }

}
