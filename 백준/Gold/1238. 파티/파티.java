import java.util.*;
import java.io.*;
public class Main {
    public static class Node{
        int idx;
        int dist;
        public  Node(int idx,int dist){
            this.idx=idx;
            this.dist=dist;
        }
    }
    public static int N;
    public static int M;
    public static int X;
    public static ArrayList<Node>[] graph;
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        X=Integer.parseInt(st.nextToken());
        graph=new ArrayList[N+1];
        for(int i=1;i<=N;i++)
            graph[i]=new ArrayList<>();
        for(int i=0;i<M;i++){
            st=new StringTokenizer(br.readLine());
            int from=Integer.parseInt(st.nextToken());
            int to=Integer.parseInt(st.nextToken());
            int dist=Integer.parseInt(st.nextToken());
            graph[from].add(new Node(to,dist));
        } 
        int[] backarr=dijk(X);
        int ans=Integer.MIN_VALUE;
        for(int i=1;i<=N;i++){
            int godist=dijk(i)[X];
            if(godist!=Integer.MAX_VALUE && backarr[i]!=Integer.MAX_VALUE )
                ans=Math.max(ans,godist+backarr[i]);
        }
        System.out.println(ans);
        //int N=Integer.parseInt(br.readLine());
        //Scanner sc=new Scanner(System.in);
        //int N=sc.nextInt();
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	}
    
    public static int[] dijk(int start){
        boolean[] visit=new boolean[N+1];
        int[] arr=new int[N+1];
        for(int i=1;i<=N;i++)
            arr[i]=Integer.MAX_VALUE;
        PriorityQueue<Node> q=new PriorityQueue<>((e1,e2)->{
            return e1.dist-e2.dist;
        });
        q.add(new Node(start,0));
        arr[start]=0;
        
        while(!q.isEmpty()){
            Node node=q.poll();
            int curidx=node.idx;
            int curdist=node.dist;
            if(visit[curidx]) continue;
            visit[curidx]=true;
            for(Node nextnode:graph[curidx]){
                if(arr[nextnode.idx]>arr[curidx]+nextnode.dist){
                    arr[nextnode.idx]=arr[curidx]+nextnode.dist;
                    q.add(new Node(nextnode.idx,arr[nextnode.idx]));
                }
            }
        }
        return arr;
    }
}