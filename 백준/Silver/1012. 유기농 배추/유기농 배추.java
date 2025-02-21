import java.util.*;
import java.io.*;
public class Main {
    static int[][] arr;
    static boolean[][] visit;
    static int dirx[] = {0, 0, -1, 1};
	static int diry[] = {-1, 1, 0, 0};
    
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(br.readLine());
        for(int j=0;j<T;j++){
            String[] mnk=br.readLine().split(" ");
            int M=Integer.parseInt(mnk[0]);
            int N=Integer.parseInt(mnk[1]);
            int K=Integer.parseInt(mnk[2]);
            arr=new int[N][M];
            visit=new boolean[N][M];
            for(int i=0;i<K;i++){
                String[] xy=br.readLine().split(" ");
                int x=Integer.parseInt(xy[0]);
                int y=Integer.parseInt(xy[1]);
                arr[y][x]=1;
            }
            int answer=0;
            for(int i=0;i<N;i++){
                for(int k=0;k<M;k++){
                    if(arr[i][k]==1 && !visit[i][k]){
                        answer++;
                        dfs(k,i);
                    }    
                }
            }
            System.out.println(answer);
        }
	}
    
    public static void dfs(int x,int y){
        visit[y][x]=true;
        for(int i=0;i<4;i++){
            int nextx=x+dirx[i];
            int nexty=y+diry[i];
            if(0<=nextx && nextx<arr[0].length && 0<=nexty && nexty<arr.length){
                if(!visit[nexty][nextx] && arr[nexty][nextx]==1)
                    dfs(nextx,nexty);
            }
        }
    }
}