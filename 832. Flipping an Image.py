##########################
# 832. Flipping an Image #
##########################

# My initial submission

def invertImage(img):
	new_img = []
	for i in img:
		new_img.append(1-i)
	return new_img

def flipAndInvertImage(A):
	output_image = []
	for img in A:
		output_image.append(list(reversed(invertImage(img))))
	return output_image


#########################

# print flipAndInvertImage([[1,1,0],[1,0,1],[0,0,0]])
# print flipAndInvertImage([[1,1,0,0],[1,0,0,1],[0,1,1,1],[1,0,1,0]])

#########################
# Submission accepted 
# The following submission(s) is improving the runtime

def flipAndInvertImage(A):
	length = len(A)
	output_image = [0]*length
	for img in A:
		for ind in range(0, (length+1)/2):
			img[ind] = img[ind] + img[length-1-ind] 
			img[length-1-ind] = img[ind] - img[length-1-ind]
			img[ind] = 1 - (img[ind] - img[length-1-ind])
			img[length-1-ind] = 1 - img[length-1-ind]
	return A

#########################

# Best Solution:

def flipAndInvertImage(A):
	return [[ (1-i) for i in img[::-1]] for img in A]	

#########################

print flipAndInvertImage([[1,1,0],[1,0,1],[0,0,0]]) # [[1,0,0],[0,1,0],[1,1,1]]
print flipAndInvertImage([[1,1,0,0],[1,0,0,1],[0,1,1,1],[1,0,1,0]]) # [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]