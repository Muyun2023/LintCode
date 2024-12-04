/**
 * longest semi alternating substring，
 * 给定一个长度为N且只包含a,b的字符串，需要找出最长的字串长度，并且其中不包含三个连续字母。注意s是其本身的字串。
 * 解题思路：
 * 1. 暴力解法是枚举，三个for循环
 * 2. 双指针+滑动窗口：
 * 两个指针同时起步，起点指针不轻易变化，终点指针右移动，如果终点指针移动发现出现3个相同字母，那么起点指针应该移动到终点指针前一位
 * 这个过程中需要统计的两个变量：
 * 最后一个字母出现的次数
 * 合法子串最大历史长度
 */
public class Longest_Semi_Alternating_Sunstring {
    public int LongestSemiAlternatingSunstring(String s){
        if(s==null||s.length()==0){return 0;}
        if(s.length()<3){return s.length();}

        int start=0;//起点指针
        //int end=1;终点指针
        int endDupCount=1;//最后一个字母出现次数的计数器，起步就是1次
        int maxLen=0;//记录合法最大长度

        for(int end=1;end<s.length();end++){
            char preChar=s.charAt(end-1); //终点指针前一个字母
            char curChar=s.charAt(end); //终点指针所在字母

            if(curChar==preChar){ //如果二者相同，说明终点指针所在字母，也就是最后一个字母出现2次，计数器+1
                endDupCount++;
                if(endDupCount==3){ //如果计数器已经是3，说明字母出现3次，这时就该移动和更新了
                    start=end-1; //起点移动到终点前一位即可
                    endDupCount=2; //此时最后一位字母出现2次，计数器更新为2
                }
            }else{
                endDupCount=1;//如果二者不同，说明出现新字母，终点也是最后一个字母出现次数直接更新为1
            }
            maxLen=Math.max(maxLen,end-start+1); //每一次记录下最大长度，就是当前窗口长度和历史最大数据取max
        }
        return maxLen;
    }
}
