import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        //StringTokenizer st=new StringTokenizer(br.readLine());
        //int N=Integer.parseInt(st.nextToken());        

        for(int tc=0;tc<t;tc++){
            int n=Integer.parseInt(br.readLine());
            int[]arr=new int[n+1];
            
            StringTokenizer st=new StringTokenizer(br.readLine());
            for(int j=1;j<=n;j++){
                arr[j]=Integer.parseInt(st.nextToken());
            }
            int m=Integer.parseInt(br.readLine());
            int[]dp=new int[m+1];
            dp[0]=1;
            for(int i=1;i<=n;i++){
                int coin=arr[i];
                for(int j=coin;j<=m;j++)
                    dp[j]+=dp[j-coin];           
            }
            System.out.println(dp[m]);
        }
        

        //Scanner sc=new Scanner(System.in);
        //int N=sc.nextInt();
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	}
}