import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int val = 10007;
        //StringTokenizer st = new StringTokenizer(br.readLine());
        //int n = Integer.parseInt(st.nextToken());
        int[] dp = new int[10];
        Arrays.fill(dp,1);
        //1 1~9 2 2~8 
        for(int i=1;i<n;i++){
            int[] tmp = new int[10];
            tmp[0] = 1;
            for(int j=1;j<=9;j++){
                tmp[j] = dp[j] + tmp[j-1];
                tmp[j] %=val;
            }            
            dp = tmp;
        }
        int answer = 0;
        for(int i:dp){
            answer += i;
            answer %= val;
        }
        System.out.println(answer);
        /*
        for(int i=0;i<n;i++){
        
        }
        */
        

        //
        //Scanner sc = new Scanner(System.in);
        //int n = sc.nextInt();
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	}
}