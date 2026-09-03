class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        int rows = matrix.length; // 3
        int cols = matrix[0].length; //4

        for(int i=0; i< rows; i++){

            if(target <= matrix[i][cols-1]){

                int start = 0;
                int end = cols-1;

                while(start <= end){

                    int mid = start + ( end - start ) / 2;

                    if(target == matrix[i][mid]){
                        return true;
                    }else if(target < matrix[i][mid]){
                        end = mid - 1;
                    }else{
                        start = mid + 1;
                    }

                }

            }

        }

        return false;

    }
}
