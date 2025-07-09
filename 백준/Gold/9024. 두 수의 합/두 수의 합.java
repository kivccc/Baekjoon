import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        
        StringBuilder sb=new StringBuilder();
        for(int tc=0;tc<t;tc++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            int n=Integer.parseInt(st.nextToken());
            int k=Integer.parseInt(st.nextToken());
            int[] arr=new int[n];
            st=new StringTokenizer(br.readLine());
            for(int i=0;i<n;i++){
                arr[i]=Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);
            int left=0;
            int right=n-1;
            int mindif=Integer.MAX_VALUE;
            int count=0;
            while(left<right){
                int sum=arr[left]+arr[right];
                int dif=Math.abs(sum-k);
                if(dif<mindif){ //새로운 최소격차찾음
                    count=1;
                    mindif=dif;
                }
                else if(dif==mindif){
                    count++;
                }
                if(sum<=k){
                    left++;
                }
                else{
                    right--;
                }
            }
            sb.append(count).append("\n");
        }
        System.out.println(sb);

        //
        //Scanner sc=new Scanner(System.in);
        //int n=sc.nextInt();
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	}
}