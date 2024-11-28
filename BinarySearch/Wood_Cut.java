package BinarySearch;

class Solution {
    public int woodCut(int[] nums, int k) {
        if(nums==null||nums.length==0){return 0;}
        // 注意start，end是赋值为长度；最短木头是1
        int start=1,end=0;
        long sum=0;
        for(int len:nums){
            end=Math.max(end,len); //看nums中所有木头长度，把最长的赋值给end
            sum+=len; //计算所有木头的总长度
        }
        // sum/k是题目要求取到k个木头的话、每个木头允许的最大长度，把它和最长木头比较，把小的数值赋值给end；比如木头是1,9,9,9，k=4,28/4=7,最长木头是9,所以我们就不能赋值9给end，因为想要取到4根，允许的最大长度是7
        end=(int)Math.min(end,sum/k);

        if(end<1){return 0;} //如果比1都小，那就直接返回

        while(start+1<0){
            int mid=start+(end-start)/2;
            if(getCount(nums,mid)>=k){ //长度为mid的木头总数 >= 目标总数k, 那得继续增长木头长度，选择右边
                start=mid;
            }else{
                end=mid;
            }
        }
        // 因为之前排除了无解的情况，那就是一定有解的(至少可以切成长度为1的木头们，最长的也是1)，不是end就是start；如果end符合要求，首选end(因为end更长)，否则就是start
        return (getCount(nums,end)>=k)?end:start;
    }

    public int getCount(int[]nums,int len){
        int count=0;
        for(int i:nums){
            count+=i/len; //其实就是相当于总长度除以len，就是长度为len的可以切多少段
        }
        return count;
    }
}
