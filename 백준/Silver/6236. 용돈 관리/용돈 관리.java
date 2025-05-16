import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());        
        int M=Integer.parseInt(st.nextToken());      
        int[] arr=new int[N];
        int max=0;
        int sum=0;
        for(int i=0;i<N;i++){
            arr[i]=Integer.parseInt(br.readLine());        
            Math.max(max,arr[i]);
            sum+=arr[i];
        }
        int left=max;
        int right=sum;
        int result=sum;
        while (left<=right){
            int mid=(left + right) / 2;
            if (isPossible(arr, N, M, mid)) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        System.out.println(result);
        //int N=Integer.parseInt(br.readLine());
        //Scanner sc=new Scanner(System.in);
        //int N=sc.nextInt();
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	}
    public static boolean isPossible(int[] arr, int N, int M, int K) {
        int count=1;
        int sum=0;
        for (int i = 0; i < N; i++) {
            if (arr[i] > K) return false;
            if (sum + arr[i] > K) {
                count++;
                sum = arr[i];
            } else {
                sum += arr[i];
            }
        }

        return count <= M;
    }
}