########################################################################
# 771. Jewels and Stones
########################################################################

def numJewelsInStones(J, S):
	count = 0
	if J and S:
		for jewels in J:
			count = count + S.count(jewels)
	return count

print numJewelsInStones("aA", "aAAbbbb")