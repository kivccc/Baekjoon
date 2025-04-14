import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        int[] mindp=new int[3];
        int[] maxdp=new int[3];
        for(int i=0;i<N;i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            int c=Integer.parseInt(st.nextToken());
            int[] mintmp=mindp.clone();
            int[] maxtmp=maxdp.clone();
            mindp[0]=a+Math.min(mintmp[0],mintmp[1]);
            maxdp[0]=a+Math.max(maxtmp[0],maxtmp[1]);
            
            mindp[1]=b+Math.min(Math.min(mintmp[0],mintmp[1]),mintmp[2]);
            maxdp[1]=b+Math.max(Math.max(maxtmp[0],maxtmp[1]),maxtmp[2]);
            
            mindp[2]=c+Math.min(mintmp[1],mintmp[2]);
            maxdp[2]=c+Math.max(maxtmp[1],maxtmp[2]);         
        }
        System.out.println(Math.max(Math.max(maxdp[0],maxdp[1]),maxdp[2]));
        System.out.println(Math.min(Math.min(mindp[0],mindp[1]),mindp[2]));
        //StringTokenizer st=new StringTokenizer(br.readLine());
	    //int N=Integer.parseInt(st.nextToken());
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	}
}