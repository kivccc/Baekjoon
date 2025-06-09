import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int h=Integer.parseInt(st.nextToken());
        int w=Integer.parseInt(st.nextToken());
        int[] arr=new int[w];
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<w;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }
        int answer=0;
        for(int i=1;i<w-1;i++){
            int lmax=0;
            int rmax=0;
            for(int left=0;left<i;left++){
                lmax=Math.max(lmax,arr[left]);
            }
            for(int right=i+1;right<w;right++){
                rmax=Math.max(rmax,arr[right]);
            }
            if(lmax<=arr[i] || rmax<=arr[i]) continue;
            answer+=Math.min(lmax,rmax)-arr[i];
        }
        System.out.println(answer);
        //int N=Integer.parseInt(br.readLine());
        //Scanner sc=new Scanner(System.in);
        //int N=sc.nextInt();
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	}
}