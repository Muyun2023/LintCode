package BinarySearch;

class Solution {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int start = 0, end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            //如果当前区间 [start, end] 已经是升序，则最小值在起点
            if (nums[start] < nums[end]) {
                return nums[start];
            }
            //当中间值等于末尾值时，可能有重复元素，逐步缩小搜索范围
            //由于数组本来就是升序，变换后的两部分也是局部升序，缩小范围是为了跳过重复数字end
            if (nums[mid] == nums[end]) {
                //start++;
                end--;
            } else if (nums[mid] > nums[end]) {
                start = mid;
            } else {
                end = mid;
            }
        }
        return Math.min(nums[start], nums[end]);
    }
}