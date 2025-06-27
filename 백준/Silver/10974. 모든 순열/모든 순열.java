import java.util.*;
import java.io.*;
public class Main {
    public static int n;
    public static int[] arr;
    public static int[] mem;
    public static boolean[] visited;
    public static StringBuilder sb=new StringBuilder();
	public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(br.readLine());
        arr=new int[n];
        mem=new int[n];
        visited=new boolean[n];
        for(int i=0;i<n;i++){
            arr[i]=i+1;
        }
        dfs(0);
        System.out.println(sb);
	}
    public static void dfs(int depth){
        if(depth==n){
            for(int i=0;i<n;i++){
                sb.append(mem[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        
        for(int i=0;i<n;i++){
            if(!visited[i]){
                visited[i]=true;
                mem[depth]=arr[i];
                dfs(depth+1);
                visited[i]=false;;
            }
        }
    }
}