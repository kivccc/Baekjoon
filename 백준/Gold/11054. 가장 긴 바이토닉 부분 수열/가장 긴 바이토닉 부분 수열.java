import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        StringTokenizer st=new StringTokenizer(br.readLine());
        int[] arr=new int[N];
        int[] mem=new int[N];
        int[] arr2=new int[N];
        int[] mem2=new int[N];
        
        for(int i=0;i<N;i++){
            int val=Integer.parseInt(st.nextToken());
            arr[i]=val;
            arr2[N-i-1]=val;
        }
        for(int i=0;i<N;i++){
            mem[i]=1;
            mem2[i]=1;
            for(int j=0;j<i;j++){
                if(arr[j]<arr[i] && mem[i]<mem[j]+1)
                    mem[i]=mem[j]+1;
                if(arr2[j]<arr2[i] && mem2[i]<mem2[j]+1)
                    mem2[i]=mem2[j]+1;
            }
        }
        /*
        System.out.println(Arrays.toString(mem));
        System.out.print("[");
        
        for(int i=0;i<N;i++)
            System.out.print(mem2[N-1-i]+", ");
        System.out.print("]");
        */
        int max=0;
        for(int i=0;i<N;i++)
            max=Math.max(max,mem[i]+mem2[N-i-1]);
        System.out.println(max-1);
	}
}