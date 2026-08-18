class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];

        int product;

        for (int i=0; i<nums.length; i++){
            product = 1;
            for (int j=0; j<nums.length; j++){
                if(i == j) continue;
                else product *= nums[j];
            }
            res[i] = product;
        }

        return res;
    }
}  
