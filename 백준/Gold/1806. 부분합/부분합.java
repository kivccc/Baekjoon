import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());        
        int S=Integer.parseInt(st.nextToken());        
        int[] arr=new int[N];
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i]=Integer.parseInt(st.nextToken());  
        }
        int minlen=Integer.MAX_VALUE;
        int left=0;
        int right=0;
        int sum=0;
        
        while(true){
            if(sum>=S){
                minlen = Math.min(minlen, right - left);
                sum -= arr[left++];
            }
            else if(right==N){
                break;
            }
            else{
                sum+=arr[right++];
            }
        }
        if (minlen == Integer.MAX_VALUE) {
            bw.write("0");
        } else {
            bw.write(String.valueOf(minlen));
        }
        bw.flush();

        //int N=Integer.parseInt(br.readLine());
        //Scanner sc=new Scanner(System.in);
        //int N=sc.nextInt();
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	}
}