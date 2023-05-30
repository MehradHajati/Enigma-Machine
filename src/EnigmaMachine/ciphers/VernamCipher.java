package EnigmaMachine.ciphers;

import static EnigmaMachine.ciphers.SByte.XOR;

/**
 *
 * @author Mehrad Hajati
 */
public class VernamCipher {
    
    // Constants 
    public static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz" ;
    public static final int ALPHABET_LENGTH = 26;
    
    
    public static String encrypt(String plainText, String key){
        String cipherText = "";
        int length = plainText.length();
        SByte[] convertedPT = convertToSByteArr(plainText);
        SByte[] convertedKey = convertToSByteArr(key);
        for(int i = 0; i < length; i++){
            // doing the XOR
            SByte one = XOR(convertedPT[i], convertedKey[i]);
            // getting the int from the SByte and then modding it by 26
            int num = modAlphabetLength(one.toInt());
            // adding it to the cipherText
            cipherText = cipherText + ALPHABET.charAt(num);
        }
        return cipherText.toUpperCase();
    }
    
    public static String decrypt(String cipherText, String key){
        String plainText = "";
        int length = cipherText.length();
        SByte[] convertedCT = convertToSByteArr(cipherText);
        SByte[] convertedKey = convertToSByteArr(key);
        for(int i = 0; i < length; i++){
            // doing the XOR
            SByte one = XOR(convertedCT[i], convertedKey[i]);
            // getting the int from the SByte and then modding it by 26
            int num = modAlphabetLength(one.toInt());
            // adding it to the cipherText
            plainText = plainText + ALPHABET.charAt(num);
        }
        return plainText.toUpperCase();
    }
    
    
    
    public static int modAlphabetLength(int a){
        while(a < 0){
            a = a + ALPHABET_LENGTH;
        }
        return a % ALPHABET_LENGTH;
    }
    
    /**
     * This Method will take a string and turn each character into integers according to the ordering of the alphabet, then turn them into an SByte array
     * @param text string to be converted into an SByte array
     * @return output an SByte array which contains the text
     */
    private static SByte[] convertToSByteArr(String text){
        int length = text.length();
        SByte[] output = new SByte[length];
        for(int i = 0; i < length; i++){
            // getting the letter from the string
            char letter = text.charAt(i);
            // converting it into a number
            int num = ALPHABET.indexOf(letter);
            // creating the corresponding SByte
            SByte one = new SByte(num);
            output[i] = one;
        }
        return output;
    }
    
}
