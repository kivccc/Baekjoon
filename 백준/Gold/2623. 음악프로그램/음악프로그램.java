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
            int t=Integer.parseInt(st.nextToken());
            int[]arr=new int[t];
            for(int j=0;j<t;j++){
                arr[j]=Integer.parseInt(st.nextToken());
            }
            //System.out.println(Arrays.toString(arr));
            
            for(int a=0;a<t;a++){
                int front=arr[a];
                for(int b=a+1;b<t;b++){
                    int back=arr[b];
                    graph.get(front).add(back);
                    indegree[back]++;
                }
            }
            
        }
        //System.out.println(graph);
        //System.out.println(Arrays.toString(indegree));
        
        
        Deque<Integer> q=new ArrayDeque<>();
        ArrayList<Integer> result=new ArrayList<>();
        for(int i=1;i<=n;i++)
            if(indegree[i]==0)
                q.add(i);
        boolean impossible=false;
        for(int i=0;i<n;i++){
            if(q.isEmpty()){
                impossible=true;
                break;
            }
            int cur=q.poll();
            result.add(cur);
            for(int next:graph.get(cur)){
                indegree[next]--;
                if(indegree[next]==0)
                    q.add(next);
            }
        }
        if(impossible){
            System.out.println(0);
        }
        else{
            StringBuilder sb=new StringBuilder();
            for(int i:result)
                sb.append(i).append("\n");
            System.out.println(sb);
        }
        //int n=Integer.parseInt(br.readLine());
        //Scanner sc=new Scanner(System.in);
        //int n=sc.nextInt();
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	}
}