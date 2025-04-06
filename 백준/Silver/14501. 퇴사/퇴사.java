import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        int[][] arr=new int[N][2];
        int[] dp= new int[N+1];
        for(int i=0;i<N;i++){
            String[] s=br.readLine().split(" ");
            arr[i][0]=Integer.parseInt(s[0]);
            arr[i][1]=Integer.parseInt(s[1]);
        }
        int max=0;
        for(int i=0;i<N;i++){
            if(arr[i][0]+i<=N){
                max=Math.max(max,dp[i]);
                dp[arr[i][0]+i]=Math.max(dp[arr[i][0]+i],arr[i][1]+max);      
            }
            else{
                dp[i+1]=Math.max(dp[i+1],dp[i]);
            }
        }
        System.out.println(dp[N]);
        
        //StringTokenizer st=new StringTokenizer(br.readLine());
        //int N=Integer.parseInt(st.nextToken());
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	}
}