import java.util.*;
class Solution {
    public int solution(int k, int[] tangerine) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i:tangerine){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        List<Map.Entry<Integer,Integer>> list=new ArrayList<>(map.entrySet());
        list.sort(Map.Entry.<Integer, Integer>comparingByValue().reversed());
        int answer = 0;
        for (Map.Entry<Integer, Integer> entry : list){
            k-=entry.getValue();
            answer++;
            if(k<=0)
                break;
        }
        return answer;
    }
}