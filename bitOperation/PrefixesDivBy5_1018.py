class Solution:
    def prefixesDivBy5(self, A: List[int]) -> List[bool]:
        res = []
        v = 0
        # 1110(14) --> 11101 (29)
        for i in range(0, len(A)):
            v = (v*2 + A[i]) % 5
            res.append(v==0)
        return res