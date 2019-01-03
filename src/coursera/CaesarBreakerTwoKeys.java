package coursera;

/**
 * Created by vitalikuchynski on 1/2/19.
 */
public class CaesarBreakerTwoKeys
{
    public String halfOfString(String message, int start){
        String result = null;
        StringBuilder buildResult = new StringBuilder();
        for(int i = start; i < message.length(); i+=2){
            char curChar = message.charAt(i);
            buildResult.append(curChar);
        }
        return buildResult.toString();
    }

    public int getKey(String s){
        int key=0;
        BreakEncryption breakencryption = new BreakEncryption();
        int [] letterFre = breakencryption.countingOccurrences(s);
        key = breakencryption.maxIndex(letterFre);
        return key;
    }
    public void testHalfOfString(){
        System.out.println(halfOfString("Qbkm Zgis",1 ));
    }

}
