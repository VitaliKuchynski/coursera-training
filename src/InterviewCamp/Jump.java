package InterviewCamp;

import java.util.LinkedList;
import java.util.Queue;

public class Jump {


        // Function to check if we can reach to
        // the end of the arr[] with possible moves
        static void solve(int arr[]) {

            // Starting index
            int n = arr.length;
            int start = 1;

            // Queue to perform BFS
            Queue<Integer> q = new LinkedList<>();

            // Initially all nodes(index)
            // are not visited.
            boolean []visited = new boolean[n];

            // Initially the end of
            // the array is not reached
            boolean reached = false;

            // Push start index in queue
            q.add(start);

            // Until queue becomes empty
            while (!q.isEmpty())
            {

                // Get the top element
                int temp = q.peek();

                // Delete popped element
                q.remove();

                // If the index is already
                // visited. No need to
                // traverse it again.
                if (visited[temp] == true)
                    continue;

                // Mark temp as visited
                // if not
                visited[temp] = true;

                if (temp == n - 1)
                {

                    // If reached at the end
                    // of the array then break
                    reached = true;
                    break;
                }

                // If temp + arr[temp] and
                // temp - arr[temp] are in
                // the index of array
                if (temp + arr[temp] < n)
                {
                    q.add(temp + arr[temp]);
                }

                if (temp - arr[temp] >= 0)
                {
                    q.add(temp - arr[temp]);
                }
            }

            // If reaches the end of the array,
            // Print "Yes"
            if (reached == true)
            {
                System.out.print("Yes");
            }

            // Else print "No"
            else
            {
                System.out.print("No");
            }
        }

        // Driver Code
        public static void main(String[] args)
        {

            // Given array arr[]
            int arr[] = { 4, 1, 3, 2, 5 };

            // Function call
            solve(arr);
        }
    }



