import java.util.*;
import java.io.*;
public class Main {
    public static class Node{
        int index;
        int distance;
        public Node(int idx,int dist){
            index=idx;
            distance=dist;
        }
    }
    public static int N;    
    public static int mid1;    
    public static int mid2;   
    public static ArrayList<Node>[] graph;
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());        
        int E=Integer.parseInt(st.nextToken());        
        graph=new ArrayList[N+1];
        for(int i=1;i<=N;i++){
            graph[i]=new ArrayList<Node>();
        }
        for(int i=0;i<E;i++){
            st=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());        
            int b=Integer.parseInt(st.nextToken());        
            int c=Integer.parseInt(st.nextToken());        
            graph[a].add(new Node(b,c));
            graph[b].add(new Node(a,c));
        }
        st=new StringTokenizer(br.readLine());
        int v1=Integer.parseInt(st.nextToken());       
        int v2=Integer.parseInt(st.nextToken());
        int[] startarr=dijk(1);
        int[] v1arr=dijk(v1);
        int[] v2arr=dijk(v2);
        int INF=Integer.MAX_VALUE;
        int a1=Integer.MAX_VALUE;
        int a2=Integer.MAX_VALUE;
        if( startarr[v1]!=INF && v1arr[v2]!=INF && v2arr[N]!=INF)
            a1=startarr[v1]+v1arr[v2]+v2arr[N];
        if( startarr[v2]!=INF && v2arr[v1]!=INF && v1arr[N]!=INF)
            a2=startarr[v2]+v2arr[v1]+v1arr[N];
        int answer=Math.min(a1,a2);
        if(answer!=Integer.MAX_VALUE)
            System.out.println(answer);
        else
            System.out.println("-1");
        //int N=Integer.parseInt(br.readLine());
        //Scanner sc=new Scanner(System.in);
        //int N=sc.nextInt();
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	}
    public static int[] dijk(int start){
        boolean[] visit=new boolean[N+1];
        int[] dist=new int[N+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        PriorityQueue<Node> pq=new PriorityQueue<>((e1,e2)->{
            return Integer.compare(e1.distance,e2.distance);
        });
        pq.add(new Node(start,0));
        dist[start]=0;
        
        while(!pq.isEmpty()){
            Node curnode=pq.poll();
            int curidx=curnode.index;
            int curdist=curnode.distance;
            if(visit[curidx]) continue;
            visit[curidx]=true;
            for(Node next:graph[curidx]){
                if(dist[next.index]>curdist+next.distance){
                    dist[next.index]=curdist+next.distance;
                    pq.add(new Node(next.index,dist[next.index]));
                }
            }
        }
        return dist;
    }
}