package InterviewCamp;


    // Java program to find highest power of
// 2 smaller than or equal to n.
public class GFG{

        static int highestPowerof2(int n)
        {
            int res = 0;
            for(int i = n; i >= 1; i--) {

                // If i is a power of 2
                if ((i & (i-1)) == 0)
                {
                    res = i;
                    break;
                }
            }
            return res;
        }

        // Driver code
        public static void main(String[] args)
        {
            int n = 11;

            System.out.print(highestPowerof2(n));
        }
    }
