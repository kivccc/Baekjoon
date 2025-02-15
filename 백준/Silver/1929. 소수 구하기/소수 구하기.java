import java.util.*;
import java.io.*;
public class Main {
    public static boolean isPrime(int val){
        if(val==1)
            return false;
        for(int i=2;i<=Math.sqrt(val);i++)
            if(val%i==0)
                return false;
        return true;
    }
	public static void main(String[] args) throws IOException {
        Scanner sc=new Scanner(System.in);
        int M=sc.nextInt();
        int N=sc.nextInt();
        for(int i=M;i<=N;i++){
            if(isPrime(i))
                System.out.println(i);
        }
        
	}
}