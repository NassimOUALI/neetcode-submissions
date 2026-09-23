class Solution {
    public int maxArea(int[] heights) {
        int i = 0;
        int j = heights.length-1;

        int maxSize = 0;
        int currentSize;

        while(i < j){
            currentSize = Math.min(heights[i], heights[j]) * (j - i);
            if(heights[i] > heights[j]){
                j--;
            }else{
                i++;
            }
            if(currentSize > maxSize)
                maxSize = currentSize;
        }

        return maxSize;

    }
}
