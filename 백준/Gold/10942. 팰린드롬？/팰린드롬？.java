import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=1; i<=n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        boolean[][] dp = new boolean[n+1][n+1];

        for (int i=1; i<=n; i++) 
            dp[i][i] = true;

        for (int i=1; i<n; i++) 
            if (arr[i] == arr[i+1]) dp[i][i+1] = true;

        for (int len=3; len<=n; len++) {
            for (int start=1; start+len-1<=n; start++) {
                int end = start+len-1;
                if (arr[start] == arr[end] && dp[start+1][end-1]) {
                    dp[start][end] = true;
                }
            }
        }

        int m = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            sb.append(dp[s][e] ? 1 : 0).append("\n");
        }
        System.out.print(sb);
    }
}
