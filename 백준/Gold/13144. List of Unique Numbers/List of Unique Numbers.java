import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        if(n==1){
            System.out.println(1);
            return;
        }
        boolean[] check = new boolean[n + 1];

        StringTokenizer st=new StringTokenizer(br.readLine());

        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }
        
        long answer=0;
        int left=0;
        int right=0;
        while(right<n){
            if(check[arr[right]]){
                while(right>left){
                    answer+=right-left;
                    check[arr[left]]=false;
                    if(arr[right]==arr[left]){
                        left++;
                        break;
                    }
                    left++;   
                }
            }
            else{
                check[arr[right++]]=true;
            }
        }
        for(int i=1;i<=right-left;i++)
            answer+=i;
        System.out.println(answer);
        

        //
        //Scanner sc=new Scanner(System.in);
        //int n=sc.nextInt();
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	}
}