import java.util.*;
class Solution {
    public int[] solution(long n) {
        ArrayList<Long> list=new ArrayList<>();
        while(n!=0){
            list.add(n%10);
            n=n/10;
        }
        int[] answer=new int[list.size()];
        int idx=0;
        for(long i: list){
            answer[idx++]=(int)i;
        }
        return answer;
    }
}