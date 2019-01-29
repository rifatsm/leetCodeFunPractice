815. Bus Routes.java

// Solution: BSF
// Runtime: 51 ms
// TC: O(# of buses) ?
// SC: O(# of buses) ?

/* Approach: BSF
*   1. For all the "routes", store the "busStop" in a "map"
*   2. Offer the "S" source in a "queue"
*   3. Iterate through all the "busStops" in the "queue" and check if in the "routes" array for that "busStop" we can find "T" destination. If found, return # of "busStops"
*   4. Keep a "visited" set to account the "busStops" that are already visited
*   5. If all the "busStops" are visited but destination is not found, return "-1"
*/
class Solution {
    public int numBusesToDestination(int[][] routes, int S, int T) {
        if(S == T)
            return 0;
        
        Map<Integer, ArrayList<Integer>> map = new HashMap();
        Queue<Integer> queue = new LinkedList();
        Set<Integer> visited = new HashSet();
        
        int res = 0;
        
        for(int i = 0; i < routes.length; i++){
            // For all the "routes", store the "busStop" in a "map"
            for(int j = 0; j < routes[i].length; j++){ 
                ArrayList<Integer> busStop = map.getOrDefault(routes[i][j], new ArrayList());
                busStop.add(i);
                map.put(routes[i][j], busStop);
            }
        }
        
        // Offer the "S" source in a "queue"
        queue.offer(S); 
        
        // Iterate through all the "busStops" in the "queue" and check if in the "routes" array for that "busStop" we can find "T" destination. If found, return # of "busStops"
        while(!queue.isEmpty()){    
            int size = queue.size();
            res++;
            for(int i = 0; i < size; i++){
                int currentStop = queue.poll();
                ArrayList<Integer> busStop = map.get(currentStop);
                for(int bs : busStop){
                    // Keep a "visited" set to account the "busStops" that are already visited
                    if(visited.contains(bs))
                        continue;
                    visited.add(bs);
                    for(int j = 0; j < routes[bs].length; j++){
                        if(routes[bs][j] == T)      // Eventually finding the destination "T"
                            return res;
                        queue.offer(routes[bs][j]);
                    }
                }
            }
        }
        
        return -1;  // Destination "T" never found 
    }
}