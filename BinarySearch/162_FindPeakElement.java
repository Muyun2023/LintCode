package BinarySearch;

class Solution {
    public int findPeakElement(int[] nums) {
        if(nums==null || nums.length==0){return -1;}
        if(nums.length==1 || nums[0]>nums[1]){return 0;}
        if(nums[nums.length-1]>nums[nums.length-2]){return nums.length-1;}

        int start=1,end=nums.length-2; 
        while(start+1<end){
            int mid=start+(end-start)/2;
            if(nums[mid]<nums[mid-1]){ //如果mid左边上升
                end=mid;
            }else if(nums[mid]<nums[mid+1]){//如果mid右边上升
                start=mid;
            }else{
                return mid;// mid左边也不上升，右边也不上升，那本身就是峰值
            }
        }
        //mid不是峰值，但题目说了一定有峰值，start和end会走到相邻两个元素，其中之一一定是峰值
        return nums[start]<nums[end]?end:start;
    }
}
