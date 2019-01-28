139. Word Break.java

// Solution: DP
// Runtime: 6 ms
// TC: O(nlogn)
// SC: O(n)
/* Approach: 
*   1. We have two pointers, "i" and "j"
*   2. Here, "i" is the leading pointer and "j" is the tailing pointer
*   3. We check for each of the substring between these two pointers and see if any of the substring exists in the "wordDict"
*   4. We set "true" only if the previous part of the substring is true [i.e. ri[j] == "true"]. With this check we can be sure that the previos substrings all exist in "wordDict". 

Testcase for Code Flow: 
"catsandog"
["cats", "dog", "sand", "and", "cat"]
*/

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] ri = new boolean[s.length() + 1];
        
        ri[0] = true;
        
        for(int i = 1; i <= s.length(); i++){
            for(int j = 0; j < i; j++){
                // System.out.println("i: "+i+" j: "+j+" string: "+s.substring(j,i)); // Code Flow pt1
                if(ri[j] == true && wordDict.contains(s.substring(j, i))){
                    ri[i] = true;
                    // System.out.println("ri: "+Arrays.toString(ri)); // Code Flow pt2
                    break;
                }
            }
        }
        
        return ri[s.length()];
    }
}