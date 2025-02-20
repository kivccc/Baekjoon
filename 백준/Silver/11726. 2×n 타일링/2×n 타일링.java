import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int[] arr=new int[1000];
        arr[0]=1;
        arr[1]=2;
        int val=0;
        for(int i=2;i<N;i++){
            arr[i]=(arr[i-1]+arr[i-2])%10007;
        }
        System.out.println(arr[N-1]);
        
	}
}