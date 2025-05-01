import java.util.*;
import java.io.*;
public class Main {
    public static int N;
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        long B=Long.parseLong(st.nextToken());
        long[][] arr=new long[N][N];
        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                arr[i][j]=Long.parseLong(st.nextToken());
            }
        }
        if(B==1){
            printarr(arr);
            return;
        }
        long[][] result=power(arr,B);
        printarr(result);
        //int N=Integer.parseInt(br.readLine());
        //Scanner sc=new Scanner(System.in);
        //int N=sc.nextInt();
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	}
    public static long[][] power(long[][] arr,long b){
        if(b==1)
            return arr;
        long[][] half=power(arr,b/2);
        long[][] result=mul(half,half);
        if(b%2==1){
            result=mul(result,arr);
        }
        return result;
    }
    public static long[][] mul(long[][]a,long[][]b){
        long[][] result=new long[N][N];
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                for(int k=0;k<N;k++){
                    result[i][j]+=a[i][k]*b[k][j];
                    result[i][j]%=1000;
                }
            }
        }
        return result;
    }
    public static void printarr(long[][]arr){
        StringBuilder sb=new StringBuilder();
        for(long[]a:arr){
            for(long b:a){
                sb.append(b%1000).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}