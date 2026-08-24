class Solution {
    public int[] productExceptSelf(int[] nums) {

        int n = nums.length;

        int left_product=1;
        int[] ans = new int[n];

        

        for(int i=0; i<n; i++){
            ans[i] = left_product;
            left_product = left_product*nums[i];
        }

        int right_product=1;

        for(int i=n-1; i>=0; i--){
            ans[i] = ans[i]*right_product;
            right_product = right_product*nums[i];
        }

        return ans;
    }
}  
