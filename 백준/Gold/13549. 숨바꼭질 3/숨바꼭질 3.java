import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        int K=Integer.parseInt(st.nextToken());
        int min=Math.max(N,K);
        int[] dp=new int[min*2+1]; //0~34
        Deque<Integer>q=new ArrayDeque<>();
        q.add(N);
        dp[N]=1;
        while(!q.isEmpty()){
            int point=q.poll();
            if(point==K){
                System.out.println(dp[point]-1);
                return;
            }
            if(point*2<=min*2 && dp[point*2]==0){
               dp[point*2]=dp[point];
               q.add(point*2);
            }
            if(point-1>=0 && dp[point-1]==0){
               dp[point-1]=dp[point]+1;
               q.add(point-1);
            }
            if(point+1<=min*2 && dp[point+1]==0){
               dp[point+1]=dp[point]+1;
               q.add(point+1);
            }
        }
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	}
}