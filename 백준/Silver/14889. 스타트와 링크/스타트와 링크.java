import java.util.*;
import java.io.*;
public class Main {
    public static int N;
    public static int[][] arr;
    public static int ans=Integer.MAX_VALUE;
    public static int[]teamA;
    public static int[]teamB;
    public static boolean[]visited;
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());
        arr=new int[N][N];
        teamA=new int[N/2];
        teamB=new int[N/2];
        visited=new boolean[N];
        for(int i=0;i<N;i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                arr[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        dfs(0,0);
        System.out.println(ans);
        //StringTokenizer st=new StringTokenizer(br.readLine());
        //int N=Integer.parseInt(st.nextToken());
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	}
    public static void dfs(int depth,int index){
        if(depth==N/2){
            if (!visited[0]) 
                return;
            int idxA=0;
            int idxB=0;
            for(int i=0;i<N;i++){
                if(visited[i])
                    teamA[idxA++]=i;
                else
                    teamB[idxB++]=i;
            }
            int powerA=0;
            int powerB=0;
            for(int i=0;i<N/2;i++){ // 4 -> 0 1
                int fromA=teamA[i];
                int fromB=teamB[i];
                for(int j=0;j<N/2;j++){
                    int toA=teamA[j];
                    int toB=teamB[j];
                    powerA+=arr[fromA][toA];
                    powerB+=arr[fromB][toB];
                }
            }
            ans=Math.min(ans,Math.abs(powerA-powerB));
            return;
        }
        for(int i=index;i<N;i++){
            visited[i]=true;
            dfs(depth+1,i+1);
            visited[i]=false;
        }
    }
}