package BinarySearch;

class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        if (piles == null || piles.length == 0) {
            return 0;
        }

        // 初始值：速度范围是 [1, max(piles)]
        int start = 1, end = 0;
        long sum=0;
        for (int amount : piles) {
            end = Math.max(end, amount); //end取最大数量的一排香蕉
            sum+=amount;
        }
        // 特殊情况：如果 h >= 总香蕉数，最小速度是 1
        if (h >= sum) {
            return 1;
        }

        while (start+1 < end) {
            int mid = start + (end - start) / 2;

            // 检查当前速度是否能满足时间 h
            if (getCount(piles, mid) <= h) {
                end = mid; // 当前速度可以满足，尝试更慢的速度
            } else {
                start = mid; // 当前速度不足，尝试更快的速度
            }
        }

        return (getCount(piles,end)>h)?start:end; // 最后返回 start，它是最小满足速度
    }

    // 按当前速度 amount 计算完成所有香蕉所需的时间
    public long getCount(int[] piles, int amount) {
        long count = 0; // 使用 long 避免整数溢出
        for (int i : piles) {
            count += (i + amount - 1) / amount; // 向上取整计算每堆所需时间
        }
        return count;
    }
}

