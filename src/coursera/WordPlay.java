package coursera;


public class WordPlay {

    public static void main(String[] args) {
        WordPlay wordPlay= new WordPlay();

        //wordPlay.isVowel('o');
      // wordPlay.replaceVowels("Hello World I am here",'#');
        wordPlay.emphasize("Mary Bella Abracadabra", 'a');
        //wordPlay.returnString("hij");

    }

    public boolean isVowel(char ch) {
        boolean result = false;
        String vowels = "aeiouAEIOU" ;
        for(int i = 0; i< vowels.length(); i++){
            char cha = vowels.charAt(i);
            if(ch==cha){
                result = true;
            }
        }
        System.out.println(result);
        return result;
    }


    public String replaceVowels(String input, char c){

        StringBuilder str = new StringBuilder(input);
        String vowels = "aeiouAEIOU";

        for(int i = 0; i < str.length(); i++){
            char cha = str.charAt(i);
            int indx = vowels.indexOf(cha);
            if(indx !=-1){
            str.setCharAt(i,c);
            }
        }
        System.out.println( str.toString());
        return str.toString();

    }

    public String emphasize(String phrase, char ch){
        char star = '*';
        char plus = '+';

        StringBuilder str = new StringBuilder(phrase);

        for (int i = 0; i< str.length(); i++) {
            char chaChar = str.charAt(i);
            int idx = phrase.indexOf(ch,i);

            if(chaChar==ch && idx%2==0){
                str.setCharAt(i,star);
            }else if (chaChar==ch && idx%2==1){
                str.setCharAt(i,plus);
            }
        }

        System.out.println(str.toString());
     return str.toString();
    }


//
    public  String returnString(String s){
        String newString = "";
        for(int i=1; i<s.length()-1; i++){
            newString = newString + s.charAt(i);
        }
        System.out.println(newString);
        return newString;
    }
}
