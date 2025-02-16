import java.util.*;
import java.io.*;
import java.math.*;
public class Main {
	public static void main(String[] args) throws IOException {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        BigInteger a = BigInteger.ZERO;
        BigInteger b = BigInteger.ONE;
        BigInteger answer = BigInteger.ZERO;
        if(n<=1)
            System.out.println(n);
        else{
            for(int i=2;i<=n;i++){
                answer=a.add(b);
                a=b;
                b=answer;
            }
            System.out.println(answer);
        }           
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st=new StringTokenizer(br.readLine());
        //int N=Integer.parseInt(st.nextToken());
	}
}