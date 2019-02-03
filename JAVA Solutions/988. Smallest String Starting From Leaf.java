988. Smallest String Starting From Leaf.java

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public String smallestFromLeaf(TreeNode root) {
        String res = "";
        for(int i = 0; i < 1000; i++)
            res += "z";
        
        if(root == null)
            return  res;
        List<List<Integer>> map = new ArrayList();
        List<Integer> list = new ArrayList();
        // Stack<Integer> stack = new ArrayDeque();
        
        dfs(root, map, list);
        
        // System.out.println("map: "+map);
        
        for(int i = 0; i < map.size(); i++){
            List<Integer> tempList = map.get(i);
            String str = "";
            for(int t : tempList){
                char c = (char)((int)'a' + t);
                str = c + str;
            }
            // System.out.println("str: "+str);
            if(res.compareTo(str) > 0){
                res = str;
            }
        }
        
        return res;
        
        
    }
    
    private void dfs(TreeNode node, List<List<Integer>> map, List<Integer> list){
        
        if(node == null){
            return;
        }
        
        list.add(node.val);
        // System.out.println("list: "+list);
        
        if(node.left == null && node.right == null){
            // System.out.println("final list: "+list);
            map.add(new ArrayList(list));
            return;
        }
        
        dfs(node.left, map, list);
        if(node.left != null)
            list.remove(list.size()-1);
        dfs(node.right, map, list);
        if(node.right != null)
            list.remove(list.size()-1);
    }
}