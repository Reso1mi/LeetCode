class Solution:
    def search(self, nums: List[int], target: int) -> bool:
        left, right = 0, len(nums)-1
        res = 0
        # 尾部去重，方便确定target和mid所在区间
        while right >= 0 and nums[right] == nums[0]:
            right -= 1
        while left <= right:
            mid = left + (right-left)//2
            v = nums[mid] if (nums[mid] < nums[0]) == (target < nums[0]) else float("inf") if nums[mid] < nums[0] else float("-inf")
            if v <= target:
                res = mid
                left = mid + 1
            else:
                right = mid - 1
        return True if nums[res] == target else False