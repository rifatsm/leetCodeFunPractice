207. Course Schedule.java

// Solution: BFS Topological Sorting 
// Runtime:  6 ms
// TC: O(V*E)
// SC: O(V+E+n) ?

/* Approache: BFS Topological Sorting 
*   1. Initiate an ArrayList of ArrayList "graph" to store all the course dependencies
*   2. Create a "queue" to manage BFS
*   3. Enter all the depended courses in "graph" and increment "degree" value for each depended course
*   4. For each of the courses that has zero "degree", increment "count" and offer to the "queue"
*   5. Poll "course" from "queue" and check if there is any "depended course" on that "course" in "graph"
*   6. If depended course (after decrementing a value) is ZERO then add it to the "queue" and increment "count"
*   7. If "count" value is greater than or equal to "numCourses", then TRUE.
*   8. Otherwise, FALSE

*/

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList();
        Queue<Integer> queue = new LinkedList();
        int count = 0;
        
        for(int i = 0; i < numCourses; i++) // Create empty ArrayLists for "prerequisites"
            graph.add(new ArrayList());
        
        int[] degree = new int[numCourses];
        for(int i = 0; i < prerequisites.length; i++){   // Store the "prerequisites" in the "graph"
            graph.get(prerequisites[i][0]).add(prerequisites[i][1]);
            degree[prerequisites[i][1]]++;
        }
        
        for(int i = 0; i < numCourses; i++){
            if(degree[i] == 0){
                queue.offer(i);
                count++;
            }
        }
        
        while(!queue.isEmpty()){
            int course = queue.poll();
            for(int i = 0; i < graph.get(course).size(); i++){
                int dependedCourse = graph.get(course).get(i);
                degree[dependedCourse]--;
                if(degree[dependedCourse] == 0){
                    queue.add(dependedCourse);
                    count++;
                }
            }
        }
        if(count >= numCourses)
            return true;
        else
            return false;
    }
}

// Solution: DFS 
// Runtime: 64 ms
// TC: O(V*E)
// SC: O(V+E+n) ?

/* Approache: DFS w/ memory
*   1. Initiate an ArrayList of ArrayList to store all the course dependencies
*   2. Create a memory to store the "visiting" courses
*   3. Iterately run DFS function to check if there is dependency for any of the course in the ArrayList
*   4. Return "false" if a single dependency is found
*/
/*
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList();
        
        for(int i = 0; i < numCourses; i++) // Create empty ArrayLists for "prerequisites"
            graph.add(new ArrayList());
        
        boolean[] visited = new boolean[numCourses];
        for(int i = 0; i < prerequisites.length; i++)   // Store the "prerequisites" in the "graph"
            graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
        
        for(int i = 0; i < numCourses; i++)
            if(!dfs(graph, visited, i))     // Run DFS function
                return false;
        
        return true;
    }
    private boolean dfs(ArrayList<ArrayList<Integer>> graph, boolean[] visited, int course){
        if(visited[course])
            return false;
        else
            visited[course] = true;
        
        for(int i = 0; i < graph.get(course).size(); i++)
            if(!dfs(graph, visited, graph.get(course).get(i))) // Check for each of the dependencies
                return false;
        
        visited[course] = false;    // If non of the "courses" have dependencies, we reinstate the course to default (false)
        
        return true;
    }
    
}
*/