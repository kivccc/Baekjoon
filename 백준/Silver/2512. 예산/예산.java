import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        StringTokenizer st=new StringTokenizer(br.readLine());
        int[] arr=new int[N];
        int min=100001;
        int max=0;
        for(int i=0;i<N;i++){
            arr[i]=Integer.parseInt(st.nextToken());
            min=Math.min(min,arr[i]);
            max=Math.max(max,arr[i]);
        }
        Arrays.sort(arr);
        int M=Integer.parseInt(br.readLine());
        if(max*N<=M){
            System.out.println(max);
            return;
        }
        int left=arr[0];
        int right=arr[N-1];
        int answer=0;
        while(left<=right){
            int mid=(left+right)/2;
            int sum=0;
            for(int i=0;i<N;i++){
                if(arr[i]<=mid)
                    sum+=arr[i];
                else
                    sum+=mid;
            }
            if(sum<=M){
                answer=mid;
                left=mid+1;
            }
            else
                right=mid-1;
        }
        if(answer!=0)
            System.out.println(answer);
        else
            System.out.println(M/N);
        //int N=Integer.parseInt(br.readLine());
        //Scanner sc=new Scanner(System.in);
        //int N=sc.nextInt();
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	}
}