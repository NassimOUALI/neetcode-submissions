class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();

        Arrays.sort(nums);

        for(int i = 0; i < nums.length-2; i++){
            for( int j = i+1; j < nums.length-1; j++){
                for(int k = j+1; k < nums.length; k++){
                    if(nums[k] + nums[j] == -nums[i]){
                        List<Integer> tmp = Arrays.asList(nums[i], nums[j], nums[k]);
                        res.add(tmp);
                        break;
                    }
                }   
            }
        }

        return new ArrayList<>(res);
    }
}
