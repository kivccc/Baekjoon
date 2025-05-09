import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        int[] arr=new int[N];
        StringTokenizer st=new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i]=Integer.parseInt(st.nextToken());        
        }
        int a=0,b=0;
        int left=0,right=N-1;
        int min=Integer.MAX_VALUE;
        while(left<right){
            int sum=arr[left]+arr[right];
            if(Math.abs(sum)<Math.abs(min)){
                min=sum;
                a=left;
                b=right;
            }
            if(sum<0)
                left++;
            else
                right--;
        }
        System.out.println(arr[a]+" "+arr[b]);
        // 

        //
        //Scanner sc=new Scanner(System.in);
        //int N=sc.nextInt();
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	}
}