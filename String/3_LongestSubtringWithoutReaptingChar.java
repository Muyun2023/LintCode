class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s==null || s.length()==0){return 0;}
        
        int start=0;
        int maxLen=0;

        for(int end=0;end<s.length();end++){
            for(int i=start;i<end;i++){
                if(s.charAt(i)==s.charAt(end)){
                    start=i+1;
                    break;
                }
            }
            maxLen=Math.max(maxLen,end-start+1);
        }
        return maxLen;   
    }
}