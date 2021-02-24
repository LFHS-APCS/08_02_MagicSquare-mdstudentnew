
/**
 * @author 
 * @version 
 */

public class MagicSquare
{
    /** The magic square array data */
    private int[][] array;

    /**
     * Constructs a MagicSquare object.
     * @param input the magic square array data.
     */
    public MagicSquare(int[][] input)
    {
        array = input;
    }

    /**
     * Tests to see if array is indeed a magic square
     * @return true if array is a magic square
     * @return false if the array is not a magic square
     */
    public boolean isMagicSquare()
    {
      int magicConstant = addRow(0);
        if(array.length == 0 || array.length != array[0].length)
            return false;
        
            for(int i = 1; i < array.length; i++){
                int r = addRow(i);
                if(r != magicConstant)
                    return false;
            }
            
            for(int i = 0; i<array.length; i++){
                int c = addCol(i);
                if(c != magicConstant)
                    return false;
            }
            
            if(magicConstant != addDiagonalTopLeft() || magicConstant != addDiagonalBottomLeft() || addDiagonalTopLeft() != addDiagonalBottomLeft())
                return false;
            
            return true;
    }


     public int addRow(int row){
        int sum1 = 0;
        for(int i=0; i<array[0].length;i++){
            sum1 += array[row][i];
        }
        return sum1;
    }
    
      public int addCol(int col){
        int sum2 = 0;
        for(int i=0; i<array.length;i++){
            sum2 += array[i][col];
        }
        return sum2;
    }
    
    public int addDiagonalTopLeft(){
        int sum3 = 0;
        for(int i = 0; i<array.length; i++){
             sum3 += array[i][i];
        }
        return sum3;
    }
    
    public int addDiagonalBottomLeft(){
        int sum4 = 0;
        for(int i = 0; i< array.length; i++){
            int j = array.length - 1 - i;
            sum4 += array[i][j];
        }
        return sum4;
        
    }


    /**
     * Returns a String which represents the array.
     */
    public String toString()
    {
        String result = "";
        for(int r = 0; r < array.length; r++)
        {
            for(int c = 0; c <array[r].length; c++)
            {
                result += array[r][c];
                result += "\t";
            }
            result += "\n";
        }
        return result;
    }
}
