import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line=br.readLine();
        int len=line.length(); // 7
        boolean[][]dp=new boolean[len][len]; //0~6
        
        for(int i=0;i<len;i++)
            dp[i][i]=true;
        
        for(int i=0;i<len-1;i++){
            if(line.charAt(i)==line.charAt(i+1))
                dp[i][i+1]=true;
        }

        for(int m=3;m<=len;m++){ //길이
            for(int start=0; start+m-1<len;start++){
                int end = start+m-1;
                if(line.charAt(start) == line.charAt(end) && dp[start+1][end-1])
                    dp[start][end]=true;
            }
        }
        
        int[] min = new int[len];
        Arrays.fill(min, Integer.MAX_VALUE);

        for (int i = 0; i < len; i++) {
            if (dp[0][i]) {
                min[i] = 1; // 전체가 팰린드롬이면 1개
            } else {
                for (int j = 1; j <= i; j++) {
                    if (dp[j][i] && min[j - 1] + 1 < min[i]) {
                        min[i] = min[j - 1] + 1;
                    }
                }
            }
        }

        System.out.println(min[len - 1]);
        //StringTokenizer st=new StringTokenizer(br.readLine());
        //int n=Integer.parseInt(st.nextToken());

        /*
        for(int i=0;i<n;i++){
        
        }
        */
        

        //int n=Integer.parseInt(br.readLine());
        //Scanner sc=new Scanner(System.in);
        //int n=sc.nextInt();
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	}
}