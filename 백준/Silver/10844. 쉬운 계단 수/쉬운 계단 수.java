import java.util.*;
import java.io.*;
public class Main {
    public static int[][]dp;
	public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        dp=new int[n+1][10];
        for(int i=1;i<=9;i++)
            dp[1][i]=1;
        
        for(int i=2;i<=n;i++){
            for(int j=0;j<=9;j++){
                if(j>0) dp[i][j]+=dp[i-1][j-1];
                if(j<9) dp[i][j]+=dp[i-1][j+1];
                dp[i][j]%=1000000000;
            }
        }
        long answer=0;
        for(int i=0;i<=9;i++){
            answer+=dp[n][i]%1000000000;
        }
        System.out.println(answer%1000000000);
	}

}