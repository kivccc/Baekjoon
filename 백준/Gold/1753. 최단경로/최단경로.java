import java.util.*;
import java.io.*;
public class Main {
    public static class Node{
        public int index;
        public int cost;
        public Node(int index,int cost){
            this.index=index;
            this.cost=cost;
        }
    }
    public static ArrayList<Node>[] graph;
    public static int[] dist;
    public static int V;
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        V=Integer.parseInt(st.nextToken());    // 정점의 개수 1 ~ V 번 
        int E=Integer.parseInt(st.nextToken());    // 간선의 개수
        int start=Integer.parseInt(br.readLine());    //시작 정점
        graph=new ArrayList[V+1];
        for(int i=0;i<V;i++){
            graph[i+1]=new ArrayList<>();
        }
        for(int i=0;i<E;i++){
            st=new StringTokenizer(br.readLine());
            int u=Integer.parseInt(st.nextToken());
            int v=Integer.parseInt(st.nextToken());
            int w=Integer.parseInt(st.nextToken());
            graph[u].add(new Node(v,w));
        }
        dijk(start);
        StringBuilder sb=new StringBuilder();
        for(int i=1;i<=V;i++){
            int val=dist[i];
            if(val==Integer.MAX_VALUE)
                sb.append("INF").append("\n");
            else
                sb.append(val).append("\n");
        }
        System.out.println(sb);
        //int N=Integer.parseInt(br.readLine());
        //Scanner sc=new Scanner(System.in);
        //int N=sc.nextInt();
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	}
    
    public static void dijk(int start){
        boolean[] visit=new boolean[V+1]; //방문 체크용
        dist=new int[V+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[start]=0;
        
        PriorityQueue<Node> pq=new PriorityQueue<>((e1,e2)->{
            return Integer.compare(e1.cost,e2.cost);
        });
        pq.add(new Node(start,0));
        
        while(!pq.isEmpty()){
            Node node=pq.poll();
            int curidx=node.index;
            
            if(visit[curidx]) continue;
            visit[curidx]=true;
            
            for(Node nextnode:graph[curidx]){
                int nextidx=nextnode.index;
                int nextcost=nextnode.cost;
                if(dist[nextidx]>dist[curidx]+nextcost){
                    dist[nextidx]=dist[curidx]+nextcost;
                    pq.add(new Node(nextidx,dist[nextidx]));
                }
            }
        }
    }
}