import java.util.*;
import java.io.*;
public class Main {
    public static class Node{
        int idx;
        int dist;
        public Node(int idx,int dist){
            this.idx=idx;
            this.dist=dist;
        }
    }
    public static int V;
    public static ArrayList<Node>[] graph;
    public static boolean[] visit;
    public static int maxdist=0;
    public static int startnode=0;
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        V=Integer.parseInt(br.readLine());
        graph=new ArrayList[V+1];
        for(int i=1;i<=V;i++){
            graph[i]=new ArrayList<Node>();
        }
        for(int i=1;i<=V;i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            int nodenum=Integer.parseInt(st.nextToken());
            int to;
            while((to=Integer.parseInt(st.nextToken()))!=-1){
                int dist=Integer.parseInt(st.nextToken());
                graph[nodenum].add(new Node(to,dist));
            }
        }
        /*
        for(int i=1;i<=V;i++){
            for(Node node:graph[i])
                System.out.println(node.idx+" "+node.dist);
        } 
        */
        visit=new boolean[V+1];
        dfs(1,0);
        visit=new boolean[V+1];
        maxdist=0;
        dfs(startnode,0);
        System.out.println(maxdist);
        //int N=Integer.parseInt(br.readLine());
        //Scanner sc=new Scanner(System.in);
        //int N=sc.nextInt();
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	}
    
    public static void dfs(int current,int distance){
        visit[current]=true;
        if(maxdist<distance){
            maxdist=distance;
            startnode=current;
        }
        for(Node node:graph[current]){
            if(!visit[node.idx]){
                dfs(node.idx,distance+node.dist);
            }
        }
          
    }
}