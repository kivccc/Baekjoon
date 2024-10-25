import java.util.*;
class Solution {
    public int solution(String s) {
        StringBuilder sb=new StringBuilder(s);
        int answer=0;
        while(sb.length()>0){
            int[] count=new int[2];
            char c=sb.charAt(0);
            count[0]++;
            for(int i=1;i<sb.length();i++){
                System.out.println(sb.charAt(i));
                if(sb.charAt(i)!=c)
                    count[1]++;
                else
                    count[0]++;
                if(count[0]==count[1]){
                    answer++;
                    sb.delete(0,i+1);
                    break;
                }
                
            }
            if(count[0]!=count[1]){
                answer++;
                break;                
            }

        }
        return answer;
    }
}