import java.util.*;
import java.io.*;
public class Main {
    public static boolean[] visit=new boolean[26]; //A~Z
    public static int R;
    public static int C;
    public static int[] dy=new int[]{-1,1,0,0};
    public static int[] dx=new int[]{0,0,-1,1};
    public static int[][] arr;
    public static int max;
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        R=Integer.parseInt(st.nextToken());
        C=Integer.parseInt(st.nextToken());
        arr=new int[R][C];
        for(int i=0;i<R;i++){
            String s=br.readLine();
            for(int j=0;j<C;j++){
                char c=s.charAt(j);
                arr[i][j]=c-'A';
            }
        }
        visit[arr[0][0]]=true;
        dfs(0,0,1);
        System.out.println(max);
        //
        //int N=Integer.parseInt(st.nextToken());
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	}
    public static void dfs(int y,int x,int count){
        max=Math.max(max,count);
        
        for(int i=0;i<4;i++){
            int ny=y+dy[i];
            int nx=x+dx[i];
            if(ny<0 || R<=ny || nx<0 || C<=nx ) continue;
            if(visit[arr[ny][nx]]) continue;
            visit[arr[ny][nx]]=true;
            dfs(ny,nx,count+1);
            visit[arr[ny][nx]]=false;
        }
    }
}