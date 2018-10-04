##########################
# 257. Binary Tree Paths #
##########################

### My Code from the LeetCode Playground Debugger:
### The Alternate Solution code is better performing, much more concise, and more comprehensive 

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    pathStrList = []
    def printPaths(self, pathList, pathLen):
        pathStr = ""
        for i in pathList[:pathLen-1]:
            pathStr = pathStr + str(i) + "->"
        pathStr = pathStr + str(pathList[pathLen-1])
        print "pathStr: ",
        print pathStr
        self.pathStrList.append(pathStr)
        print "# pathStrList: ",
        print self.pathStrList
        
    def getPaths(self, root, pathList, pathLen):
        if root is None:
            print "Returning Root None "
            return
        if (len(pathList) > pathLen): # We need it to reset the value 
            print "Descending..."
            print "pathList len: ",
            print len(pathList)
            print "pathLen: ",
            print pathLen
            pathList[pathLen] = root.val
        else:
            print "Appending..."
            pathList.append(root.val)
            print "pathList: ",
            print pathList
        
        pathLen += 1
        print "pathLen: ",
        print pathLen
        
        if root.left is None and root.right is None:
            print "Leaf node reached"
            self.printPaths(pathList, pathLen)
        else:
            print "going left"
            self.getPaths(root.left, pathList, pathLen)
            print "going right"
            self.getPaths(root.right, pathList, pathLen)
        
    def binaryTreePaths(self, root):
        """
        :type root: TreeNode
        :rtype: List[str]
        """
        path = []
        self.getPaths(root, path, 0)
        return self.pathStrList

def stringToTreeNode(input):
    input = input.strip()
    input = input[1:-1]
    if not input:
        return None

    inputValues = [s.strip() for s in input.split(',')]
    root = TreeNode(int(inputValues[0]))
    nodeQueue = [root]
    front = 0
    index = 1
    while index < len(inputValues):
        node = nodeQueue[front]
        front = front + 1

        item = inputValues[index]
        index = index + 1
        if item != "null":
            leftNumber = int(item)
            node.left = TreeNode(leftNumber)
            nodeQueue.append(node.left)

        if index >= len(inputValues):
            break

        item = inputValues[index]
        index = index + 1
        if item != "null":
            rightNumber = int(item)
            node.right = TreeNode(rightNumber)
            nodeQueue.append(node.right)
    return root

def stringArrayToString(input):
    return json.dumps(input)

def main():
    import sys
    def readlines():
        for line in sys.stdin:
            yield line.strip('\n')
    lines = readlines()
    while True:
        try:
            line = lines.next()
            root = stringToTreeNode(line)
            
            ret = Solution().binaryTreePaths(root)
            out = stringArrayToString(ret)
            print out
        except StopIteration:
            break

if __name__ == '__main__':
    main()

### Alternate Solution: from LeetCode submissions
### A better solution is the following. 
### The following code is better performing, much more concise, and more comprehensive 

class Solution(object):
    def binaryTreePaths(self, root):
        """
        :type root: TreeNode
        :rtype: List[str]
        """
        ans = []
        temp = ""    
        self.findPath(root, ans, temp)
        return ans
    
    def findPath(self, root, ans, temp):
        if not root:
            return 
        if root.left == None and root.right == None:
            temp += str(root.val)
            ans.append(temp)
            return 
        temp += str(root.val) + "->"
        self.findPath(root.left, ans, temp)
        self.findPath(root.right, ans, temp)
