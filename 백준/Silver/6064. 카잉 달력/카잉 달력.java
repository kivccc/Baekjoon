import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(br.readLine());

        StringBuilder sb=new StringBuilder();
        for(int i=0;i<T;i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            int M=Integer.parseInt(st.nextToken());
            int N=Integer.parseInt(st.nextToken());
            int x=Integer.parseInt(st.nextToken());
            int y=Integer.parseInt(st.nextToken());
            int lcm = M * N / gcd(M, N);
            int n = 0;
            int ans = -1;
            if(x>M || y> N){
                sb.append("-1\n");
                continue;
            }
            while(n*M<lcm) {
                if ((n*M+x-y) % N == 0) {
                    ans = n * M + x;
                    break;
                }
                n++;
            }
            sb.append(ans).append("\n");
        }
        System.out.print(sb);
        //StringTokenizer st=new StringTokenizer(br.readLine());
        //int N=Integer.parseInt(st.nextToken());
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	}
    
    
    public static int gcd(int a, int b) {
        if(b == 0)
            return a;
        return gcd(b,a%b);
    }
}