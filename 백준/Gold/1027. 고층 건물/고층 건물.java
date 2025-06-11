import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        int[] arr=new int[n];
        //
        //int N=Integer.parseInt(st.nextToken());
        StringTokenizer st=new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }
        int answer=0;
        for(int idx=0;idx<n;idx++){
            int count=0;
            int height=arr[idx];
            double gd=1000000001;
            for(int i=idx-1;i>=0;i--){
                double t=(double)(height-arr[i])/(idx-i);
                if(t<gd){
                    count++;
                    gd=t;
                }
            }
            gd=-1000000001;
            for(int i=idx+1;i<n;i++){
                double t=(double)(height-arr[i])/(idx-i);
                if(gd<t){
                    count++;
                    gd=t;
                }
            }
            answer=Math.max(answer,count);
        }
        System.out.println(answer);
        //
        //Scanner sc=new Scanner(System.in);
        //int N=sc.nextInt();
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	}
}