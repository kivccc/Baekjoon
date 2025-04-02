import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a=br.readLine();
        String b=br.readLine();
        int alen=a.length();
        int blen=b.length();
        char[] arra=new char[alen+1];
        char[] arrb=new char[blen+1];
        for(int i = 1; i <= alen; i++) {
			arra[i] = a.charAt(i - 1);
		}
		for(int i = 1; i <= blen; i++) {
			arrb[i] = b.charAt(i - 1);
		}
        int[][] dp=new int[blen+1][alen+1];
            
        for(int i=1;i<=blen;i++){
            for(int j=1;j<=alen;j++){
                if(arrb[i]==arra[j]){
                    dp[i][j]=dp[i-1][j-1]+1;
                }
                else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
            
        }
        System.out.println(dp[b.length()][a.length()]);
        //StringTokenizer st=new StringTokenizer(br.readLine());
        //int N=Integer.parseInt(st.nextToken());
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	}
}