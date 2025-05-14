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
    public static int V;
    public static int E;
    public static int start;
    public static int[] dist;
    public static ArrayList<Node>[] graph;
	public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st=new StringTokenizer(br.readLine());
        V=Integer.parseInt(st.nextToken());        
        E=Integer.parseInt(st.nextToken());    
        dist=new int[V+1];
        for(int i=0;i<=V;i++)
            dist[i]=Integer.MAX_VALUE;
        graph=new ArrayList[V+1];
        for(int i=0;i<V;i++){
            graph[i+1]=new ArrayList<>();
        }
        start=Integer.parseInt(br.readLine());
        
        for(int i=0;i<E;i++){
            st=new StringTokenizer(br.readLine());
            int from=Integer.parseInt(st.nextToken());        
            int to=Integer.parseInt(st.nextToken());        
            int weight=Integer.parseInt(st.nextToken());        
            graph[from].add(new Node(to,weight));
        }
        dijk();
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
    public static void dijk(){
        PriorityQueue<Node> q=new PriorityQueue<>((e1,e2)->{
            return Integer.compare(e1.weight,e2.weight);
        });
        
        q.add(new Node(start,0));
        dist[start]=0;
        
        while(!q.isEmpty()){
            Node cur=q.poll();
            int now=cur.to;
            int nowdist=cur.weight;
            if(nowdist>dist[now]) continue;
            
            for(Node next:graph[now]){
                if(dist[next.to]>dist[now]+next.weight){
                    dist[next.to]=dist[now]+next.weight;
                    q.add(new Node(next.to,dist[next.to]));
                }
            }
        }
    }
}