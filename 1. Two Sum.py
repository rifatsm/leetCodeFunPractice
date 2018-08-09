############################################################################################################################################

# 1. Two Sum

# Given an array of integers, return indices of the two numbers such that they add up to a specific target.

# You may assume that each input would have exactly one solution, and you may not use the same element twice.

# Example:

# Given nums = [2, 7, 11, 15], target = 9,

# Because nums[0] + nums[1] = 2 + 7 = 9,
# return [0, 1].

############################################################################################################################################

def twoSum(nums, target):
	nums.sort()
	index = 0
	while index < len(nums):
		if (nums[index]+nums[index+1] == target):
			break;
		index = index + 1
	return [index, index+1]

def twoSumV2(nums, target):
	x = 0
	while x < len(nums):
		y = x + 1
		while y < len(nums):
			if nums[x] + nums[y] == target:
				return [x,y]
			y = y + 1
		x = x + 1 
	return []

# print twoSum([2,11,7,15], 9)
print twoSumV2([2,11,7,15], 9)

############################################################################################################################################
# Accepted
# Run time complexity is high. O(n^2)
# We can reduce it by using HashMap. O(n) 
############################################################################################################################################