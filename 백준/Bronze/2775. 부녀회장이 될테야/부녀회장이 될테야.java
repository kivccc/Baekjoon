import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(br.readLine());
        int[][] arr=new int[15][15];
        for(int i=0;i<15;i++){
            arr[0][i]=i+1;
            arr[i][0]=1;            
        }
        for(int i=0;i<T;i++){
            int k=Integer.parseInt(br.readLine());
            int n=Integer.parseInt(br.readLine());
            if(arr[k][n]==0)
                fill(arr,k,n);
            System.out.println(arr[k][n-1]);
        }
        //StringTokenizer st=new StringTokenizer(br.readLine());
        //int N=Integer.parseInt(st.nextToken());
	}
    public static void fill(int[][]arr,int k,int n){
        if(arr[k-1][n]==0)
            fill(arr,k-1,n);
        if(arr[k][n-1]==0)
            fill(arr,k,n-1);
        arr[k][n]=arr[k-1][n]+arr[k][n-1];
    }
}