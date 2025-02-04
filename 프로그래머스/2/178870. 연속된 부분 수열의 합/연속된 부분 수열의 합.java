import java.util.*;
class Solution {
    public int[] solution(int[] sequence, long k) {
        int idxl=0;
        int idxr=0;
        long sum=0L;
        int len=1000001;
        int[] answer=new int[2];
        
        while(true){
            if(sum<k){
                if(idxr==sequence.length)
                    break;
                sum+=sequence[idxr++];
            }
            else{
                if(sum==k && len>idxr-idxl){
                    answer[0]=idxl;
                    answer[1]=idxr-1;
                    len=idxr-idxl; 
                }
                sum-=sequence[idxl++];
            }
        }
        return answer;
    }
}