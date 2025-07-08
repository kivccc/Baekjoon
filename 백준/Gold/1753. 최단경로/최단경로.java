import java.util.*;
import java.io.*;
public class Main {
    public static class Node{
        int to;
        int weight;
        public Node(int to,int weight){
            this.to=to;
            this.weight=weight;
        }
    }
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int v=Integer.parseInt(st.nextToken());
        int e=Integer.parseInt(st.nextToken());
        int start=Integer.parseInt(br.readLine());
        ArrayList<Node>[] graph=new ArrayList[v+1];
        for(int i=1;i<=v;i++)
            graph[i]=new ArrayList<Node>();
        
        for(int i=0;i<e;i++){
            st=new StringTokenizer(br.readLine());
            int from=Integer.parseInt(st.nextToken());
            int to=Integer.parseInt(st.nextToken());
            int weight=Integer.parseInt(st.nextToken());
            graph[from].add(new Node(to,weight));
        }
        int[] dist=new int[v+1];
        for(int i=1;i<=v;i++)
            dist[i]=Integer.MAX_VALUE;
        dist[start]=0;
        PriorityQueue<Node>pq=new PriorityQueue<>((e1,e2)->{
            return e1.weight-e2.weight;
        });
        pq.add(new Node(start,0));
        
        while(!pq.isEmpty()){
            Node cur=pq.poll();
            int now=cur.to;
            int nowdist=cur.weight;
            if(nowdist>dist[now]) continue;
            for(Node next:graph[now]){
                if(dist[next.to]>dist[now]+next.weight){
                    dist[next.to]=dist[now]+next.weight;
                    pq.add(new Node(next.to,dist[next.to]));
                }
            }
            
        }
        StringBuilder sb=new StringBuilder();
        for(int i=1;i<=v;i++){
            int t=dist[i];
            if(t==Integer.MAX_VALUE)
                sb.append("INF").append("\n");
            else
                sb.append(t).append("\n");
        }
        System.out.println(sb);
        
	}
}