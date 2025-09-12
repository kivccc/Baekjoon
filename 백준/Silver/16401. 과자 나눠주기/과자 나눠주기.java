import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int left = 1;
        int right = arr[n-1];
        long max = 0;
        while(left<=right){
            int count=0;
            int mid = (left+right)/2;
            //System.out.println("left : "+left+" right : "+right+" mid : "+mid);
            
            for(int i=0;i<n;i++)
                count += arr[i]/mid;
            
            if(count<m){
                right=mid-1;
            }
            else{
                max = mid;
                left=mid+1;
            }
        }
        System.out.println(max);

        //int n=Integer.parseInt(br.readLine());
        //Scanner sc=new Scanner(System.in);
        //int n=sc.nextInt();
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	}
}