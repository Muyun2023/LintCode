package BinarySearch;

/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */

 class Solution {
    public int search(ArrayReader reader, int target) {
        int range=1;
        while(reader.get(range-1)<target){
            if(reader.get(range)==target){return range;}
            range=range*2;
        }

        int start=0,end=range-1;
        while(start+1<end){
            int mid=start+(end-start)/2;
            if(reader.get(mid)<target){
                start=mid;
            }else if(reader.get(mid)==target){
                return mid;
            }else{
                end=mid;
            }
        }

        if(reader.get(start)==target){return start;}
        if(reader.get(end)==target){return end;}

        return -1;
    }
}
