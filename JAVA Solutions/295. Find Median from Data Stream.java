295. Find Median from Data Stream.java
// Solution: Using MaxHeap and MinHeap
// Runtime: 137 ms
// TC: O(logn) SC: O(n) 

/* Approach: using Two Heaps
*   1. Use a MaxHeap to store the largest value at index 0
*   2. Use a MinHeap to store the smallest value at index 0
*   3. Use a boolean variable to alternate "even"/odd

*   4. If "even" is true:
        4.1. Add num to "MinHeap". 
        4.2. Since "MinHeap" received a new element, we must do a balancing step for "MaxHeap". 
        4.3 So remove the largest element from "MinHeap" and offer it to "MaxHeap".
*   5. If "even" is false:
        5.1. Do the alternate thing with "MaxHeap" and "MinHeap".
        
*   6. Check out the Code Flow after this solution code below to understand how it works.
    Testcase:               ["MedianFinder","addNum","addNum","addNum","addNum","findMedian","addNum","addNum","findMedian"]
[[],[41],[35],[62],[4],[],[97],[108],[]]
*/


class MedianFinder {

    /** initialize your data structure here. */
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    private boolean even = true;
    
    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
        if(even){
            minHeap.offer(num);
            maxHeap.offer(minHeap.poll());
        }else{
            maxHeap.offer(num);
            minHeap.offer(maxHeap.poll());
        }
        even = !even;
        
        // System.out.println("num: "+num+" even: "+!even);        // Code Flow
        // System.out.println("MaxHeap: "+maxHeap);
        // System.out.println("MinHeap: "+minHeap);
        
        
    }
    
    public double findMedian() {
        if(even)
            return (maxHeap.peek() + minHeap.peek()) * 0.5;
        else
            return  maxHeap.peek();
    }
}



/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */