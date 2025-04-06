import java.util.*;
import java.io.*;
public class Main {
    public static int N;
    public static int[] val;
    public static int[]ops=new int[4]; // + , - , * , /
    public static int[]cmd;
    public static Deque<Integer> q=new ArrayDeque<>();
    public static int max=Integer.MIN_VALUE;
    public static int min=Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());
        val=new int[N];
        cmd=new int[N-1];
        StringTokenizer st=new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            val[i]=Integer.parseInt(st.nextToken());
        }
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<4;i++){
            ops[i]=Integer.parseInt(st.nextToken());
        }
        dfs(0);
        System.out.println(max);
        System.out.println(min);
        //StringTokenizer st=new StringTokenizer(br.readLine());
        //int N=Integer.parseInt(st.nextToken());
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	}
    
    public static void dfs(int depth){
        if(depth==N-1){
            
            /* 출력용
            StringBuilder sb=new StringBuilder();
            for(int i=0;i<N-1;i++){
                sb.append(val[i]);
                int op=cmd[i];
                if(op==0){
                    sb.append("+");
                }
                else if(op==1){
                    sb.append("-");
                }
                else if(op==2){
                    sb.append("X");
                }
                else if(op==3){
                    sb.append("/");
                }
            }
            sb.append(val[N-1]);
            System.out.println(sb);
            sb.setLength(0);
            */
            int answer=val[0];
            for(int i=0;i<N-1;i++){
                int op=cmd[i];
                if(op==0){
                    answer+=val[i+1];
                }
                else if(op==1){
                    answer-=val[i+1];
                }
                else if(op==2){
                    answer*=val[i+1];
                }
                else if(op==3){
                    answer/=val[i+1];
                }
            }
            max=Math.max(max,answer);
            min=Math.min(min,answer);
            return;
        }
        
        for(int i=0;i<4;i++){
            if(ops[i]!=0){
                ops[i]--;
                cmd[depth]=i;
                dfs(depth+1);
                ops[i]++;
            }
        }
    }
}