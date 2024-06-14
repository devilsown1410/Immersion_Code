from typing import List
class Solution:
    def thirdMax(self, nums: List[int]) -> int:
        y=set(nums)
        m=list(y)
        if len(y)==1:
            return m[0]
        elif len(y)==2:
            m.sort()
            return m[-1]
        else:
            m.sort()
            return m[-3]

