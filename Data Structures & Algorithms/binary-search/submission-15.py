class Solution:
    def search(self, nums: List[int], target: int) -> int:
        r = len(nums)-1
        i = int(r/2)
        l = 0
        while True:
            if nums[i] == target:
                return i
            elif target > nums[i]:
                l = i
                i += int((r-i)/2)
            elif target < nums[i]:
                r = i
                i -= int((i-l)/2)
            if i == l or i == r:
                if nums[i] == target:
                    return i
                if nums[r] == target:
                    return r
                if nums[l] == target:
                    return l
                break
        return -1
        
        
        