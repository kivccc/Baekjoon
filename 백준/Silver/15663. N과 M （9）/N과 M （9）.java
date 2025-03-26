import java.util.*;
import java.io.*;
public class Main {
    public static int N;
    public static int M;
    public static int[] arr;
    public static int[] ans;
    public static boolean[] visit;
    public static StringBuilder sb=new StringBuilder();
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        arr=new int[N];
        visit=new boolean[N];
        ans=new int[M];
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        dfs(0);
        System.out.println(sb);
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	}
    
    public static void dfs(int dep){
        if(dep==M){
            for(int val:ans)
                sb.append(val).append(" ");
            sb.append("\n");
            return;
        }
        int before=0;
        for(int i=0;i<N;i++){
            if(!visit[i]){
                if(before!=arr[i]){
                    visit[i]=true;
                    before=arr[i];
                    ans[dep]=arr[i];
                    dfs(dep+1);    
                    visit[i]=false;    
                }
            }
            
        }
        
    }
}