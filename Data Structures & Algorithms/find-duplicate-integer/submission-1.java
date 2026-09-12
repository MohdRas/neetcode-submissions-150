class Solution {
    public int findDuplicate(int[] nums) {
    int slow = nums[0];
    int fast = nums[0];
    //System.out.println(slow + " " + fast);
    
    // Block 4: Find intersection
    do {
        slow = nums[slow];
        fast = nums[nums[fast]];
        //System.out.println("do while " + slow + " " + fast);
    } while (slow != fast);
    
    // Find cycle entrance
    slow = nums[0];
    //System.out.println("before while " + slow + " " + fast);

    while (slow != fast) {
        slow = nums[slow];
        fast = nums[fast];
        //System.out.println("while " + slow + " " + fast);

    }
    return slow;

    }
}
