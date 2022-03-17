class Solution {
    public boolean search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right && nums[left] == nums[right]) left++;
        
        int start = left;
        boolean targetIsLeft = target >= nums[left];
        while (left < right) {
            int mid = left + (right - left) / 2;
            boolean midIsLeft = nums[mid] >= nums[start];
            if (targetIsLeft && !midIsLeft) right = mid - 1;
            else if (!targetIsLeft && midIsLeft) left = mid + 1;
            else {
                if (nums[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
        }
        return nums[left] == target;
    }
}
