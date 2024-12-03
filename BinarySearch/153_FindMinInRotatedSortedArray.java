package BinarySearch;

class Solution {
    public int findMin(int[] nums) {
        if(nums==null||nums.length==0){
            return -1;
        }
        //需要跟面试官确定特殊情况的返回值

        int start=0,end=nums.length-1;
        while(start+1<end){
            int mid=start+(end-start)/2;
            //如果中位数比末尾数都大，说明原先的起点应该在右边，那就抛弃左边
            if(nums[mid]>nums[end]){ 
                start=mid;
            }else{
                end=mid; //因为题目说了没有相同元素，所以else这里只是nums[mid]<nums[end]
            }
        }

        return Math.min(nums[start],nums[end]);
    }
}