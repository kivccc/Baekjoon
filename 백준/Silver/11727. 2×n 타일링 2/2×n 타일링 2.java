import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int[] dp = new int[N+1];
        dp[0] = 1;
        dp[1] = 3;
        for(int i=2;i<N;i++){
            dp[i]=(dp[i-1]+dp[i-2]*2)%10007;
        }
        System.out.println(dp[N-1]);
        //StringTokenizer st=new StringTokenizer(br.readLine());
        //int N=Integer.parseInt(st.nextToken());
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	}
}