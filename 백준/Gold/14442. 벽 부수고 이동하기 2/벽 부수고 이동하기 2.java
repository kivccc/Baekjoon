import java.util.*;
import java.io.*;
public class Main {
    public static int[][] arr;
    public static boolean[][][] visit;
    public static int N;
    public static int M;
    public static int K;
    public static int[] dy=new int[]{-1,1,0,0};
    public static int[] dx=new int[]{0,0,-1,1};
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        K=Integer.parseInt(st.nextToken());
        arr=new int[N][M]; // 0,0 -> N-1,M-1  | 최단경로 시작 도착 포함
        visit=new boolean[N][M][K+1];
        for(int i=0;i<N;i++){
            String s=br.readLine();
            int idx=0;
            for(char c:s.toCharArray())
                arr[i][idx++]=c-'0';
        }
        
        bfs();
	}
    
    public static void bfs(){
        Deque<int[]> q=new ArrayDeque<>();
        q.add(new int[]{0,0,1,0}); // y , x , count , wall
        visit[0][0][0]=true;
        
        while(!q.isEmpty()){
            int[] val=q.poll();
            int y=val[0],x=val[1],dist=val[2],wall=val[3];
            if(val[0]==N-1 && val[1]==M-1){
                System.out.println(dist);
                return;
            }
            for(int i=0;i<4;i++){
                int ny=y+dy[i];
                int nx=x+dx[i];
                if(!isIn(ny,nx)) continue;
                
                
                if(arr[ny][nx]==0 && !visit[ny][nx][wall]){
                    visit[ny][nx][wall]=true;
                    q.add(new int[]{ny,nx,dist+1,wall});
                }
                if(arr[ny][nx]==1 && wall < K && !visit[ny][nx][wall+1]){
                    visit[ny][nx][wall+1] = true;
                    q.add(new int[]{ny,nx,dist + 1,wall+1});
                }
            }
        }

        System.out.println(-1);
    }
    public static boolean isIn(int y,int x){
        if(0<= y && y < N && 0<= x && x < M ) 
            return true;
        else 
            return false;
    }
}