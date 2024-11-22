/*
 * Problems:
 * Given a string which encode by ASCII,need to write a function that take an encode string as input and returns reversed decoded string.
 * There is only uppperCase letters in answered string.
 * example:
 * input: "656667"
 * output:"CBA"
 */
public class Reverse_ASCIIencoded_String {
    public static String reverse(String encodeString){
        StringBuilder sb = new StringBuilder();
        //由于大写字母对应的ASCII码都是2位数，所以遍历时按照2位进行
        //要求返回的是翻转的解码字符串，就是ASCII码要从后往前遍历
        for(int i = encodeString.length();i>=2;i-=2){
            String sub = encodeString.substring(i-2,i);
            int num = Integer.parseInt(sub);
            sb.append((char)num);
        }
        return sb.toString();
    }
}

