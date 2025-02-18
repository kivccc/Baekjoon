import java.util.*;
import java.io.*;
import java.math.*;
public class Main {
    public static int getmin(int N,int M,String[] arr){
        int a=0;
        int b=0;
        for(int i=0;i<8;i++){
            int tmp=0;
            for(int j=0;j<8;j++){
                char c=arr[N+i].charAt(M+j);
                if(i%2==0){
                    if((j%2==0 && c=='B')||(j%2==1 && c=='W'))
                        tmp++;    
                }
                else{
                    if((j%2==0 && c=='W')||(j%2==1 && c=='B'))
                        tmp++;    
                }
            }
            a+=tmp;
            b+=8-tmp;
        }
        return Math.min(a,b);
    }
    
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm=br.readLine().split(" ");
        int N=Integer.parseInt(nm[0]);
        int M=Integer.parseInt(nm[1]);
        String[] arr=new String[N];
        for(int i=0;i<N;i++)
            arr[i]=br.readLine();
        int answer=2505;
        for(int i=0;i<=N-8;i++){
            for(int j=0;j<=M-8;j++){
                int val=getmin(i,j,arr);
                if(val<answer)
                    answer=val;
            }
        }
        System.out.println(answer);
	}
}
