class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        if (matrix == null || matrix.length == 0) return false;

        int m = matrix.length; // rows
        int n = matrix[0].length; // cols

        int start = 0;

        // 2D index to 1D index
        // last index formaula = rowNum*cols + colNum
        int end = m*n-1; 

        while( start <= end){

            int mid = start + ( end - start) / 2;

            // 1D index to 2D index
            int rowNum = mid/n; // rowNum from 1D index
            int colNum = mid%n; // colNum from 1D index

            if(matrix[rowNum][colNum] == target){
                return true;
            }else if(matrix[rowNum][colNum] < target){
                start = mid + 1;
            }else{
                end = mid -1;
            }

        }

        return false;
    }
}
