/*
  WAP to do binary search in 2D array which sorted row and column wise or can be strictly sorted.
 */

import java.util.Arrays;

public class Binary_Search_2d_Array {
    public static void main(String[] args) {
        int[][] arr={
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16}
        };
        System.out.println(Arrays.toString(search(arr,16)));
    }
    static int[]search(int[][] matrix, int target){
        int row=0;
        int column=matrix.length-1;

        while(column>=0 && row<matrix.length){
            if(matrix[row][column]==target)
                return new int[]{row, column};
            if(matrix[row][column]<target)
                row++;
            else
                column--;
        }
        return new int[]{-1, -1};
    }
}
