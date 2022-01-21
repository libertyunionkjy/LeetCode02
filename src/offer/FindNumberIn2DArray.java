package offer;

public class FindNumberIn2DArray {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if(matrix.length <= 0)
            return false;
        int i = 0, j = matrix[0].length - 1;
        while(i < matrix.length && j >= 0){
            if (matrix[i][j] == target){
                return true;
            }
            else if(matrix[i][j] > target){
                j--;
            }
            else if(matrix[i][j] < target){
                i++;
            }
        }
        return false;
    }
}
