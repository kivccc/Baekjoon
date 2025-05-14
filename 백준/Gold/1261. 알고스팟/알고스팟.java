import java.util.*;
import java.io.*;
public class Main {
    public static int n;
    public static int m;
    public static int[][] arr;
    public static int[][] visit;
    public static int[] dy={-1,1,0,0};
    public static int[] dx={0,0,-1,1};
    
	public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());        
        m=Integer.parseInt(st.nextToken());        
        arr=new int[m][n];
        visit=new int[m][n];
        for(int i=0;i<m;i++){
            String s=br.readLine();
            for(int j=0;j<n;j++){
                char c=s.charAt(j);
                arr[i][j]=c-'0';
            }
        }
        for(int[]t:visit)
            Arrays.fill(t,Integer.MAX_VALUE);
        Deque<int[]> q=new ArrayDeque<>();
        q.add(new int[]{0,0,0});
        visit[0][0]=0;
        
        while(!q.isEmpty()){
            int[] val=q.poll();
            int cury=val[0];
            int curx=val[1];
            int wallcount=val[2];
            
            for(int i=0;i<4;i++){
                int ny=cury+dy[i];
                int nx=curx+dx[i];
                if(ny<0|| ny>=m || nx<0|| nx>=n ) continue;
                int nextwall=wallcount+arr[ny][nx];
                if(visit[ny][nx]>nextwall){
                    visit[ny][nx]=nextwall;
                    if(arr[ny][nx]==0)
                        q.addFirst(new int[]{ny,nx,nextwall});
                    else
                        q.addLast(new int[]{ny,nx,nextwall});
                }
            }
        }

        System.out.println(visit[m-1][n-1]);
        //int N=Integer.parseInt(br.readLine());
        //Scanner sc=new Scanner(System.in);
        //int N=sc.nextInt();
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	}
}