/**一个数据流进来，每次一个字母，当前数据流的排列是否能组成回文串；注意是能组成，而不是必须一开始就是
输入“ababa",输出【1,0,1,1,1】，1代表可以组成，0代表不能组成
解题思路：
回文子串的字母中，要么每个字母是偶数个，要么只会有一个字母是奇数个，所以几个字母出现了奇数次？这个值<=1的话，那就能组成回文字串
*/

public class Palindrome_Data_Stream {
    public int[]getStream(String s){
        if(s==null||s.length()==0){return null;}

        int oddLetterCount=0;//记录出现奇数次数字母的个数
        int[]res=new int[s.length()]; //用来存结果
        int[]letter=new int[26];//记录每个字母出现的次数
        for(int i=0;i<s.length();i++){
            letter[s.charAt(i)-'a']++; //letter[0]就是a,letter[1]就是b...
            if(letter[s.charAt(i)-'a']%2==1){ //余数是1说明该字母出现奇数次，oddLetterCount就增加1，该字母计入
                oddLetterCount++;
            }else{
                oddLetterCount--;//余数是0说明该字母出现偶数次，oddLetterCount就减去1，该字母不计入
            }
            res[i]=oddLetterCount>1?0:1;//如果出现奇数次的字母总数，比1大，那就必然无法组成回文，因为回文字串中有且仅有一个字母会出现奇数次
        }
        return res;
    }  
}


