import java.util.*;

class MedianOfStream {
    PriorityQueue <Integer> maxHeap;
    PriorityQueue <Integer> minHeap;
    public MedianOfStream () {
        maxHeap = new PriorityQueue<>((a,b) -> b - a);
        minHeap = new PriorityQueue<>((a,b) -> a - b);
    }
    public void insertNum(int num) {
        if (maxHeap.isEmpty() || maxHeap.peek() >= num) {
            maxHeap.add(num);
        } else {
            minHeap.add(num);
        }
        if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.add(maxHeap.poll());
        } else if(minHeap.size() > maxHeap.size()) {
            maxHeap.add(minHeap.poll());
        }
    }
    public double findMedian() {
        if (maxHeap.size() == minHeap.size()) {
            return maxHeap.peek() / 2.0 + minHeap.peek() / 2.0;
        } else {
            return maxHeap.peek();
        }
    }
    public static void main(String[] args) {
        // Driver code
        int[] nums = {35, 22, 30, 25, 1};
        MedianOfStream medianOfAges = null;
        for(int i=0; i< nums.length; i++){
            System.out.print(i+1);
            System.out.print(".\tData stream: [");
            medianOfAges = new MedianOfStream();
            for(int j=0; j<=i; j++){
                System.out.print(nums[j]);
                if(j != i)
                    System.out.print(", ");
                medianOfAges.insertNum(nums[j]);
            }
            System.out.println("]");
            System.out.println("\tThe median for the given numbers is: " + medianOfAges.findMedian());;
        }

    }
}