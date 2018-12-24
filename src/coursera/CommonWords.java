package coursera;


import java.io.*;
import java.util.Scanner;


public class CommonWords {

    public  String[] getCommon() throws IOException {

        Scanner file = new Scanner(new FileReader("/Users/vitalikuchynski/Downloads/common.txt"));

        String [] common = new String[4];
        int indx = 0;
        while (file.hasNextLine()){
            common [indx] = file.nextLine();
            indx += 1;

        }
            file.close();
        return common;
    }

    public int indexOfW(String[] common1, String word){

        return 1;

    }

    public void countWords(Scanner file, String [] common, int [] counts){

        while (file.hasNextLine()){
            String words = file.nextLine().toLowerCase();

            int inx = indexOfW(common,words);
            if(!(inx == -1)){
                counts[inx] +=1;
            }
        }

    }

    public void countText() throws IOException {

        String [] plays = {"fileTest.txt"};
        String [] common = getCommon();
        int[] counts = new int[common.length];


        for (int k = 0; k < plays.length; k++){

           Scanner resources = new Scanner(new FileReader("/Users/vitalikuchynski/Downloads/" + plays[k]));

           countWords(resources, common, counts);

           System.out.println("Done with " + plays[k]);
            resources.close();
        }

        for (int k = 0; k < common.length; k++ ) {
            System.out.println(common[k] + "\t" +  counts[k]);
        }


    }


    public static void main(String [] arg) throws IOException {
        CommonWords commonWords = new CommonWords();
        commonWords.countText();

    }
}
