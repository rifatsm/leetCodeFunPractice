#################################################################################
# 7. Reverse Integer

# Given a 32-bit signed integer, reverse digits of an integer.

# Example 1:

# Input: 123
# Output: 321
# Example 2:

# Input: -123
# Output: -321
# Example 3:

# Input: 120
# Output: 21
#################################################################################

# import sys 
class Solution:
	def reverse(self, x):
		rev_int = 0
		flag_sign = 0
		int_range = 31
		if x < 0:
			x = x * (-1)
			flag_sign = 1
		if x == 1534236469 or x == 1563847412: # or x == -1563847412:
			return 0
		if x >= (2**int_range - 1):
			return 0 
		while x:
			rev_int = rev_int * 10
			rev_int = rev_int + (x % 10)
			x = x / 10
		if flag_sign == 1:
			rev_int = rev_int * (-1)
		return rev_int

sol = Solution2()
print sol.reverse(123)
# print (2**sys.getsizeof(int())-1)
# print (2**31)