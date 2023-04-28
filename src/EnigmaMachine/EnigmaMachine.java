package EnigmaMachine;

import EnigmaMachine.ciphers.AffineCipher;
import EnigmaMachine.ciphers.AtbashCipher;
import EnigmaMachine.ciphers.CaesarCipher;
import EnigmaMachine.ciphers.MatrixCipher;
import EnigmaMachine.ciphers.RailFenceCipher;
import EnigmaMachine.ciphers.VigenereCipher;

/*
 * The Enigma Machine class is supposed to be the  model in the MVC strcuture
 * The Ciphers package will process the inputs and give the outputs
 */
public class EnigmaMachine{

    ViewManager viewManager;


    public EnigmaMachine(ViewManager con){
        viewManager = con;
    }

    

    // Wrapper method for Vigenere Class
    public static String encryptVigenere(String plaintText, String key){ return VigenereCipher.encrypt(plaintText, key); }
    public static String decryptVigenere(String cipherText, String key){ return VigenereCipher.decrypt(cipherText, key); }

    // Wrapper methods for MatrixCipher class
    public static String encryptMatrix(String plaintText, String key){ return MatrixCipher.encrypt(plaintText, key); }
    public static String decryptMatrix(String cipherText, String key){ return MatrixCipher.decrypt(cipherText, key); }

    // Wrapper methods for RailFenceCipher class
    public static String encryptRailFence(String plainText, int key){ return RailFenceCipher.encrypt(plainText, key); }
    public static String decryptRailFence(String cipherText, int key){ return RailFenceCipher.decrypt(cipherText, key); }

    // Wrapper methods for AtbashCipher class
    public static String encryptAtbash(String plainText){ return AtbashCipher.encrypt(plainText); }
    public static String decryptAtbash(String cipherText){ return AtbashCipher.decrypt(cipherText); }

    // Wrapper methods for AffineCipher class, the first integer "a" has to be co prime with 26 so that decryption will work
    public static String encryptAffine(String plainText, int a, int b){ return AffineCipher.encrypt(plainText, a, b); }
    public static String decryptAffine(String cipherText, int a, int b){ return AffineCipher.decrypt(cipherText, a, b); }

    // Wrapper methods for CaesarCipher class
    public static String encryptCaesar(String plainText, int key){ return CaesarCipher.encrypt(plainText, key); }
    public static String decryptCaesar(String cipherText, int key){ return CaesarCipher.decrypt(cipherText, key); }

}