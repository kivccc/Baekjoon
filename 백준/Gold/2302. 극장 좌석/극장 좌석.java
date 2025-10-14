import java.util.*;
import java.io.*;
public class Main {
    static boolean[] vip;
    static int[] dp;
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        dp = new int[41];
        
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for(int i=3;i<=n;i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        
        vip = new boolean[n+2];
        vip[0] = true;
        vip[n+1] = true;
        for(int i=0;i<m;i++){
            int idx = Integer.parseInt(br.readLine());
            vip[idx] = true;
        }
        long answer = 1;
        int count = 0;
        for(int i=0;i<=n+1;i++){
            if(vip[i]){
                if(count != 0){
                    answer *= dp[count];
                }
                count = 0;
            }
            else
            {
                count++;
            }
        }
        System.out.println(answer);
        
        //
        //Scanner sc = new Scanner(System.in);
        //int n = sc.nextInt();
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	}
}