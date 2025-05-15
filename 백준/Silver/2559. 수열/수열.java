import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());        
        int k=Integer.parseInt(st.nextToken());        
        int[] arr=new int[n];
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }
        int sum=0;
        int left=0;
        int right=k;
        for(int i=0;i<k;i++){
            sum+=arr[i];
        }
        int max=sum;
        
        while(right<n){
            sum+=arr[right++]-arr[left++];
            max=Math.max(max,sum);
        }
        System.out.println(max);


        //int N=Integer.parseInt(br.readLine());
        //Scanner sc=new Scanner(System.in);
        //int N=sc.nextInt();
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	}
}