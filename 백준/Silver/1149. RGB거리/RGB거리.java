import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        int x=0;
        int y=0;
        int z=0;
        for(int i=0;i<N;i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            int c=Integer.parseInt(st.nextToken());
            int t1=x;
            int t2=y;
            int t3=z;
            x=a+Math.min(t2,t3);
            y=b+Math.min(t1,t3);
            z=c+Math.min(t1,t2);
        }
        int ans=Math.min(x,Math.min(y,z));
        System.out.println(ans);
        //int N=Integer.parseInt(st.nextToken());
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	}
}