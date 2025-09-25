import java.util.*;
import java.io.*;
public class Main {
    static class Node{
        int idx;
        int dist;
        Node(int idx,int dist){
            this.idx = idx;
            this.dist = dist;
        }
    }
    static ArrayList<Node>[] graph;
    static boolean[] visited;
    static int v;
    static int farNode; 
    static int maxDist; 
	public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        v = Integer.parseInt(br.readLine());
        graph = new ArrayList[v+1];
        for(int i=0;i<=v;i++)
            graph[i]=new ArrayList<Node>();
        
        
        
        for(int i=0;i<v;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            while(true){
                int to = Integer.parseInt(st.nextToken());
                if(to == -1)
                    break;
                int dist = Integer.parseInt(st.nextToken());
                graph[from].add(new Node(to,dist));
            }
        }

        visited = new boolean[v+1];
        maxDist = 0;
        dfs(1,0);
        
        visited = new boolean[v+1];
        maxDist = 0;
        dfs(farNode,0);
        System.out.println(maxDist);
        
        //
        //Scanner sc = new Scanner(System.in);
        //int n = sc.nextInt();
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	}
    
    
    
    static void dfs(int idx,int dist){
        visited[idx]=true;
        if (dist > maxDist) {
            maxDist = dist;
            farNode = idx;
        }
        for(Node next:graph[idx]){
            if(!visited[next.idx]){
                dfs(next.idx,dist+next.dist);
            }
        }
        
    }
}