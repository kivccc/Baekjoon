import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        
        StringTokenizer st=new StringTokenizer(br.readLine());
        int[] arr=new int[n+1];
        for(int i=1;i<=n;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }
        
        boolean[][] dp=new boolean[n+1][n+1];
        
        int m=Integer.parseInt(br.readLine());
        
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<m;i++){
            st=new StringTokenizer(br.readLine());
            int start=Integer.parseInt(st.nextToken());
            int end=Integer.parseInt(st.nextToken());
            if(arr[start]!=arr[end]){
                sb.append(0).append("\n");
                continue;
            }
            
            int left=start+1;
            int right=end-1;
            boolean flag=true;
            while(left<=right){

                if(dp[left][right]) break;
                
                if(arr[left]!=arr[right]){
                    sb.append(0).append("\n");
                    flag=false;
                    break;
                }
                
                left++;
                right--;
            }
            if(flag){
                dp[start][end]=true;
                sb.append(1).append("\n");
            }
        }
        System.out.println(sb);
        

        //
        //Scanner sc=new Scanner(System.in);
        //int n=sc.nextInt();
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	}
}