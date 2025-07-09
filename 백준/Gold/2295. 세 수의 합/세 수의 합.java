import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        int[]arr=new int[n];
        //StringTokenizer st=new StringTokenizer(br.readLine());
        //int n=Integer.parseInt(st.nextToken());

        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        for(int i=n-1;i>=1;i--){
            int d=arr[i];
            for(int j=i-1;j>=0;j--){
                int c=arr[j];
                int target=d-c;
                for(int k=j;k>=0;k--){
                    int b=arr[k];
                    int nexttarget=target-b;
                    int idx=Arrays.binarySearch(arr,nexttarget);
                    if(idx>=0){
                        //System.out.println("a : "+arr[idx]);
                        //System.out.println("b : "+b);
                        //System.out.println("c : "+c);
                        //System.out.println("d : "+d);
                        System.out.println(arr[i]);
                        return;
                    }
                }
            }
        }
        //
        //Scanner sc=new Scanner(System.in);
        //int n=sc.nextInt();
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	}
}