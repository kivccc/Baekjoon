import java.util.*;
import java.io.*;
public class Main {
    public static class Node{
        int index;
        int cost;
        public Node(int index,int cost){
            this.index=index;
            this.cost=cost;
        }
    }
    public static ArrayList<Node>[] graph;
    public static int[] dist;
    public static int N;
    
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());
        int M=Integer.parseInt(br.readLine());
        graph=new ArrayList[N+1];
        for(int i=1;i<=N;i++)
            graph[i]=new ArrayList<>();
        for(int i=0;i<M;i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            int from=Integer.parseInt(st.nextToken());        
            int to=Integer.parseInt(st.nextToken());        
            int cost=Integer.parseInt(st.nextToken());
            graph[from].add(new Node(to,cost));
        }
        StringTokenizer st=new StringTokenizer(br.readLine());
        int start=Integer.parseInt(st.nextToken());
        int end=Integer.parseInt(st.nextToken());
        dijk(start,end);
        System.out.println(dist[end]);
        //int N=Integer.parseInt(br.readLine());
        //Scanner sc=new Scanner(System.in);
        //int N=sc.nextInt();
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	}
    public static void dijk(int start,int end){
        boolean[] visit=new boolean[N+1];
        dist=new int[N+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[start]=0;
        PriorityQueue<Node> pq=new PriorityQueue<>((e1,e2)->{
            return Integer.compare(e1.cost,e2.cost);
        });
        pq.add(new Node(start,0));
        while(!pq.isEmpty()){
            Node curnode=pq.poll();
            int curidx=curnode.index;
            if(curidx==end) break;
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