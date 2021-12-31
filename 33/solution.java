class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        boolean targetIsLeft = target >= nums[left];
        while (left < right) {
            int mid = left + (right - left) / 2;
            boolean midIsLeft = nums[mid] >= nums[0];
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
        if (nums[left] == target) return left;
        return -1;
    }
}
