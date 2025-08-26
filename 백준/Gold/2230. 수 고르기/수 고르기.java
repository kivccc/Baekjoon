import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        int answer=Integer.MAX_VALUE;
        int len=arr.length;
        int left=0;
        int right=0;
        while(right<len){
            int diff=arr[right]-arr[left];
            if(diff==m){
                System.out.println(m);
                return;
            }
            
            if(diff<m){
                right++;
            }
            else{
                answer=Math.min(answer,diff);
                left++;
            }
        }
        
  
        System.out.println(answer);
        //int n=Integer.parseInt(br.readLine());
        //Scanner sc=new Scanner(System.in);
        //int n=sc.nextInt();
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	}
}