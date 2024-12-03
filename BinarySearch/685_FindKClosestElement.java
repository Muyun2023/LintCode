package BinarySearch;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        //先找到中位线它右边邻居,设置为双指针
        int right=upperClosest(arr,x);
        int left=right-1;

        List<Integer> result = new ArrayList<>();
        for(int i=0;i<k;i++){
            if(isLeftCloser(arr,x,left,right)){
                result.add(0,arr[left]); //因为要求返回的是从小到大，所以每次添加要放在index0
                left--;
            }else{
                result.add(arr[right]);
                right++;
            }
        }

        return result; 
    }

    //二分法找中位线和它右边邻居，返回右边邻居的index
    public int upperClosest(int[]arr,int target){
        int start=0,end=arr.length-1; 
        while(start+1<end){
            int mid=start+(end-start)/2;
            if(arr[mid]<target){
                start=mid;
            }else{
                end=mid;
            }
        }
        if(arr[start]>=target){return start;}
        if(arr[end]>=target){return end;}
        //return -1; 这么写会报错，case4过不了，target比所有值都大，然后返回-1，但index不能为-1（数组的索引不能为负数。如果尝试访问负数索引，会导致 ArrayIndexOutOfBoundsException 或类似的运行时错误。）
        return arr.length;
    }

    //判断左右指针对应数字大小，永远先左后右的选
    public boolean isLeftCloser(int[] arr,int target,int left,int right){
        if(left<0){return false;}
        if(right>arr.length-1){return true;} 
        return target-arr[left] <= arr[right]-target; //if()else格式简写
        //注意这里不要写成arr[left]-target
    }
}
