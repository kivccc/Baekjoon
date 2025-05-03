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
            mem[i]=1;
        }
        for(int i=1;i<N;i++){
            for(int j=0;j<i;j++){
                if(arr[j]<arr[i])
                    mem[i]=Math.max(mem[i],mem[j]+1);
            }
        }
        int max=0;
        for(int i:mem)
            max=Math.max(max,i);
        System.out.println(max);
	}
}