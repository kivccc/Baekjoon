import java.util.*;
import java.io.*;
public class Main {
    public static class Node{
        int idx;
        int cost;
        public Node(int idx,int cost){
            this.idx=idx;
            this.cost=cost;
        }
    }
    public static int n;
    public static int m;
    public static ArrayList<Node>[] graph;
    public static int[] dist;
    public static int start;
    public static int end;
    
	public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(br.readLine());
        m=Integer.parseInt(br.readLine());
        graph=new ArrayList[n+1];
        dist=new int[n+1];
        for(int i=1;i<=n;i++){
            dist[i]=1000000000;
            graph[i]=new ArrayList<>();
        }
        for(int i=0;i<m;i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            int from=Integer.parseInt(st.nextToken());
            int to=Integer.parseInt(st.nextToken());
            int cost=Integer.parseInt(st.nextToken());
            graph[from].add(new Node(to,cost));
        }
        
        StringTokenizer st=new StringTokenizer(br.readLine());
        start=Integer.parseInt(st.nextToken());
        end=Integer.parseInt(st.nextToken());
        
        dijk();
	}
    public static void dijk(){
        int[] prev=new int[n+1]; 
        Arrays.fill(prev,-1);
        PriorityQueue<Node> pq=new PriorityQueue<>((e1,e2)->{
            return Integer.compare(e1.cost,e2.cost);
        });
        dist[start]=0;
        pq.add(new Node(start,0));
        while(!pq.isEmpty()){
            Node now=pq.poll();
            int nowidx=now.idx;
            int nowcost=now.cost;
            if (dist[nowidx] < nowcost) continue;
            for(Node to:graph[nowidx]){
                if(dist[to.idx]>dist[nowidx]+to.cost){
                    dist[to.idx]=dist[nowidx]+to.cost;
                    prev[to.idx]=nowidx;
                    pq.add(new Node(to.idx,dist[to.idx]));
                }
            }
        }
        System.out.println(dist[end]);
        ArrayList<Integer> path=new ArrayList<>();
        for(int i=end;i!=-1;i=prev[i])
            path.add(i);
        StringBuilder sb=new StringBuilder();
        for(int i=path.size()-1;i>=0;i--)
            sb.append(path.get(i)).append(" ");
        System.out.println(path.size());
        System.out.println(sb);
    }
}