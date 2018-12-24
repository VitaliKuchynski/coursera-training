package coursera;

public class BreakEncryption {
    public int [] countingOccurrences(String message){
    String alph = "abcdefghijklmnopqrstuvwyz";
    int[] counts = new int[26];
    for(int k = 0; k< message.length(); k++){
        char ch = Character.toLowerCase(message.charAt(k));
        int dex = alph.indexOf(ch);
        if(dex !=-1){
            counts[dex]+=1;
        }        
    }
    return counts;
}

public String decrypt(String encrypted){
    Encrypt cc = new Encrypt();
    int [] fregs = countingOccurrences(encrypted);
    int maxDex = maxIndex(fregs);
    int dkey = maxDex-4;
    if (maxDex< 4){
        dkey = 26 - (4-maxDex);
    }
    return cc.encryptW(encrypted,26-dkey);
}

public int maxIndex(int [] vals){
     int maxDex = 0;
     for (int k =0 ; k< vals.length; k++){
        if (vals[k]>vals[maxDex]){
            maxDex =k;
        }
    }
    return maxDex;
    }
    
public void testDecrypt(){
    decrypt("WIVV TRBV ZE KYV TFEWVIVETV IFFD!");
 }
}
