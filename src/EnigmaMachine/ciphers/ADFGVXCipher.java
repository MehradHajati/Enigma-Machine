package EnigmaMachine.ciphers;

import java.util.Arrays;

/**
 *
 * @author Mehrad Hajati
 */
public class ADFGVXCipher {
    
    private static final char[][] POLYBIUS_SQUARE = { {'a', 'b', 'c', 'd', 'e', 'f'}, 
                                                    {'g', 'h', 'i', 'j', 'k', 'l'},
                                                    {'m', 'n', 'o', 'p', 'q', 'r'},
                                                    {'s', 't', 'u', 'v', 'w', 'x'},
                                                    {'y', 'z', '0', '1', '2', '3'},
                                                    {'4', '5', '6', '7', '8', '9'} };
    private static final int SQUARE_SIZE = 6;
    
    /**
     * Method to encrypt using the ADFGVX cipher
     * @param plainText the plainText
     * @param key the Key
     * @return the cipherText
     */
    public static String encrypt(String plainText, String key){
        // getting the index position on the Polybius square
        int[][] polySquare = usePolybiusSquare(plainText);
        // converting the index position to the ADFGVX alphebet
        String interCT = switchAlphabet(polySquare);
        // performing a columnarTranspotion on them
        String interCT2 = columnarTransposition(interCT, key);
        // using the Polybius Square again to turn them back into the english alphabet and returning it
        return switchBackAlphabet(interCT2);
    }
    
    /**
     * Method to decrypt using the ADFGVX cipher
     * @param cipherText the cipherText
     * @param key the key
     * @return the plainText
     */
    public static String decrypt(String cipherText, String key){
        // getting the index position on the Polybius square
        //int[][] polySquare = usePolybiusSquare(cipherText);
        // converting the index position to the ADFGVX alphebet
        //String interCT = switchAlphabet(polySquare);
        // reversing the columnarTransposition on them
        //String interCT2 = reverseColumnarTransposition(interCT, key);
        // using the Polybius Square again to turn them back into the english alphabet and returning it
        //return switchBackAlphabet(interCT2);
        return null;
    }
    
    /**
     * This method will use the Polybius Square and turn the plainText into a double int array 
     * @param msg the plainText
     * @return The double int array has size of length of the plainText by 2, each row is for one letter in the plainText and the first column is for i values and the second is for j values
     */
    private static int[][] usePolybiusSquare(String msg){
        int length = msg.length();
        int[][] positions = new int[length][2];
        for(int i = 0; i < length; i++){
            char letter = msg.charAt(i);
            int[] indices = findIndicesInPolySq(letter);
            positions[i][0] = indices[0];
            positions[i][1] = indices[1];
        }
        return positions;
    }
    
    /**
     * This method take the indices array and turn them into the ADFGVX alphabet, with A=0, D=1, F=2, G=3, V=4, X=5
     * @param doubleArr the double int array with the indices information
     * @return the intermediary cipher text which uses the Polybius square and then turns the index values into ADFGVX
     */
    private static String switchAlphabet(int[][] doubleArr){
        String intermediaryCipherText = "";
        int length = doubleArr.length;
        for(int i = 0; i < length; i++){
            for(int j = 0; j < 2; j++){
                int num = doubleArr[i][j];
                String letter = null;
                switch(num){
                    case 0 -> letter = "A";
                    case 1 -> letter = "D";
                    case 2 -> letter = "F";
                    case 3 -> letter = "G";
                    case 4 -> letter = "V";
                    case 5 -> letter = "X";
                }
                intermediaryCipherText = intermediaryCipherText + letter;
            }
        }
        return intermediaryCipherText;
    }
    
    /**
     * This method will take in one letter as a char and find the row and column index in the POLYBIUS_SQUARE and return them as an array
     * @param letter The letter in question as a char
     * @return an int array in which the first index is the i and the second is the j of the letter in the POLYBIUS_SQUARE
     */
    private static int[] findIndicesInPolySq(char letter){
        for(int i = 0; i < SQUARE_SIZE; i++){
            for(int j = 0; j < SQUARE_SIZE; j++){
                if(letter == POLYBIUS_SQUARE[i][j]){
                    int[] indices = {i, j};
                    return indices;
                }
            }
        }
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
     * Method to perform a columnarTransposition
     * @param intermediaryCT The intermediary cipher text after using Polybius square and switching alphabets
     * @param key the key for the columnar Transposition
     * @return will return the cipherText in ADFGVX alphabet
     */
    private static String columnarTransposition(String intermediaryCT, String key){
        String cipherText = "";
        int keyLength = key.length();
        int interCTLength = intermediaryCT.length();
        //creating an array that will hold the positions before the columnar transposition
        char[][] columnarPositions = new char[(int)Math.round((double)interCTLength/ keyLength)][keyLength];
        
        // filling the columnarPositions array with the intermediary cipher text
        // using this temp variable to keep track of where we are in the intermediary cipher text and using the loops the go through the double array
        int temp = 0;
        for(int i = 0; i < columnarPositions.length; i++){
            for(int j = 0; j < columnarPositions[0].length; j++){
                if(temp < interCTLength){
                    columnarPositions[i][j] = intermediaryCT.charAt(temp);
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
    
    /**
     * Method to convert the ADFGVX alphabet back into the english alphabet using the Polybius square
     * @param msg a message in the ADFGVX alphabet
     * @return a message in the english alphabet using the Polybius square
     */
    private static String switchBackAlphabet(String msg){
        String text = "";
        int length = msg.length();
        // converting every ADFGVX back to english alphabet character using the Polybius Square
        for(int i = 0; i < length; i=i+2){
            char charRow = msg.charAt(i);
            char charCol = msg.charAt(i+1);
            int row = 0;
            int col = 0;
            switch(charRow){
                case 'A' -> row = 0;
                case 'D' -> row = 1;
                case 'F' -> row = 2;
                case 'G' -> row = 3;
                case 'V' -> row = 4;
                case 'X' -> row = 5;
            }
            switch(charCol){
                case 'A' -> col = 0;
                case 'D' -> col = 1;
                case 'F' -> col = 2;
                case 'G' -> col = 3;
                case 'V' -> col = 4;
                case 'X' -> col = 5;
            }
            text = text + POLYBIUS_SQUARE[row][col];
        }
        return text;
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
}
