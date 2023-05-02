package EnigmaMachine.ciphers;

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
    
    public static String encrypt(String plainText, String key){
        return null;
    }
    
    public static String decrypt(String cipherText, String key){
        return null;
    }
    
    /**
     * This method will use the Polybius Square and turn the plainText into a double int array 
     * @param msg the plaintext
     * @return The double int array has size of length of the plaintext by 2, each row is for one letter in the plaintext and the first column is for i values and the second is for j values
     */
    private static int[][] usePolybiusSquare(String msg){
        int length = msg.length();
        int[][] positions = new int[length][2];
        for(int i = 0; i < length; i++){
            char letter = msg.charAt(i);
            int[] indices = findIndices(letter);
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
                    case 0:
                        letter = "A";
                        break;
                    case 1:
                        letter = "D";
                        break;
                    case 2:
                        letter = "F";
                        break; 
                    case 3:
                        letter = "G";
                        break;
                    case 4:
                        letter = "V";
                        break;
                    case 5:
                        letter = "X";
                        break;
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
    private static int[] findIndices(char letter){
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
}
