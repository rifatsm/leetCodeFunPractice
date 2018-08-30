###############################################
# 804. Unique Morse Code Words
###############################################

class Solution(object):
	def __init__(self):
		self.morse_table = [".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."]
	def uniqueMorseRepresentations(self, words):
		new_table = []
		for word in words:
			new_word = ""
			for letter in word:
				new_word += self.morse_table[ord(letter) - 97]
			new_table.append(new_word)
		return len(set(new_table))

# print ord("Z")
sol = Solution()
print sol.uniqueMorseRepresentations(words = ["gin", "zen", "gig", "msg"])
