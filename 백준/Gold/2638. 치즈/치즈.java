import java.util.*;
import java.io.*;
public class Main {
    public static int N;
    public static int M;
    public static int[][] arr;
    public static boolean[][] visit;
    public static boolean[][] outer;
    public static int[] dy=new int[]{-1,1,0,0};
    public static int[] dx=new int[]{0,0,1,-1};
	public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());        
        M=Integer.parseInt(st.nextToken());        
        arr=new int[N][M];
        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                arr[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        int answer=0;
        while(true){
            visit=new boolean[N][M];
            outer=new boolean[N][M];
            bfs(0,0,2);
            /*
            for(boolean[]b:outer){
                System.out.println(Arrays.toString(b));
            }
            */
            Deque<int[]> q=new ArrayDeque<>();
            for(int i=0;i<N;i++){
                for(int j=0;j<M;j++){
                    if(arr[i][j]==1 && isAble(i,j)){
                        q.add(new int[]{i,j});
                    }
                }
            }
            if(q.isEmpty()){
                System.out.println(answer);
                return;
            }
            answer++;
            while(!q.isEmpty()){
                int[] val=q.poll();
                arr[val[0]][val[1]]=0;
            }
        }
        //int N=Integer.parseInt(br.readLine());
        //Scanner sc=new Scanner(System.in);
        //int N=sc.nextInt();
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	}
    
    public static void bfs(int y,int x,int flag){
        Deque<int[]> q=new ArrayDeque<>();
        q.add(new int[]{y,x});
        visit[y][x]=true;
        
        while(!q.isEmpty()){
            int[] val=q.poll();
            int cury=val[0];
            int curx=val[1];
            outer[cury][curx]=true;
            for(int i=0;i<4;i++){
                int ny=cury+dy[i];
                int nx=curx+dx[i];
                if(ny<0 || N<=ny ||nx<0 || M<=nx) continue;
                
                if(!visit[ny][nx] && arr[ny][nx]==0){
                    q.add(new int[]{ny,nx});
                    visit[ny][nx]=true;
                }
            }
        }
    }
    public static boolean isAble(int y,int x){
        int flag=0;
        for(int i=0;i<4;i++){
            int ny=y+dy[i];
            int nx=x+dx[i];
            if(outer[ny][nx])
                flag++;
        }
        if(flag>=2)
            return true;
        else
            return false;
    }
}