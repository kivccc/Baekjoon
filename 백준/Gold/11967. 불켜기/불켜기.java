import java.util.*;
import java.io.*;
public class Main {
    public static boolean[][] arr;
    public static boolean[][] visit;
    static ArrayList<int[]> light[][];
    public static int N;
    public static int M;
    public static int[] dy=new int[]{-1,1,0,0};
    public static int[] dx=new int[]{0,0,-1,1};
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        arr=new boolean[N][N];
        visit=new boolean[N][N];
        light=new ArrayList[N][N];
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                light[i][j]=new ArrayList<>();
            }
        }
        for(int i=0;i<M;i++){
            st=new StringTokenizer(br.readLine());
            int yfrom =Integer.parseInt(st.nextToken())-1;
            int xfrom =Integer.parseInt(st.nextToken())-1;
            int yto =Integer.parseInt(st.nextToken())-1;
            int xto =Integer.parseInt(st.nextToken())-1;
            light[yfrom][xfrom].add(new int[]{yto,xto});
        }
        Deque<int[]> q=new ArrayDeque<>();
        q.add(new int[]{0,0});
        
        int answer=0;
        visit[0][0]=true;
        arr[0][0]=true;
        
        while(!q.isEmpty()){
            int[] cur=q.poll();
            
            
            if(!light[cur[0]][cur[1]].isEmpty()){
                visit=new boolean[N][N];
                visit[cur[0]][cur[1]]=true;
                for(int[] next:light[cur[0]][cur[1]]){
                    if(!arr[next[0]][next[1]]){
                        //System.out.println(next[0]+1);
                        //System.out.println(next[1]+1);
                        //System.out.println();
                        arr[next[0]][next[1]]=true;
                        answer++;
                    }
                }
                light[cur[0]][cur[1]].clear();
            }
            
            for(int i=0;i<4;i++){
                int nexty=cur[0]+dy[i];
                int nextx=cur[1]+dx[i];
                
                if(nexty<0 || nexty>=N ||nextx<0 || nextx>=N ) continue;
                if(visit[nexty][nextx]) continue;
                if(arr[nexty][nextx]){
                    q.add(new int[]{nexty,nextx});
                    visit[nexty][nextx]=true;
                }
            }
        }
        System.out.println(answer+1);
        
   }
}