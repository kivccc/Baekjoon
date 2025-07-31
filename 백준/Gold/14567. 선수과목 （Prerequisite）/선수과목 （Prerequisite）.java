import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());
        ArrayList<ArrayList<Integer>> graph=new ArrayList<>();
        for(int i=0;i<=n;i++){
            graph.add(new ArrayList<>());
        }
        int[] indegree=new int[n+1];
        for(int i=0;i<m;i++){
            st=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            indegree[b]++;
        }
        Deque<int[]> q=new ArrayDeque<>();
        for(int i=1;i<=n;i++)
            if(indegree[i]==0)
                q.add(new int[]{i,1});
        int[] answer=new int[n+1];
        while(!q.isEmpty()){
            int[] cur=q.poll();
            answer[cur[0]]=cur[1];
            
            for(int next:graph.get(cur[0])){
                indegree[next]--;
                if(indegree[next]==0)
                    q.add(new int[]{next,cur[1]+1});
            }
        }
        StringBuilder sb=new StringBuilder();
        for(int i=1;i<=n;i++)
            sb.append(answer[i]).append(" ");
        System.out.println(sb);
        //int n=Integer.parseInt(br.readLine());
        //Scanner sc=new Scanner(System.in);
        //int n=sc.nextInt();
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	}
}