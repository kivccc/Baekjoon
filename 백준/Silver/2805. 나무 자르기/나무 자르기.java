import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm=br.readLine().split(" ");
        int N=Integer.parseInt(nm[0]);
        int M=Integer.parseInt(nm[1]);
        int[] arr=new int[N];
        String[] woods=br.readLine().split(" ");
        int max=0;
        int min=0;
        for(int i=0;i<N;i++){
            int val=Integer.parseInt(woods[i]);
            if(max<val)
                max=val;
            arr[i]=val;
        }
        
        while(min<max){
            int mid=(max+min)/2;
            long sum=0;
            
            for(int i:arr)
                if(i-mid>0)  
				    sum+=i-mid;
            
            if(sum<M)
                max=mid;
            else
                min=mid+1;
        }
        System.out.println(min-1);
        //StringTokenizer st=new StringTokenizer(br.readLine());
        //int N=Integer.parseInt(st.nextToken());
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	}
}