package coursera;

public class Encrypt {
    public static void main(String[] arg){

        Encrypt encrypt = new Encrypt();
        //encrypt.encryptW("First Legion", 17);
        encrypt.encryptTwo("First Legion",23,17);
        //encrypt.firstLetterUpperCae("united states of america");

    }

    //Encrypts message with one shift key
    public String encryptW(String input, int key){
        //Gets input
        StringBuilder encrypted = new StringBuilder(input);
        //Creates string alphabet
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        //Concatenates to new alphabet
        String shiftedAlphabet = alphabet.substring(key) + alphabet.substring(0,key);
        boolean isCharLower;
        //Iterates through user input
        for(int i = 0; i < encrypted.length(); i++){
            //Gets char by index
            char curChar = encrypted.charAt(i);
            isCharLower = Character.isLowerCase(curChar);
            //Looks for char in the alphabet if there is no char return -1
            int indx = alphabet.indexOf(Character.toUpperCase(curChar));
        //If there is char in the alphabet adds to encrypted string
            if(indx!=-1){
                if(isCharLower){
                    // gets new char
                    char newChar = Character.toLowerCase(shiftedAlphabet.charAt(indx));//shiftedAlphabet.charAt(indx);
                    //replaces old char to new one
                    encrypted.setCharAt(i,newChar);
                }else  {
                    char newChar = shiftedAlphabet.charAt(indx);//shiftedAlphabet.charAt(indx);
                    //replaces old char to new one
                    encrypted.setCharAt(i,newChar);
                }
            }

        }

        System.out.println(encrypted.toString());
        return encrypted.toString();
    }
    //Encrypts message with 2 shift keys
    public String encryptTwo(String input1, int key1 ,int key2){

        //Gets input
        StringBuilder encrypted = new StringBuilder(input1);
        // Creates string alphabet
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        //Concatenates to new alphabet
        String shiftedAlphabet1 = alphabet.substring(key1) + alphabet.substring(0,key1);
        //Concatenates to new alphabet
        String shiftedAlphabet2 = alphabet.substring(key2) + alphabet.substring(0,key2);

        boolean isCharLower;
        //Iterates through user input
        for(int i = 0; i < encrypted.length(); i++){
            //Gets char by index
            char curChar = encrypted.charAt(i);
            isCharLower = Character.isLowerCase(curChar);
            //Looks for char in the alphabet if there is no char return -1
            int indx = alphabet.indexOf(Character.toUpperCase(curChar));
            int cout = i+1;
            //If there is char in the alphabet adds to encrypted string
            if(indx!=-1){
                if (isCharLower && cout%2==1 ){
                // gets new char
                char newChar = Character.toLowerCase(shiftedAlphabet1.charAt(indx));
                //replaces old char to new one
                encrypted.setCharAt(i,newChar);
            }else if(!isCharLower && cout%2==1) {
                char newChar = shiftedAlphabet1.charAt(indx);
                //replaces old char to new one
                encrypted.setCharAt(i,newChar);
            }else if(isCharLower && cout%2==0){
                // gets new char
                char newChar = Character.toLowerCase(shiftedAlphabet2.charAt(indx));
                //replaces old char to new one
                encrypted.setCharAt(i,newChar);
            }else if(!isCharLower &&cout%2==0) {
                char newChar = shiftedAlphabet2.charAt(indx);
                //replaces old char to new one
                encrypted.setCharAt(i,newChar);
            }
        }
        }

        System.out.println(encrypted.toString());
        return encrypted.toString();
    }

    public void firstLetterUpperCae(String input){
        StringBuilder str = new StringBuilder(input);

        for (int i = 0; i < str.length(); i++){
            char oldChar = str.charAt(i);

            if ( Character.isSpaceChar(oldChar)){
                char newChar = str.charAt(i+1);

                System.out.println(input.indexOf(newChar));

                str.setCharAt(i+1, Character.toUpperCase(newChar));
            }

        }

        System.out.println(str.toString());


    }

public void testCaesar(){


}
}
