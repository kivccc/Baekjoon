import java.util.*;
import java.io.*;
public class Main {
    public static int N;
    public static int K;
    public static int len;
    public static int[] dist;
    public static int[] count;
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());        
        K=Integer.parseInt(st.nextToken());        
        len=Math.max(N,K)*2;
        dist=new int[len];
        count=new int[len];
        for(int i=0;i<len;i++)
            dist[i]=-1;
        bfs(N);
        System.out.println(dist[K]);
        System.out.println(count[K]);
        //int N=Integer.parseInt(br.readLine());
        //Scanner sc=new Scanner(System.in);
        //int N=sc.nextInt();
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	}
    
    public static void bfs(int start){
        Deque<Integer> q=new ArrayDeque<>();
        q.add(start);
        dist[start]=0;
        count[start]=1;
        
        while(!q.isEmpty()){
            int place=q.poll();
            int nextplace=place+1;
            check(place,nextplace,q);
            nextplace=place-1;
            check(place,nextplace,q);
            nextplace=place*2;
            check(place,nextplace,q);
        }
    }
    public static void check(int from,int to,Deque q){
        if(to<0 || len<=to)    return;
        if(dist[to]==-1){
            dist[to]=dist[from]+1;
            count[to]=count[from];
            q.add(to);
        }
        else if(dist[to]==dist[from]+1){
            count[to]+=count[from];
        }
        return;
    }
}