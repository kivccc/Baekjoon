import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());
        
        ArrayList<ArrayList<Integer>> graph=new ArrayList<>();
        for(int i=0;i<=n;i++)
            graph.add(new ArrayList<>());
        int[] indegree=new int[n+1];
        for(int i=0;i<m;i++){
            st=new StringTokenizer(br.readLine());
            int from=Integer.parseInt(st.nextToken());
            int to=Integer.parseInt(st.nextToken());
            graph.get(from).add(to);
            indegree[to]++;
        }
        
        //Deque<Integer> q=new ArrayDeque<>();
        ArrayList<Integer>result=new ArrayList<>();
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int i=1;i<=n;i++){
            if(indegree[i]==0)
                pq.add(i);
        }
        while(!pq.isEmpty()){
            int cur=pq.poll();
            result.add(cur);
            
            for(int i:graph.get(cur)){
                indegree[i]--;
                if(indegree[i]==0)
                    pq.add(i);
            }
        }
        StringBuilder sb=new StringBuilder();
        for(int i:result)
            sb.append(i).append(" ");
        System.out.println(sb);
        //int n=Integer.parseInt(br.readLine());
        //Scanner sc=new Scanner(System.in);
        //int n=sc.nextInt();
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	}
}