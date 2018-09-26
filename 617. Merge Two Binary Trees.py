###############################
# 617. Merge Two Binary Trees #
###############################

# Traverse both Trees together and add the values in another 

class TreeNode(object):
	def __init__(self, x):
		self.val = x
		self.left = None
		self.right = None
	def treeTraverse(self, treeNode):
		print self.val


class Solution(object):
    def mergeTrees(self, t1, t2):
        """
        :type t1: TreeNode
        :type t2: TreeNode
        :rtype: TreeNode
        """
        if not t1:
            return t2
        if not t2:
            return t1
        t1.val = t1.val + t2.val
        t1.left = self.mergeTrees(t1.left, t2.left)
        t1.right = self.mergeTrees(t1.right, t2.right)
        
        return t1

		

