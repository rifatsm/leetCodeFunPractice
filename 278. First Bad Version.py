####################################
# 278. First Bad Version
####################################
from math import ceil

def isBadVersion(version):
	if 1702766719 <= version <=  2126753390:
		return True


class Solution(object):

	def firstBadVersion(self, n):
		left = 1
		right = n
		while(left < right):
			mid = left + (right - left) / 2
			print "mid: " + str(mid) + " left: " + str(left) + " right: " + str(right)
			if isBadVersion(mid):
				right = mid
			else:
				left = mid + 1
		return left

sol = Solution()
print "return"
# print sol.firstBadVersion(5)
print sol.firstBadVersion(2126753390)

# Errors:
# n = 2126753390, version = 1702766719

####################################
# Accepted
# Good use of Binary Search Algorithm 
# Always use `mid = left + (right - left)/2` instead of `mid = (left + right)/2`. Other overflow might happen for (left+right)
# Read more: https://en.wikipedia.org/wiki/Binary_search_algorithm#Implementation_issues
####################################
