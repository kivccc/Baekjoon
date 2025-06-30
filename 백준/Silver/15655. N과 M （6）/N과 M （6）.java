import java.util.*;
import java.io.*;
public class Main {
    public static int n;
    public static int m;
    public static int[] arr;
    public static int[] mem;
    public static StringBuilder sb=new StringBuilder();
	public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        arr=new int[n];
        mem=new int[m];
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        dfs(0,0);
        System.out.println(sb);
        //int n=Integer.parseInt(br.readLine());
        //Scanner sc=new Scanner(System.in);
        //int n=sc.nextInt();
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	}
    public static void dfs(int start,int depth){
        if(depth==m){
            for(int i:mem)
                sb.append(i).append(" ");
            sb.append("\n");
            return;
        }
        
        for(int i=start;i<n;i++){
            mem[depth]=arr[i];
            dfs(i+1,depth+1);
        }
    }
}