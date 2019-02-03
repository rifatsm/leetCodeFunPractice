985. Sum of Even Numbers After Queries.java

class Solution {
    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        int len = queries.length;
        int[] res = new int[len];
        if(A.length < 1)
            return res;
        if(queries.length < 1)
            return res; 
        int index = 0;
        int value = 0;
    
        for(int i = 0; i < len; i++){
            index = queries[i][1];
            value = queries[i][0];
            int count = 0;
            
            A[index] = A[index] + value;
            
            for(int j = 0; j < A.length; j++){
                if(A[j] % 2 == 0){
                    count += A[j];
                }
            }
            
            res[i] = count;
            
        }
        
        return res;
    }
}