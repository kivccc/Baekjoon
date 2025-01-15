import java.util.*;
class Solution {
    public String solution(int n) {
        // 8 3*2+2 22
        // 9 3*2+3 24
        //10 3*3+1 41 ... 44 -> 3*3+3 12
        //111 9*1+3*1+1 -> 13
        StringBuilder sb=new StringBuilder();
        while(n>0){
            int re=n%3;
            if(re==0){
                sb.append("4");
                n=n/3-1;
            }
            else{
                sb.append(re);
                n=n/3;
            }        
        }
        return sb.reverse().toString();
    }
}