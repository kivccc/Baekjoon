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
        mem=new int[m];
        HashSet<Integer> set=new HashSet<>();
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            set.add(Integer.parseInt(st.nextToken()));
        }
        n=set.size();
        arr=new int[n];
        int idx=0;
        for(int i:set)
            arr[idx++]=i;
        Arrays.sort(arr);
        dfs(0);
        System.out.println(sb);
        //int n=Integer.parseInt(br.readLine());
        //Scanner sc=new Scanner(System.in);
        //int n=sc.nextInt();
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	}
    public static void dfs(int depth){
        if(depth==m){
            for(int i:mem)
                sb.append(i).append(" ");
            sb.append("\n");
            return;
        }
        
        for(int i=0;i<n;i++){
            mem[depth]=arr[i];
            dfs(depth+1);
        }
    }
}