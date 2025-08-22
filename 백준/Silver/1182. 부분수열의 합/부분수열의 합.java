import java.util.*;
import java.io.*;
public class Main {
    static int answer=0;
    static int n;
    static int s;
    static int[] arr;
	public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        s=Integer.parseInt(st.nextToken());
        arr=new int[n];       
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }
        dfs(0,0,0);
        System.out.println(answer);
        //int n=Integer.parseInt(br.readLine());
        //Scanner sc=new Scanner(System.in);
        //int n=sc.nextInt();
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	}
    public static void dfs(int idx,int sum,int cnt){
        if(idx==n){
            if(cnt>0 && sum==s)
                answer++;
            return;
        }
        dfs(idx+1,sum+arr[idx],cnt+1);
        dfs(idx+1,sum,cnt);
    }
}