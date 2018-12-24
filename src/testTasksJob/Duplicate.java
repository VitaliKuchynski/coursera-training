package testTasksJob;


public class Duplicate {


        //Find the most popular element in int[] array

        public static void main(String[] args) {


            String s = "8 8 2 4 8";
            String[] numberStr  = s.split(" ");

            int[] numbers = new int[numberStr.length];

            for(int i=0; i<numberStr.length; i++){
                numbers[i] = Integer.parseInt(numberStr[i]);
                System.out.println(numbers[i]);
            }

            System.out.println("Majority value: "+getPopularElement(numbers));


        }

        public static int getPopularElement(int[] a)
        {
            int count = 1, tempCount;
            int popular = a[0];
            int temp = 0;
            for (int i = 0; i < (a.length - 1); i++)
            {
                temp = a[i];
                tempCount = 0;
                for (int j = 1; j < a.length; j++)
                {
                    if (temp == a[j])
                        tempCount++;
                }
                if (tempCount > count)
                {
                    popular = temp;
                    count = tempCount;
                }
            }
            return popular;
        }


    }

