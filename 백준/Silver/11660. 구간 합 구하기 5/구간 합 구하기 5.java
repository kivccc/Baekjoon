import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] in=br.readLine().split(" ");
        int N=Integer.parseInt(in[0]);
        int M=Integer.parseInt(in[1]);
        int[] tmp=new int[N+1];
        int[][] dp=new int[N+1][N+1];
        for(int i=1;i<=N;i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            for(int j=1;j<=N;j++){
                tmp[j]+=Integer.parseInt(st.nextToken());
                dp[i][j]=dp[i][j-1]+tmp[j];
            }
        }
        for(int i=0;i<M;i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            int[] val=new int[4]; // x1 y1 x2 y2
            for(int j=0;j<4;j++){
                val[j]=Integer.parseInt(st.nextToken());
            }
            int sum=dp[val[2]][val[3]]-dp[val[0]-1][val[3]]-dp[val[2]][val[1]-1]+dp[val[0]-1][val[1]-1];
            System.out.println(sum);
        } 
        //StringTokenizer st=new StringTokenizer(br.readLine());
        //int N=Integer.parseInt(st.nextToken());
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	}
}