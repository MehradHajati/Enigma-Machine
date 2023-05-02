package EnigmaMachine.ciphers;

import java.util.Arrays;

/**
 *
 * @author Mehrad Hajati
 */
public class ColumnarTranspositionCipher {


    /**
     * Method to perform a columnarTransposition
     * @param plainText the plainText
     * @param key the key for the columnar Transposition
     * @return will return the cipherText
     */
    public static String encrypt(String plainText, String key){
        String cipherText = "";
        int keyLength = key.length();
        int plainTextLength = plainText.length();
        
        //creating an array that will hold the positions before the columnar transposition
        char[][] columnarPositions = new char[(int)Math.round((double)plainTextLength/ keyLength)][keyLength];
        
        // filling the columnarPositions array with the plain text
        // using this temp variable to keep track of where we are in the plain text and using the loops the go through the double array
        int temp = 0;
        for(int i = 0; i < columnarPositions.length; i++){
            for(int j = 0; j < columnarPositions[0].length; j++){
                if(temp < plainTextLength){
                    columnarPositions[i][j] = plainText.charAt(temp);
                    temp++;
                }
                else{
                    columnarPositions[i][j] = '0';
                }
            }
        }
        
        // sorting the key alphabetically
        char[] sortedKey = sortKeyAlphabetically(key);
        // the newPositions array tells us how the columns change ordering
        int[] newPositions = getColumnOrdering(key, sortedKey);
        // iterting over the columns first and then the rows
        for(int j = 0; j < columnarPositions[0].length; j++){
            for(int i = 0; i < columnarPositions.length; i++){
                // finding the new ordering of the column
                int index = findIndex(newPositions, j);
                // checking if the cell is empty or not, the zero int gets translated to zero in char which means empty in char[]
                if(columnarPositions[i][index] != '0'){
                    cipherText = cipherText + columnarPositions[i][index];
                }
            }
        }
        return cipherText;
    }


    // Decryption Method
    public static String decrypt(String cipherText, String key){
        return null;
    }
    
    /**
     * Method to sort the key alphabetically by each letter
     * @param key the key for the cipher
     * @return a char array that has been sorted alphabetically and contains the letters of the key
     */
    private static char[] sortKeyAlphabetically(String key){
        char[] arr = key.toCharArray();
        Arrays.sort(arr);
        return arr;
    }
    
    
    /**
     * This method will use the key and the key sorted alphabetically to get the ordering for the columnar transpositions
     * @param key the key for the cipher
     * @param sortedKey the key with letter sorted alphabetically
     * @return an int array and each element tells us where its new positions or destination of that index is
     */
    private static int[] getColumnOrdering(String key, char[] sortedKey){
        int[] newPositions = new int[sortedKey.length];
        for(int i = 0; i < sortedKey.length; i++){
            char letter = key.charAt(i);
            int newPosition = findIndex(sortedKey, letter);
            newPositions[i] = newPosition;
        }
        return newPositions;
    }
    
    // Linear-search function to find the index of an element
    private static int findIndex(int arr[], int num){
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
            if (arr[i] == num){
                return i;
            }
            else{
                i = i + 1;
            }
        }
        return -1;
    }
    
    // Linear-search function to find the index of an element
    private static int findIndex(char[] arr, char letter){
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
            if (arr[i] == letter){
                return i;
            }
            else{
                i = i + 1;
            }
        }
        return -1;
    }
    
}
