class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(k);
        for (int elem : nums) {
            if (pq.size() < k) pq.add(elem);
            else if (pq.peek() < elem) {
                pq.poll();
                pq.add(elem);
            }
        }
        return pq.poll();
    }
}
