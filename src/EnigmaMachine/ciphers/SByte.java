package EnigmaMachine.ciphers;

import java.util.Arrays;

/**
 * This class is meant to help the VernamCipher class with the handling of XORs and turning numbers into bytes
 * 
 * @author Mehrad Hajati
 */
public class SByte {
    
    // this array will contain zero and ones
    private int[] arr = new int[5];
    
    /**
     * Constructor to create an SByte by giving it a number
     * @param num number to be converted to 5 bits
     */
    public SByte(int num){
        for(int i = 4; i >= 0; i--){
            if((num % 2) == 1){
                arr[i] = 1;
            }
            else{
                arr[i] = 0;
            }
            num = num / 2;
        }
    }
    
    /**
     * Constructor to create an SByte by passing in an int array
     * @param in int arr
     */
    public SByte(int[] in){ arr = in; }
    
    public int[] getArray(){ return arr; }
    
    /**
     * Method to XOR two SBytes 
     * @param first the first SByte
     * @param second the Second SByte
     * @return an SByte containing the XOR result
     */
    public static SByte XOR(SByte first, SByte second){
        int[] firstArr = first.getArray();
        int[] secondArr = second.getArray();
        int[] outputArr = new int[5];
        
        for(int i = 0; i < 5; i++){
            
            if(firstArr[i] == 1){
                if(secondArr[i] == 1){
                    outputArr[i] = 0;
                }
                else{
                    outputArr[i] = 1;
                }
            }
            else{
                if(secondArr[i] == 1){
                    outputArr[i] = 1;
                }
                else{
                    outputArr[i] = 0;
                }
            }
            
        }
        
        SByte output = new SByte(outputArr);
        return output;
    }
    
    /**
     * Method to turn an SByte into an integer
     * @return the resulting integer
     */
    public int toInt(){
        int num = 0;
        for(int i = 0; i < 5 ; i++){
            if(arr[i] == 1){
                num = num + (int) Math.pow(2, (4-i));
            }
        }
        return num;
    }
    
    /*
    public static void main(String args[]){
        SByte one = new SByte(25);
        SByte two = new SByte(16);
        System.out.println(Arrays.toString(one.getArray()));
        System.out.println(Arrays.toString(two.getArray()));
        SByte result = XOR(one, two);
        System.out.println(result.toInt());
    }*/
}