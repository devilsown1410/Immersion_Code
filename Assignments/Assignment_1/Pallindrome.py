class Solution(object):
    def isPalindrome(self, x):
        c=str(x)
        d= c[::-1]
        return c==d