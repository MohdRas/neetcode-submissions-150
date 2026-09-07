class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        int m = matrix.length; // rows
        int n = matrix[0].length; // cols

        int start = 0;
        int end = m*n-1;

        while( start <= end){

            int mid = start + ( end - start) / 2;

            int rowNum = mid/n;
            int colNum = mid%n;

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
