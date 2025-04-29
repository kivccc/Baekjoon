import java.util.*;
import java.io.*;
public class Main {
    public static class Edge{
        int from;
        int to;
        int weight;
        public Edge(int from,int to,int weight){
            this.from=from;
            this.to=to;
            this.weight=weight;
        }
    }
    static int N,M,W;
    static ArrayList<Edge> edges;
	public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC=Integer.parseInt(br.readLine());
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<TC;i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            N=Integer.parseInt(st.nextToken());    //지점 수
            M=Integer.parseInt(st.nextToken());    //도로 개수 양방향
            W=Integer.parseInt(st.nextToken());    //웜홀 개수 단방향,음수가능
            edges=new ArrayList<>();
            for(int j=0;j<M;j++){
                st=new StringTokenizer(br.readLine());
                int S=Integer.parseInt(st.nextToken());
                int E=Integer.parseInt(st.nextToken());
                int T=Integer.parseInt(st.nextToken());    
                edges.add(new Edge(S,E,T));
                edges.add(new Edge(E,S,T));
            }
            for(int j=0;j<W;j++){
                st=new StringTokenizer(br.readLine());
                int S=Integer.parseInt(st.nextToken());
                int E=Integer.parseInt(st.nextToken());
                int T=Integer.parseInt(st.nextToken());    
                edges.add(new Edge(S,E,-T));
            }
            
            boolean flag=false;
            for(int j=1;j<=N;j++){
                if(bell(j)){
                    flag=true;
                    break;
                }
            }
            if(flag)
                sb.append("YES");
            else
                sb.append("NO");
            sb.append("\n");
        }
        System.out.println(sb);
        //int N=Integer.parseInt(br.readLine());
        //Scanner sc=new Scanner(System.in);
        //int N=sc.nextInt();
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	}
    
    public static boolean bell(int start){
        int[] dist=new int[N+1];
        Arrays.fill(dist,10001);
        dist[start]=0;
        for(int i=1;i<N;i++){
            boolean updated = false;
            for(Edge edge:edges){
                if(dist[edge.from]!=10001 && dist[edge.to]>dist[edge.from]+edge.weight){
                    dist[edge.to]=dist[edge.from]+edge.weight;
                    updated = true;
                }
            }
            if (!updated) break;
        }
        for(Edge edge:edges){
            if(dist[edge.from]!=10001 && dist[edge.to]>dist[edge.from]+edge.weight)
                return true;
        }
        return false;
    }
}