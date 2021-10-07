class Solution {
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        if (a == 0) return sortLinear(nums, b, c);
        int[] result = new int[nums.length];
        double x_middle = - (double)(b) / (2 * a);
        int left = 0;
        int right = nums.length - 1;
        int index = 0;
        while (left <= right) {
            if (Math.abs(nums[left] - x_middle) > Math.abs(nums[right] - x_middle)) {
                result[index] = func(nums[left], a, b, c);
                left++;
            } else {
                result[index] = func(nums[right], a, b, c);
                right--;
            }
            index++;
        }
        if (a > 0) reverseArray(result);
        return result;
    }
    
    private int[] sortLinear(int[] nums, int b, int c) {
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[i] = func(nums[i], 0, b, c);
        }
        if (b < 0) reverseArray(result);
        return result;
    }
    
    private void reverseArray(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[len - 1 - i];
            arr[len - 1 - i] = temp;
        }
    }
    
    private int func(int x, int a, int b, int c) {
        return a * x * x + b * x + c;
    }
}
