import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        int[] dp=new int[n+1];
        if(n==1){
            System.out.println(1);
            return;
        }
        else if(n==2){
            System.out.println(2);
            return;
        }
        dp[1]=1;
        dp[2]=2;
        dp[3]=3;
        for(int i=4;i<=n;i++){
            dp[i]=(dp[i-1]+dp[i-2])%15746;
        }
        System.out.println(dp[n]);
        //StringTokenizer st=new StringTokenizer(br.readLine());
        //int n=Integer.parseInt(st.nextToken());

        /*
        for(int i=0;i<n;i++){
        
        }
        */
        

        //Scanner sc=new Scanner(System.in);
        //int n=sc.nextInt();
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	}
};