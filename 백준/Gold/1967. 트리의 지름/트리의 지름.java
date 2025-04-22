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
    public static int startidx;    
    public static int result;    
    public static ArrayList<Node>[] graph;
    public static boolean[] visit;
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());        
        graph=new ArrayList[N+1];
        for(int i=1;i<=N;i++){
            graph[i]=new ArrayList<Node>();
        }
        for(int i=0;i<N-1;i++){
            st=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());        
            int b=Integer.parseInt(st.nextToken());        
            int c=Integer.parseInt(st.nextToken());        
            graph[a].add(new Node(b,c));
            graph[b].add(new Node(a,c));
        }
        visit=new boolean[N+1];
        visit[1]=true;
        dfs(1,0);
        
        visit=new boolean[N+1];
        visit[startidx]=true;
        dfs(startidx,0);
        System.out.println(result);
        //int N=Integer.parseInt(br.readLine());
        //Scanner sc=new Scanner(System.in);
        //int N=sc.nextInt();
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	}
    public static void dfs(int start,int count){
        result=Math.max(count,result);
        if(count==result){
            startidx=start;
        }
        
        for(Node node:graph[start]){
            int idx=node.index;
            int dist=node.distance;
            
            if(visit[idx]) continue;
            
            visit[idx]=true;
            dfs(idx,count+dist);
            visit[idx]=false;
        }
    }
}