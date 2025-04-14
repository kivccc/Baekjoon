import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
	    int N=Integer.parseInt(st.nextToken());
	    int K=Integer.parseInt(st.nextToken()); //버틸수 있는 무게 K
        int[][] arr=new int[N+1][2]; // 무게 W 가치 V
        int[] dp=new int[K+1]; //1~K
        for(int i=1;i<=N;i++){
            st=new StringTokenizer(br.readLine());
            arr[i][0]=Integer.parseInt(st.nextToken());
            arr[i][1]=Integer.parseInt(st.nextToken());
        }
        
        for(int i=1;i<=N;i++){
            int w=arr[i][0];
            int v=arr[i][1];
            
            for(int j=K;j>=w;j--){
                dp[j]=Math.max(dp[j],dp[j-w]+v);
            }
        }
        System.out.println(dp[K]);
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	}
}
