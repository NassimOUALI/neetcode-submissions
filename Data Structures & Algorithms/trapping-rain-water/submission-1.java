class Solution {
    public int trap(int[] height) {
        if (height.length == 0) return 0;

        // 1. Find the highest peak so neither direction has an "unclosed" downhill slope
        int maxIdx = 0;
        for (int k = 1; k < height.length; k++) {
            if (height[k] > height[maxIdx]) {
                maxIdx = k;
            }
        }

        int res = 0;

        // 2. Your exact logic moving left -> peak
        int i = 0;
        while (i < maxIdx && height[i] == 0) i++;
        int j = i + 1;
        int acc = 0;

        while (j <= maxIdx) {
            if (height[j] < height[i]) {
                acc += height[i] - height[j];
                j++;
            } else {
                res += acc;
                acc = 0;
                i = j;
                j = i + 1;
            }
        }

        // 3. Your exact logic moving right -> peak
        i = height.length - 1;
        while (i > maxIdx && height[i] == 0) i--;
        j = i - 1;
        acc = 0;

        while (j >= maxIdx) {
            if (height[j] < height[i]) {
                acc += height[i] - height[j];
                j--;
            } else {
                res += acc;
                acc = 0;
                i = j;
                j = i - 1;
            }
        }

        return res;
    }
}