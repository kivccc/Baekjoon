import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        int[] arr=new int[n];
        StringTokenizer st=new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }
        int[] dp=new int[n];
        int[] mem=new int[n];
        
        Arrays.fill(dp,1);
        Arrays.fill(mem,-1);
        for(int i=1;i<n;i++){
            // dp[i] 행
            int target=arr[i];
            int count=0;
            for(int j=0;j<=i;j++){
                if(arr[j]<target && dp[i]< dp[j]+1){
                    dp[i]=dp[j]+1;
                    mem[i]=j;
                }
            }
        }
        int len=0;
        int lastidx=0;
        for(int i=0;i<n;i++){
            if(len<dp[i]){
                len=dp[i];
                lastidx=i;
            }
        }
        System.out.println(len);
        StringBuilder sb=new StringBuilder();
        Deque<Integer> q=new ArrayDeque<>();
        while(lastidx!=-1){
            q.add(lastidx);
            lastidx=mem[lastidx];
        }
        while(!q.isEmpty())
            sb.append(arr[q.pollLast()]).append(" ");
        System.out.println(sb);
        //Scanner sc=new Scanner(System.in);
        //int n=sc.nextInt();
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	}
}