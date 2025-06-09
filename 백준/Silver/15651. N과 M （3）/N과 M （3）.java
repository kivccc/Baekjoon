import java.util.*;
import java.io.*;
public class Main {
    public static StringBuilder sb=new StringBuilder();
    public static int[]arr;
    public static int[]result;
    public static int n;
    public static int m;
	public static void main(String[] args) throws IOException {
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        m=sc.nextInt();
        arr=new int[n];
        result=new int[m];
        for(int i=0;i<n;i++){
            arr[i]=i+1;
        }
        dfs(0);
        System.out.println(sb);
	}
    public static void dfs(int depth){
        if(depth==m){
            for(int i=0;i<m;i++)
                sb.append(result[i]).append(" ");
            sb.append("\n");
            return;
        }
        
        for(int i=0;i<n;i++){
            result[depth]=arr[i];
            dfs(depth+1);
        }
    }
}