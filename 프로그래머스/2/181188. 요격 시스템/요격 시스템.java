import java.util.*;
class Solution {
    public int solution(int[][] targets) {
        Arrays.sort(targets,(e1,e2)->{
            if(e1[1] == e2[1])
                return e1[0]-e2[0];
            else
                return e1[1]-e2[1];
        });
        //System.out.println(Arrays.deepToString(targets));
        int answer = 0;
        int x = 0;
        for(int i=0;i<targets.length;i++){
            if(targets[i][0] >= x){

                answer++;
                x= targets[i][1];
                //System.out.println(x);
                //System.out.println(answer);
                //System.out.println();
            }
        }
        return answer;        
    }
}