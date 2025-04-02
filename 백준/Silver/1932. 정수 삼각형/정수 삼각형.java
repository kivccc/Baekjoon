import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        int[] ans=new int[N];
        ans[0]=Integer.parseInt(br.readLine());
        for(int i=1;i<N;i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            int[] val=new int[N];
            for(int j=0;j<i+1;j++){
                val[j]=Integer.parseInt(st.nextToken());
            }
            val[0]+=ans[0];
            val[i]+=ans[i-1];
            if(i>1){
                for(int j=1;j<i;j++){
                    val[j]+=Math.max(ans[j-1],ans[j]);
                }
            }
            for(int j=0;j<=i;j++){
                ans[j]=val[j];
            }
        }
        int max=0;
        for(int i:ans)
            max=Math.max(max,i);
        System.out.println(max);        
        //StringTokenizer st=new StringTokenizer(br.readLine());
        //int N=Integer.parseInt(st.nextToken());
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	}
}