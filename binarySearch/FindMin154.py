class Solution:
    def findMin(self, nums: List[int]) -> int:
        left, right = 0, len(nums)-1
        res = 0
        while right >= 0 and nums[right] == nums[0]:
            right -= 1
        nr = right
        while left <= right:
            mid = left + (right - left)//2
            if nums[mid] > nums[nr]:
                left = mid + 1
            else:
                res = mid
                right = mid - 1
        return nums[res]