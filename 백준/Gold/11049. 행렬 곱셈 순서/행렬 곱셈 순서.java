import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
        
        
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int[] arr = new int[n+1];
        
		StringTokenizer st = null;
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[i] = a; 
            arr[i+1] = b;
		}
		
		int[][] dp = new int[n][n];
		
		for(int i=2; i<n+1; i++) { 
			for(int j=0; j<n-i+1; j++) { 
				dp[j][j+i-1] = Integer.MAX_VALUE;
				for(int k=j; k<j+i-1; k++) { 
					int value = dp[j][k];
                    value+= dp[k+1][j+i-1];
                    value+= (arr[j]*arr[k+1]*arr[j+i]);
					dp[j][j+i-1] = Math.min(dp[j][j+i-1], value);
				}
			}
		}
		System.out.println(dp[0][n-1]);
		
	}
}