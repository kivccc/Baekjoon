import java.util.*;
import java.io.*;
import java.math.*;
public class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        if(n==0){
            System.out.println(0);
            return;            
        }
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        int start=(int)Math.round(n*0.15);
        int end=n-start;
        int sum=0;
        for(int i=start;i<end;i++){
            sum+=arr[i];
        }
        sum=(int)Math.round(1.0*sum/(end-start));
        System.out.println(sum);
	}
}