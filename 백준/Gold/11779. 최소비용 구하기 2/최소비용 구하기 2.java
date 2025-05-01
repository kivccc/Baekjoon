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
    public static int n;
    public static int m;
    public static ArrayList<Node>[] graph;
    public static int[] answer;
    public static int start;
    public static int end;
	public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(br.readLine());
        graph=new ArrayList[n+1];
        for(int i=1;i<=n;i++)
            graph[i]=new ArrayList<>();
        answer=new int[n+1];
        m=Integer.parseInt(br.readLine());
        for(int i=0;i<m;i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            int c=Integer.parseInt(st.nextToken());
            graph[a].add(new Node(b,c));
        }
        StringTokenizer st=new StringTokenizer(br.readLine());
        start=Integer.parseInt(st.nextToken());
        end=Integer.parseInt(st.nextToken());
        StringBuilder sb=new StringBuilder();
        sb.append(dijk(start)).append("\n");
        Stack<Integer> path=new Stack<>();
        int cur=end;
        while(cur!=-1){
            path.push(cur);
            cur=answer[cur];
        }
        sb.append(path.size()).append("\n");
        while(!path.isEmpty())
            sb.append(path.pop()).append(" ");
        System.out.println(sb);
        //
        //Scanner sc=new Scanner(System.in);
        //int N=sc.nextInt();
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	}
    
    public static int dijk(int start){
        int[] distance=new int[n+1];
        for(int i=1;i<=n;i++){
            distance[i]=1000000000;
            answer[i]=-1;
        }
        distance[start]=0;
        PriorityQueue<Node> pq=new PriorityQueue<>((e1,e2)->{
            return e1.dist-e2.dist;
        });
        
        pq.add(new Node(start,0));
        
        while(!pq.isEmpty()){
            Node now=pq.poll();
            if(distance[now.idx]<now.dist)
                continue;
            for(Node next:graph[now.idx]){
                if(distance[now.idx]+next.dist<distance[next.idx]){
                    answer[next.idx]=now.idx;
                    distance[next.idx]=distance[now.idx]+next.dist;
                    pq.add(new Node(next.idx,distance[next.idx]));
                }
            }
        }
        return distance[end];
    }
}