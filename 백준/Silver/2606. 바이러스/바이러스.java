import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        int T=Integer.parseInt(br.readLine());
        int[][] arr=new int[N+1][N+1];
        boolean[] mem=new boolean[N+1];
        for(int i=0;i<T;i++){
            String[] s=br.readLine().split(" ");
            int a=Integer.parseInt(s[0]);
            int b=Integer.parseInt(s[1]);
            arr[a][b]=1;
            arr[b][a]=1;
        }
        //System.out.println(Arrays.deepToString(arr));
        
        Deque<Integer> q=new ArrayDeque<>();
        q.addLast(1);
        int answer=-1;
        while(!q.isEmpty()){
            //System.out.println(answer);
            //System.out.println(q);
            int val=q.poll();
            if(!mem[val]){
                answer++;
                for(int i=1;i<=N;i++){
                    if(!mem[i] && arr[val][i]==1){
                        q.addLast(i);
                    }
                }
                mem[val]=true;    
            }
        }
        //System.out.println();
        
        System.out.println(answer);
        //StringTokenizer st=new StringTokenizer(br.readLine());
        //int N=Integer.parseInt(st.nextToken());
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	}
}