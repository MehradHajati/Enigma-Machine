package EnigmaMachine.ciphers;

import java.util.Arrays;
/**
 *
 * @author Mehrad Hajati
 */
public class BaconianCipher {
    
    // Constants
    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    //This string will show what each letter in the alphabet will be coded to:
    //                                         A        B       C       D       E       F       G           H          I        J       K       L
    private static final String[] BACON = {"aaaaa", "aaaab", "aaaba", "aaabb", "aabaa", "aabab", "aabba", "aabbb", "abaaa", "abaab", "ababa", "ababb",
    //                                      M           N       O       P       Q        R          S       T       U           V       W       X   
                                           "abbaa", "abbab", "abbba", "abbbb", "baaaa", "baaab", "baaba", "baabb", "babaa", "babab", "babba", "babbb", 
    //                                      Y           Z                                       
                                           "bbaaa", "bbaab"};


    //Encryption Method
    public static String encrypt(String plainText){
        plainText = plainText.toLowerCase();
        String cipherText = "";
        int length = plainText.length();
        for(int i = 0; i < length; i++){
            char letter = plainText.charAt(i);
            int position = ALPHABET.indexOf(letter);
            cipherText = cipherText + BACON[position];
        }
        return cipherText.toUpperCase();
    }


    //Decryption Method
    public static String decrypt(String cipherText){
        cipherText = cipherText.toLowerCase();
        String plainText = "";
        int length = cipherText.length();
        // jumping up 5 at a time since each 5 characters decrypt to one letter
        for(int i = 0; i < length; i=i+5){
            String substring = cipherText.substring(i, i+5);
            int position = findIndex(BACON, substring);
            plainText = plainText + ALPHABET.charAt(position);
        }
        return plainText.toUpperCase();
    }
    
    // Linear-search function to find the index of an element
    private static int findIndex(String[] arr, String sub){
        // if array is Null
        if (arr == null) {
            return -1;
        }
        // find length of array
        int len = arr.length;
        int i = 0;
        // traverse in the array
        while (i < len) {
            // if the i-th element is t
            // then return the index
            if (arr[i].equals(sub)){
                return i;
            }
            else{
                i = i + 1;
            }
        }
        return -1;
    }
}
