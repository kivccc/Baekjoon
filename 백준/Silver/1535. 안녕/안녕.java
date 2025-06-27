import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        int[] hp=new int[n];
        int[] point=new int[n];
        
        StringTokenizer st=new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            hp[i]=Integer.parseInt(st.nextToken());
        }
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            point[i]=Integer.parseInt(st.nextToken());
        }
        int[][]dp=new int[n+1][101];
        for(int i=1;i<=n;i++){
            for(int w=0;w<=100;w++){
                dp[i][w]=dp[i-1][w];
                if(hp[i-1]<=w)
                    dp[i][w]=Math.max(dp[i-1][w],dp[i-1][w-hp[i-1]]+point[i-1]);
            }
        }
        System.out.println(dp[n][99]);

        //int n=Integer.parseInt(br.readLine());
        //Scanner sc=new Scanner(System.in);
        //int n=sc.nextInt();
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	}
}