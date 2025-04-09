import java.util.*;
import java.io.*;
public class Main {
    public static int N;
    public static int M;
    public static int[] ans;
    public static boolean[] visited;
    public static int[] arr;
    public static StringBuilder sb=new StringBuilder();
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        arr=new int[N];
        visited=new boolean[N];
        ans=new int[M];
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        dfs(0,0);
        System.out.println(sb);
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	}
    public static void dfs(int depth,int index){
        if(depth==M){
            for(int i:ans)
                sb.append(i).append(" ");
            sb.append("\n");
            return;
        }
        int before=-1;
        for(int i=index;i<N;i++){
            if(visited[i] || before==arr[i])
                continue;
            before=arr[i];
            visited[i]=true;
            ans[depth]=arr[i];
            dfs(depth+1,i+1);       
            visited[i]=false;
        }
    }
}