import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        ArrayList<ArrayList<Integer>> graph=new ArrayList<>();
        for(int i=0;i<=n;i++)
            graph.add(new ArrayList<Integer>());
        int[]indegree=new int[n+1];
        int[]timearr=new int[n+1];
        
        for(int i=1;i<=n;i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            int time=Integer.parseInt(st.nextToken());
            timearr[i]=time;
            int start=0;
            while( (start=Integer.parseInt(st.nextToken()))!=-1){
                graph.get(start).add(i);
                indegree[i]++;
            }
        }
        //System.out.println(graph);
        //System.out.println(Arrays.toString(indegree));
        Deque<Integer> q=new ArrayDeque<>();
        ArrayList<Integer> result=new ArrayList<>();
        int[]answer=new int[n+1];
        
        for(int i=1;i<=n;i++){
            if(indegree[i]==0){
                q.add(i);
                answer[i]=timearr[i];
            }
        }
        while(!q.isEmpty()){
            int cur=q.poll();
            result.add(cur);
            for(int i:graph.get(cur)){
                indegree[i]--;
                answer[i]=Math.max(answer[i],answer[cur]+timearr[i]);
                if(indegree[i]==0){
                    q.add(i);
                    //answer[i]=timearr[i]+timearr[cur];
                }
            }
        }
        StringBuilder sb=new StringBuilder();
        for(int i=1;i<=n;i++)
            sb.append(answer[i]).append("\n");
        System.out.println(sb);

        //
        //Scanner sc=new Scanner(System.in);
        //int n=sc.nextInt();
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	}
}