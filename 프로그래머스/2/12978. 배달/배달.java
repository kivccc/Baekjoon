import java.util.*;
class Solution {
    public int solution(int N, int[][] road, int K) {
        HashMap<Integer,Integer>[] map =new HashMap[N+1];
        for(int i=1;i<=N;i++)
            map[i] = new HashMap<Integer,Integer>();
        for(int i=0;i<road.length;i++){
            int a = road[i][0];
            int b = road[i][1];
            int time = road[i][2];
            if(!map[a].containsKey(b) || map[a].get(b) > time)
                map[a].put(b,time);
            if(!map[b].containsKey(a) || map[b].get(a) > time)
                map[b].put(a,time);
        }
        
        int[] dist = new int[N+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[1] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((e1,e2)->{
            return e1[1]-e2[1];
        });
        pq.add(new int[]{1,0});
        
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int curIdx = cur[0];            
            int nowDist = cur[1];
            if(nowDist > dist[curIdx]) continue;
            for(int next : map[curIdx].keySet()){
                if(dist[next] > map[curIdx].get(next) + dist[curIdx]){
                    dist[next] = map[curIdx].get(next) + dist[curIdx];
                    pq.add(new int[]{next,dist[next]});
                }
            }
        }
        int answer = 0 ;
        for(int i:dist)
            if(i<=K)
                answer++;
        return answer;
    }
}