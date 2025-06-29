import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        int[] arr=new int[n];
        StringTokenizer st=new StringTokenizer(br.readLine());
        int[] dp=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }
        int max=0;
        int val=0;
        for(int i=0;i<n;i++){
            int tmax=0;
            for(int j=0;j<i;j++){
                if(arr[j]<arr[i])
                    tmax=Math.max(tmax,dp[j]);
            }
            dp[i]=tmax+arr[i];
            max=Math.max(max,dp[i]);
        }
        System.out.println(max);
        //
        //Scanner sc=new Scanner(System.in);
        //int n=sc.nextInt();
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	}
}