/*
 * Given a string s with letter a-z, 
 * can only change to the letter before,like z can change to y, b can change to a...
 * try to calculate the min steps of changing s to a palindrome
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
