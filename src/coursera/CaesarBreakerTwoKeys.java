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

    public void getKey(String s){
        BreakEncryption breakencryption = new BreakEncryption();
        breakencryption.countingOccurrences(s);

    }
    public void testHalfOfString(){
        System.out.println(halfOfString("Qbkm Zgis",1 ));
    }

}
