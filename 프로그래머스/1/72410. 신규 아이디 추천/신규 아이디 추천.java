import java.util.*;
class Solution {
    public String solution(String new_id) {
        StringBuilder sb=new StringBuilder(new_id.toLowerCase());
        for(int i=sb.length()-1;i>=0;i--){
            char c=sb.charAt(i);
            if(! (c=='-'|| c=='_'||c=='.'|| ('a'<=c&&c<='z')||('0'<=c&&c<='9')))
               sb.deleteCharAt(i);
        }
        sb=new StringBuilder(sb.toString().replaceAll("\\.+","\\."));
        if(sb.charAt(0)=='.')
            sb.deleteCharAt(0);
        if(sb.length()!=0 && sb.charAt(sb.length()-1)=='.')
            sb.deleteCharAt(sb.length()-1);        
        if(sb.length()==0)
            sb.append("a");
        if(sb.length()>=16){
            sb.delete(15,sb.length());
            if(sb.charAt(sb.length()-1)=='.')
                sb.deleteCharAt(sb.length()-1);    
        }
        if(sb.length()<=2){
            char c=sb.charAt(sb.length()-1);
            int len=sb.length();
            for(int i=0;i<3-len;i++)
                sb.append(c);
        }
        return sb.toString();
    }
}