class Solution:
    def hasDuplicate(self, nums: List[int]) -> bool:
        exists = set()
        for x in nums:
            if x in exists:
                return True
            else:
                exists.add(x)
        return False
        