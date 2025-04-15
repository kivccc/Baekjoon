import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        // 4 000 000 000
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<N;i++){
            long s=Long.parseLong(br.readLine());
            sb.append(nextPrime(s)).append("\n");
        }
        System.out.println(sb);
        //StringTokenizer st=new StringTokenizer(br.readLine());
	        //int N=Integer.parseInt(st.nextToken());
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	}
    public static boolean isPrime(long num){
        if(num<=1) return false;
        if(num<=3) return true;
        if(num%2==0 || num%3==0) return false;
        for (long i = 5; i * i <= num; i += 6) {
            if (num % i == 0 || num % (i + 2) == 0) return false;
        }
        return true;
    }
    public static long nextPrime(long n) {
        while (!isPrime(n)) {
            n++;
        }
        return n;
    }
    
}