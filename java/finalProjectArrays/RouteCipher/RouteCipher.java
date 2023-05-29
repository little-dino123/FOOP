package finalProjectArrays.RouteCipher;

import java.util.Arrays;

public class RouteCipher
{
    /** A two-dimensional array of single-character strings, instantiated in the constructor */
    public String[][] letterBlock;

    /** The number of rows of letterBlock, set by the constructor */
    private final int numRows;

    /** The number of columns of letterBlock, set by the constructor */
    private final int numCols;

    public RouteCipher(int r, int c){
        letterBlock = new String[r][c];
        numRows = r;
        numCols = c;
    }

    /** Places a string into letterBlock in row-major order.
     *   @param str the string to be processed
     *   Postcondition:
     *     if str.length() < numRows * numCols, "A" in each unfilled cell
     *     if str.length() > numRows * numCols, trailing characters are ignored
     */
    public void fillBlock(String str) {
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                int idx = i*numCols+j;
                letterBlock[i][j]=idx<str.length()?str.substring(idx,idx+1):"A";
            }
        }
    }

    /** Extracts encrypted string from letterBlock in column-major order.
     *   Precondition: letterBlock has been filled
     *   @return the encrypted string from letterBlock
     */
    private String encryptBlock() {
        StringBuilder strbldr= new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                strbldr.append(letterBlock[j][i]);
            }
        }
        return strbldr.toString();
    }

    /** Encrypts a message.
     *   @param message the string to be encrypted
     *   @return the encrypted message;
     *           if message is the empty string, returns the empty string
     */
    public String encryptMessage(String message) {
        fillBlock(message);
        return encryptBlock();
    }

    public static void main(String[] args)
    {
        boolean test1 = false;
        RouteCipher ciph = new RouteCipher(8,8);

        ciph.fillBlock("the fitnessgram pacer test is a multistage aerobic capacity test");
        for (int i = 0; i < ciph.numRows; i++) {
            System.out.println(Arrays.toString(ciph.letterBlock[i]));
        }
        System.out.println(ciph.encryptBlock());

        if ((ciph.letterBlock[0][2]).equals("e") && (ciph.letterBlock[2][1]).equals(" "))
            test1 = true;
        else
            System.out.println("Oops! Looks like your code doesn't properly insert the given String.\n");

        if (test1)
            System.out.println("Looks like your code works well!");
        else
            System.out.println("Make a few changes, please.");

    }
}
