import java.util.*;
import java.io.*;
public class Main {
    public static class Node{
        int to;
        int cow;
        public Node(int to,int cow){
            this.to=to;
            this.cow=cow;
        }
    }
	public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());
        ArrayList<Node>[] graph=new ArrayList[n+1];
        for(int i=1;i<=n;i++)
            graph[i]=new ArrayList<Node>();
        for(int i=0;i<m;i++){
            st=new StringTokenizer(br.readLine());
            int from=Integer.parseInt(st.nextToken());
            int to=Integer.parseInt(st.nextToken());
            int cow=Integer.parseInt(st.nextToken());
            graph[from].add(new Node(to,cow));
            graph[to].add(new Node(from,cow));
        }
        int[] cows=new int[n+1];
        for(int i=1;i<=n;i++)
            cows[i]=Integer.MAX_VALUE;
        PriorityQueue<Node>pq=new PriorityQueue<>((e1,e2)->{
            return e1.cow-e2.cow;
        });
        pq.add(new Node(1,0));
        cows[1]=0;
        while(!pq.isEmpty()){
            Node cur=pq.poll();
            int now=cur.to;
            int nowcow=cur.cow;
            if(nowcow>cows[now]) continue;
            for(Node next:graph[now]){
                if(cows[next.to]>cows[now]+next.cow){
                    cows[next.to]=cows[now]+next.cow;
                    pq.add(new Node(next.to,cows[next.to]));
                }
            }
        }
        System.out.println(cows[n]);        

        //int n=Integer.parseInt(br.readLine());
        //Scanner sc=new Scanner(System.in);
        //int n=sc.nextInt();
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	}
}