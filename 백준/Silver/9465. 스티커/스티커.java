import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(br.readLine());
        for(int i=0;i<T;i++){
            int N=Integer.parseInt(br.readLine());
            int[][] arr=new int[2][N+1];
            int[][] dp=new int[2][N+1];
            for(int j=0;j<2;j++){
                StringTokenizer st=new StringTokenizer(br.readLine());
                for(int k=1;k<=N;k++){
                    arr[j][k]=Integer.parseInt(st.nextToken());
                }
            }
            dp[0][1]=arr[0][1];
            dp[1][1]=arr[1][1];
            for(int k=2;k<=N;k++){
                dp[0][k]=Math.max(dp[1][k-2],dp[1][k-1])+arr[0][k];
                dp[1][k]=Math.max(dp[0][k-2],dp[0][k-1])+arr[1][k];
            }
            System.out.println(Math.max(dp[0][N],dp[1][N]));
        }
        //StringTokenizer st=new StringTokenizer(br.readLine());
        //int N=Integer.parseInt(st.nextToken());
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	}
}