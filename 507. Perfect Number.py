############################
# 507. Perfect Number
# https://leetcode.com/problems/perfect-number/description/
############################

# Try listing all the positive divisor of the number
	# - We can do it by dividing the number with all the numbers upto sqrt(number) and keeping both the divisor and the quotient
	# - Add all the elements of the list to see if it equals to the number itself

class Solution(object):
    def checkPerfectNumber(self, num):
        """
        :type num: int
        :rtype: bool
        """
        