import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        StringTokenizer st=new StringTokenizer(br.readLine());
        int[] arr=new int[N];
        int[] mem=new int[N];
        for(int i=0;i<N;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }
        mem[0]=arr[0];
        int idx=1;
        for(int i=1;i<N;i++){
            int val=arr[i];
            
            if(mem[idx-1]<val){
                idx++;
                mem[idx-1]=val;
            }
            else{
                int start=0;
                int end=idx;
                while(start<end){
                    int mid=(start+end)/2;
                    if(mem[mid]<val){
                        start=mid+1;
                    }
                    else{
                        end=mid;
                    }
                }
                mem[start]=val;
            }
        }
        System.out.println(idx);
         
	}
}