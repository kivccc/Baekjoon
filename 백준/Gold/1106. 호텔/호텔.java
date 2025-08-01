import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int c = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n+1][2];
        int len=11*99;
        int[] dp = new int[len+1];
        int max=1000000;
        Arrays.fill(dp,max);
        dp[0]=0;
        for(int i=1;i<=n;i++){
            st = new StringTokenizer(br.readLine());
            int cost = Integer.parseInt(st.nextToken());
            int earn = Integer.parseInt(st.nextToken());
            arr[i][0] = cost;
            arr[i][1] = earn;
        }
        
        for(int i=1;i<=n;i++){
            for(int v=arr[i][1];v<=len;v++){
                dp[v]=Math.min(dp[v],dp[v-arr[i][1]]+arr[i][0]);
            }
        }
        int answer=1000000;
        for(int i=c;i<=len;i++){
            answer=Math.min(answer,dp[i]);
        }
        System.out.println(answer);

        //int n=Integer.parseInt(br.readLine());
        //Scanner sc=new Scanner(System.in);
        //int n=sc.nextInt();
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	}
}