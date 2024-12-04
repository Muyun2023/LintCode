/*
 * Given a string s with letter a-z, 
 * can only change to the letter before,like z can change to y, b can change to a...
 * try to calculate the min steps of changing s to a palindrome
 * a,b,c,d,,,,x,y,z, 后一个字母可以换成前一个，b可以换成a；给一个字串，看把他变成回文子串，最少需要变几次字母就行
 */
public class Decrease_For_Palindrome {
    public int numOfOperations(String s){
        int len = s.length(); //length是5，index就是到4
        int count = 0;
        for(int i=0;i<len/2;i++){ //i是指index
            count += Math.abs(s.charAt(i)-s.charAt(len-1-i)); //是index相减，所以要len-1
        }
        return count;
    }
    
}

//回文串特性：双指针看两个字母是否相同，不同就把里面一个变变变；累加次数到遍历结束
//变几次其实就是ACII码之差
