package coursera;


import java.io.BufferedReader;
import java.io.FileReader;

public class BufferRider {

    public static void main(String[] args) throws Exception {

        String thisLine = null;

        try {
            // open input stream test.txt for reading purpose.
            BufferedReader br = new BufferedReader(new FileReader("/Users/vitalikuchynski/IdeaProjects/git-team/test.txt"));

            while ((thisLine = br.readLine()) != null) {
                System.out.println(thisLine);
            }

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
