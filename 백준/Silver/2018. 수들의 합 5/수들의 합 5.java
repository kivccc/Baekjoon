import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        int count=0;
        int start=1;
        int end=1;
        int sum=1;
        while(start<=N){
            if(sum==N){
                count++;
                sum-=start++;               
            }
            else if(sum>N)
                sum-=start++;
            else 
                sum+=++end;
        }
        System.out.println(count);
        //int N=Integer.parseInt(br.readLine());
        //Scanner sc=new Scanner(System.in);
        //int N=sc.nextInt();
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	}
}