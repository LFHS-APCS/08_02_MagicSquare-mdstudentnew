
/**
 * @author - Mr. Bredemeier/Mr. Aronson
 * @version - August 14, 2013/Feb. 24, 2021
 */
import org.junit.*;

public class MagicSquareTest extends junit.framework.TestCase {
    private static MagicSquare square;
    private static boolean failed = false;
    private static String msg = "Magic Square test #";
    private static int count = 1;

    /**
     * Constructs a MagicSquare object and uses it to determine if a 4 x 4 array is a magic square.
     */
    public static void main(String[] args)
    {
        MagicSquareTest test = new MagicSquareTest();
        test.test();
    }

    @Test
    public  void test() {
        System.out.println("Now testing your MagicSquare class:\n");
        // magic square
        int[][] array1 = {{16, 3, 2, 13},{5, 10, 11, 8},{9, 6, 7, 12},{4, 15, 14, 1}}; 
        testSquare(array1, true);

        // magic square
        int[][] array2 = {{1, 15, 14, 4},{12, 6, 7, 9},{8, 10, 11, 5},{13, 3, 2, 16}}; 
        testSquare(array2, true);

        // not a magic square
        int[][] array3 = {{1, 2, 3, 4},{5, 6, 7, 8},{9, 10, 11, 12},{13, 14, 15, 16}}; 
        testSquare(array3, false);

        // not a magic square
        int[][] array4 = {{15, 1, 12, 13},{9, 7, 2, 3},{4, 5, 6, 7},{8, 10, 11, 13}};
        testSquare(array4, false);

        // magic square
        int[][] array5 = {{4, 14, 15, 1},{9, 7, 6, 12},{5, 11, 10, 8},{16, 2, 3, 13}};
        testSquare(array5, true);

        // magic square
        int[][] array6 = {{16, 3, 2, 13},{5, 10, 11, 8},{9, 6, 7, 12},{4, 15, 14, 1}};
        testSquare(array6, true);

        // not a magic square
        int[][] array7 = {{0, 1, 0, 1},{1, 0, 1, 0},{0, 1, 0, 1},{1, 0, 1, 0}};
        testSquare(array7, false);

        // not a magic square
        int[][] array8 = {{0, 14, 13, 3},{11, 5, 6, 8},{4, 9, 10, 7},{12, 2, 1, 15}};
        testSquare(array8, false);

        // magic square
        int[][] array9 = {{3, 13, 14, 0},{8, 6, 5, 11},{4, 10, 9, 7},{15, 1, 2, 12}};
        testSquare(array9, true);

        // not a magic square
        int[][] array10 = {{3, 13, 14, 0},{8, 6, 5, 11},{4, 9, 10, 7},{15, 1, 2, 12}};
        testSquare(array10, false);

        // magic square
        int[][] array11 = {{1, 15, 14, 4},{12, 6, 7, 9},{8, 10, 11, 5},{13, 3, 2, 16}};
        testSquare(array11, true);

        // not a magic square
        int[][] array12 = {{15, 1, 12, 13},{9, 7, 2, 3},{4, 5, 6, 7},{8, 10, 11, 13}};
        testSquare(array12, false);

        // is a magic square
        int[][] array13 = {{1, 1, 1},{1, 1, 1},{1, 1, 1}};
        testSquare(array13, true);
        
        // not a magic square
        System.out.println("Testing a ragged 2D array i.e. it is not a square");
        int[][] array14 = {{0},{0, 0}};
        testSquare(array14, false);

        if (failed)
            System.out.println("\nBummer, try again");
        if (!failed)
            System.out.println("\nCongratulations, your MagicSquare class test was successful");
    }

    private static void failure(String str)
    {
        System.out.println(str);
        failed = true;
        fail(str);
    }

    private static void testSquare(int [][] array, boolean test)
    {
        if(!failed)
        {

            square = new MagicSquare(array);
            if(square.isMagicSquare() == test)
                System.out.println("Passed " + msg + count);
            else
            {
                failure("\n** Failed " + msg + count);
                System.out.println(square);
                System.out.print("The above matrix is ");
                if(!test)
                    System.out.print("not ");
                System.out.println("a magic square");
            }
            count++;
        }
    }
}
