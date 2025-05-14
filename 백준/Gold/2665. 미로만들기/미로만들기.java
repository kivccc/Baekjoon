import java.util.*;
import java.io.*;
public class Main {
    public static int N;
    public static int[][] arr;
    public static int[][] visit;
    public static int[] dy={-1,1,0,0};
    public static int[] dx={0,0,-1,1};
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());
        arr=new int[N][N];
        visit=new int[N][N];
        for(int[]t:visit)
            Arrays.fill(t,Integer.MAX_VALUE);
        for(int i=0;i<N;i++){
            String s=br.readLine();
            for(int j=0;j<N;j++){
                char c=s.charAt(j);
                if(c=='1')
                    arr[i][j]=0;
                else
                    arr[i][j]=1;
            }
        }
        Deque<int[]> q=new ArrayDeque<>();
        q.add(new int[]{0,0,0});
        visit[0][0]=0;
        
        while(!q.isEmpty()){
            int[] val=q.poll();
            int cury=val[0];
            int curx=val[1];
            int cwall=val[2];
            
            for(int i=0;i<4;i++){
                int ny=cury+dy[i];
                int nx=curx+dx[i];
                if(ny<0||N<=ny || nx<0||N<=nx ) continue;
                int nextwall=cwall+arr[ny][nx];
                if(visit[ny][nx]<=nextwall) continue;
                visit[ny][nx]=nextwall;
                if(visit[ny][nx]==0)
                    q.addFirst(new int[]{ny,nx,nextwall});
                else
                    q.addLast(new int[]{ny,nx,nextwall});
            }
        }
        System.out.println(visit[N-1][N-1]);
        //StringTokenizer st=new StringTokenizer(br.readLine());
        //int N=Integer.parseInt(st.nextToken());        

        /*
        
        */
        

        //
        //Scanner sc=new Scanner(System.in);
        //int N=sc.nextInt();
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	}
}