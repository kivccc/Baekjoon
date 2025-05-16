import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        int[] arr=new int[N];
        int M=Integer.parseInt(br.readLine());
        StringTokenizer st=new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i]=Integer.parseInt(st.nextToken());        
        }
        Arrays.sort(arr);
        int count=0;
        int left=0;
        int right=N-1;
        while(left<right){
            int sum=arr[left]+arr[right];
            if(sum>M)
                right--;
            else if(sum<M)
                left++;
            else{
                count++;
                right--;
                left++;
            }
        }
        System.out.println(count);

        //int N=Integer.parseInt(br.readLine());
        //Scanner sc=new Scanner(System.in);
        //int N=sc.nextInt();
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	}
}