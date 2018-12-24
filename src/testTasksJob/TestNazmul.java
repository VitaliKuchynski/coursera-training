package testTasksJob;
import java.io.*;
import java.util.ArrayList;

public class TestNazmul {


        public static void main (String[] args) throws java.lang.Exception {
            ArrayList arrayList = new ArrayList<>();
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String input = br.readLine();
            int x = 0;
            while (br.readLine()!=null){
                x = Integer.parseInt(input);
                arrayList.add(x);
            }
            for(int i = 0; i <= arrayList.size(); i++)
                if(arrayList.equals(x)){
                    System.out.println(x);

                }

            System.out.println(input);
        }
    }

