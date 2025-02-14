import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int answer=0;
        for(int i=0;i<N;i++){
            int a=sc.nextInt();
            if(isPrime(a))
                answer++;
        }
        System.out.println(answer);
	}
    public static boolean isPrime(int a){
        if(a<=1)
            return false;
        for(int i=2;i<=Math.sqrt(a);i++)
            if(a%i==0)
                return false;
        return true;
    }
}