import java.util.*;
import java.io.*;
public class Main {
    static int[] arr;
    static boolean[] visited;
    static boolean[] finished;
    static int count;
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase=Integer.parseInt(br.readLine());
        StringBuilder sb=new StringBuilder();
        for(int tc=0;tc<testcase;tc++){
            int n=Integer.parseInt(br.readLine());
            arr=new int[n+1];
            StringTokenizer st=new StringTokenizer(br.readLine());
            
            for(int i=1;i<=n;i++){
                arr[i]=Integer.parseInt(st.nextToken());      
            }
            ArrayList<Integer> canTeam=new ArrayList<>();
            visited=new boolean[n+1];
            finished=new boolean[n+1];
            count=0;
            for(int i=1;i<=n;i++)
                if(!visited[i])
                    dfs(i);
                

            int answer=n-count;
            sb.append(answer).append("\n");
            
        }
        System.out.println(sb);

        //
        //Scanner sc=new Scanner(System.in);
        //int n=sc.nextInt();
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	}
    static void dfs(int cur){
        visited[cur] = true;
        int next = arr[cur];
        if(!visited[next]){
            dfs(next);
        }
        else if(!finished[next]){
            for(int i=next;i!=cur;i=arr[i])
                count++;
            count++;
        }
        finished[cur]=true;
    }
}