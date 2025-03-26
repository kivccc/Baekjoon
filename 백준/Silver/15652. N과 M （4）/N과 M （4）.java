import java.util.*;
import java.io.*;
public class Main {
    public static int N;
    public static int M;
    public static int[] arr;
    public static StringBuilder sb=new StringBuilder();
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        arr=new int[M];
        dfs(1,0);
        System.out.println(sb);
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	}
    
    public static void dfs(int start,int dep){
        if(dep==M){
            for(int val:arr)
                sb.append(val).append(" ");
            sb.append("\n");
            return;
        }
        
        for(int i=start;i<=N;i++){
            arr[dep]=i;
            dfs(i,dep+1);
        }
        
    }
}