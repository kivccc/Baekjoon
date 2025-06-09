import java.util.*;
import java.io.*;
public class Main {
    public static boolean[][] visit;
    public static int[][] arr;
    public static int[] dy={-1,1,0,0};
    public static int[] dx={0,0,-1,1};
    public static int count=0;
    public static int max=0;
    public static int n;
    public static int m;
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        arr=new int[n][m];
        visit=new boolean[n][m];
        for(int i=0;i<n;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                arr[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!visit[i][j] && arr[i][j]==1){
                    count++;
                    bfs(i,j);
                }
            }
        }
        System.out.println(count);
        System.out.println(max);
        //int N=Integer.parseInt(br.readLine());
        //Scanner sc=new Scanner(System.in);
        //int N=sc.nextInt();
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	}
    public static void bfs(int y,int x){
        Deque<int[]> q=new ArrayDeque<>();
        q.add(new int[]{y,x});
        visit[y][x]=true;
        int size=0;
        while(!q.isEmpty()){
            size++;
            int[] cur=q.poll();
            int cury=cur[0];
            int curx=cur[1];
            for(int i=0;i<4;i++){
                int ny=cury+dy[i];
                int nx=curx+dx[i];
                if(ny<0 || n<=ny || nx<0 || m<=nx) continue;
                if(arr[ny][nx]==0) continue; 
                if(visit[ny][nx]) continue;
                q.add(new int[]{ny,nx});
                visit[ny][nx]=true;
            }
        }
        max=Math.max(size,max);
    }
}