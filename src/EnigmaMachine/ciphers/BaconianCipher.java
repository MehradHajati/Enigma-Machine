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

    // Function to find the index of an element
    public static int findIndex(String[] arr, String sub){
        // doing a bianry search to find the corresponding 5 letters and return its index
        int index = Arrays.binarySearch(arr, sub);
        return (index < 0) ? -1 : index;
    }

    //Main Method
    /*public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        System.out.println("Would you like to encrypt or decrypt?");
        String answer = sc.next().toLowerCase();
        while (!(answer.equals("encrypt") || (answer.equals("decrypt")))){
            System.out.println("Please try again!");
            System.out.println("Would you like to encrypt or decrypt?");
            answer = sc.next().toLowerCase();
        }

        //Encryption part
        if(answer.equals("encrypt")){
            System.out.println("Please enter the message you would like to encrypt:");
            sc.nextLine();
            String plainText = sc.nextLine();
            System.out.println("Your CipherText is: " + encrypt(plainText));
        }

        //Decryption part
        if(answer.equals("decrypt")){
            System.out.println("Please enter the ciphertext you would like to decrypt:");
            sc.nextLine();
            String cipherText = sc.nextLine();
            System.out.println("Your plaintext is: " + decrypt(cipherText));
        }
        sc.close();
    }*/
}
