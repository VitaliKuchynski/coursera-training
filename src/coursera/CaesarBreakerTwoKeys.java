package coursera;

public class CaesarBreakerTwoKeys {
    public String halfOfString(String message, int start){
        StringBuilder buildResult = new StringBuilder();
        for(int i = start; i < message.length(); i+=2){
            char curChar = message.charAt(i);
            buildResult.append(curChar);
        }
        return buildResult.toString();
    }

    public int getKey(String s){

        BreakEncryption breakencryption = new BreakEncryption();

        int [] frequency = breakencryption.countingOccurrences(s);
        return breakencryption.maxIndex(frequency);
    }
    public String decryptTwoKeys(String encrypt){
        Encrypt cc = new  Encrypt();
        String stringFirstChar = halfOfString(encrypt,0);
        String stringSecondChar = halfOfString(encrypt,1);
        int firstKey = getKey(stringFirstChar);
        int secondKey = getKey(stringSecondChar);
        int dkey1 = firstKey-4;
        int dkey2 = secondKey-4;
        if (firstKey< 4){
            dkey1 = 26 - (4-firstKey);
        }
        if (secondKey< 4){
            dkey2 = 26 - (4-secondKey);
        }

        System.out.println(stringFirstChar  +" "+ firstKey+"   "+dkey1);
        System.out.println(stringSecondChar +" "+ secondKey+"   "+dkey2);
        return cc.encryptTwoKeys(encrypt,26 -dkey1 ,26-dkey2);
    }
    public void testHalfOfString(){
        System.out.println(halfOfString("Czojq Ivdzle",1 ));
    }

}
