class Solution {
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        int[] result = new int[nums.length];
        int left = 0;
        int right = nums.length - 1;
        int index = left;
        int step = 1;
        if (a >= 0) {
            index = right;
            step = -1;
        }
        while (left <= right) {
            int y_left = func(nums[left], a, b, c);
            int y_right = func(nums[right], a, b, c);
            if ((step == 1 && y_left < y_right) ||
                (step == -1 && y_left > y_right)) {
                result[index] = y_left;
                left++;
            } else {
                result[index] = y_right;
                right--;
            }
            index += step;
        }
        return result;
    }

    private int func(int x, int a, int b, int c) {
        return a * x * x + b * x + c;
    }
}
