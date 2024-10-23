import java.util.*;
class Solution {
    public int[] solution(int N, int[] stages) {
        int[] arr=new int[N+1];
        for(int i=0;i<stages.length;i++){
            arr[stages[i]-1]++;
        }

        HashMap<Integer,Double> map=new HashMap<>();
        int sum=stages.length;
        for(int i=1;i<=N;i++){
            map.put(i,arr[i-1]*1.0/sum);
            sum-=arr[i-1];
        }
        List<Map.Entry<Integer, Double>> list = new ArrayList<>(map.entrySet());
        list.sort(Map.Entry.<Integer, Double>comparingByValue());
        for (Map.Entry<Integer, Double> entry : list) {
            System.out.println("Key: " + entry.getKey());
        }
        return new int[]{1};
    }
}