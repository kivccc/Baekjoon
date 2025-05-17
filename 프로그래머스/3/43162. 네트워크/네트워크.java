import java.util.*;
class Solution {
    // 1 1 0
    // 1 1 0
    // 0 0 1
    public boolean[] visit;
    public int answer=0;
    public int solution(int n, int[][] computers) {
        visit=new boolean[n];
        for(int i=0;i<n;i++){
            if(!visit[i]){
                answer++;
                bfs(i,n,computers);
            }
        }
        return answer;
    }
    public void bfs(int start,int n,int[][] computers){
        Deque<Integer> q=new ArrayDeque<>();
        q.add(start);
        visit[start]=true;
        while(!q.isEmpty()){
            int val=q.poll();
            for(int i=0;i<n;i++){
                if(val==i) continue;
                if(computers[val][i]==1 && !visit[i]){
                    q.add(i);
                    visit[i]=true;
                }
            }
        }
    }
}