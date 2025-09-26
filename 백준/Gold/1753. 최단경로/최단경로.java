import java.util.*;
import java.io.*;
public class Main {
    static class Node{
        int to;
        int weight;
        Node(int to,int weight){
            this.to = to;
            this.weight = weight;
        }
    }
    
    
    static ArrayList<Node>[] graph;
    static int v;
    static int e;
    static int k;
    static int[] dist;
	public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(br.readLine());
        dist = new int[v+1];
        graph = new ArrayList[v+1];
        for(int i=0;i<=v;i++)
            graph[i] = new ArrayList<Node>();
        
        for(int i=0;i<e;i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[u].add(new Node(v,w));
        }
        dijk(k);
        //int n = Integer.parseInt(br.readLine());
        //Scanner sc = new Scanner(System.in);
        //int n = sc.nextInt();
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	}
    
    static void dijk(int start){
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[start] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>((e1,e2)->{
            return e1.weight-e2.weight;
        });
        pq.add(new Node(start,0));
        
        while(!pq.isEmpty()){
            Node cur = pq.poll();
            int now = cur.to;
            int nowDist = cur.weight;
            if(nowDist>dist[now]) continue;
            
            for(Node next: graph[cur.to]){
                if(dist[next.to] > dist[now] + next.weight){
                    dist[next.to] = dist[now] + next.weight;
                    pq.add(new Node(next.to, dist[next.to]));
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