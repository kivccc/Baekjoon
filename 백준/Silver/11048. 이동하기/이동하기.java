import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int y=Integer.parseInt(st.nextToken());
        int x=Integer.parseInt(st.nextToken());
        int[][]arr=new int[y+1][x+1];
        int[][]dp=new int[y+1][x+1];
        for(int i=1;i<=y;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=1;j<=x;j++){
                arr[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        for(int i=1;i<=y;i++){
            for(int j=1;j<=x;j++){
                dp[i][j]=Math.max(dp[i-1][j-1],Math.max(dp[i-1][j],dp[i][j-1]))+arr[i][j];
            }
        }
        System.out.println(dp[y][x]);

        //int N=Integer.parseInt(br.readLine());
        //Scanner sc=new Scanner(System.in);
        //int N=sc.nextInt();
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	}
}