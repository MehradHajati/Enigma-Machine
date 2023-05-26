package EnigmaMachine.ciphers;

/**
 *
 * @author Mehrad Hajati
 */
public class VernamCipher {
    
    // Constants 
    public static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz" ;
    public static final int ALPHABET_LENGTH = 26;
    public static final byte[] byteArray = {0x0, 0x1, 0x2, };
    
    
    public static String encrypt(String plainText, String key){
        
    }
    
    public static String decrypt(String cipherText, String key){
        
    }
    
    /**
     * Method to check if the length of the cipher/plain text is the same as the key
     * @param input cipher or plain text
     * @param key the key
     * @return true if the length is the same and false otherwise
     */
    public static boolean checkKey(String input, String key){
        if(input.length() == key.length()){
            return true;
        }
        return false;
    }
    
    public static int modAlphabetLength(int a){
        while(a < 0){
            a = a + ALPHABET_LENGTH;
        }
        return a % ALPHABET_LENGTH;
    }
}
