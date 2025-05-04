import java.util.*;
import java.io.*;
public class Main {
    public static long[][] og={{1,1},{1,0}};
    public static long N;
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N=Long.parseLong(br.readLine());
        //StringTokenizer st=new StringTokenizer(br.readLine());
        //int N=Integer.parseInt(st.nextToken());        

        /*
        for(int i=0;i<N;i++){
        
        }
        */
        long[][]a={{1, 1} , {1, 0}};
        long[][]result=power(a,N-1);
        System.out.println(result[0][0]);
        //int N=Integer.parseInt(br.readLine());
        //Scanner sc=new Scanner(System.in);
        //int N=sc.nextInt();
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	}
    public static long[][] power(long[][]arr,long exp){
        if(exp==1 || exp==0)
            return arr;
        long[][] half=power(arr,exp/2);
        long[][] result=mul(half,half);
        if(exp%2==1)
            result=mul(result,og);
        return result;
    }
    public static long[][] mul(long[][]arr1,long[][]arr2){
        long[][] result=new long[2][2];
        for(int i=0;i<2;i++){
            for(int j=0;j<2;j++){
                for(int k=0;k<2;k++){
                    result[i][j]+=arr1[i][k]*arr2[k][j];
                    result[i][j]%=1000000007;
                }
            }
        }
        return result;
    }
}