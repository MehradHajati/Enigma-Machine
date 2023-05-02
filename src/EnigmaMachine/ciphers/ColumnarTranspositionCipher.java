package EnigmaMachine.ciphers;

/**
 *
 * @author Mehrad Hajati
 */
public class ColumnarTranspositionCipher {
    // Constants
    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    private static final int ALPHABET_LENGTH = 26;


    // Method to generate key
    public static String generateKey(String plainText, String key){
        int length = plainText.length();
        int keyLength = key.length();
        if(length <= keyLength){
            return key;
        }
        else{
            for(int i = 0; keyLength < length; i++){
                System.out.println(key);
                key += key.charAt(i % keyLength);
                keyLength++;
            }
            return key;
        }
    }

    public static int[] findPosition(String input){
        int length = input.length();
        int[] array = new int[length]; 
        for(int i = 0; i < length; i++){
            char letter = input.charAt(i);
            for(int j = 0; j < ALPHABET_LENGTH; j++){
                if(letter == ALPHABET.charAt(j)){
                    array[i] = j;
                    break;
                }
            }
        }
        return array;
    }

    // Encryption Method
    public static String encrypt(String plainText, String key){
    }


    // Decryption Method
    public static String decrypt(String cipherText, String key){
    }

    
}
