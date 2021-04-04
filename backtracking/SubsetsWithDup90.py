class Solution:
    def subsetsWithDup(self, nums: List[int]) -> List[List[int]]:
        n = len(nums)
        nums = sorted(nums)
        res = []
        for mask in range(1<<n):
            tmp = []
            flag = 1
            for i in range(n):
                if (mask>>i)&1:
                    # 当前位被选取，前一位未被选取，且前一位和当前位相同
                    # 两者选一个的时候只有一种情况，10和01是同一种
                    # 或者 if i < n-1 and not (mask>>(i+1))&1 and nums[i] == nums[i+1]:
                    if i > 0 and not (mask>>(i-1))&1 and nums[i] == nums[i-1]:
                        flag = 0
                        break
                    tmp.append(nums[i])
            if flag:
                res.append(tmp)
        return res