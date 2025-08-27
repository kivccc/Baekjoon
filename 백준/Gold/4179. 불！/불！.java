import java.util.*;
import java.io.*;
public class Main {
    static int[] jh=new int[2];
    static ArrayList<int[]> firelist=new ArrayList<>();
    static boolean[][] wall;
    static boolean[][] visit;
    static int[][] jh_map;
    static int[][] fire_map;
    static int r;
    static int c;
    static int[] dy=new int[]{-1,1,0,0};
    static int[] dx=new int[]{0,0,-1,1};
    static boolean flag=false;
    static int answer=1000*1000;
	public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        r=Integer.parseInt(st.nextToken());
        c=Integer.parseInt(st.nextToken());
        wall=new boolean[r][c]; //false은 빈공간,true은 벽
       
        jh_map=new int[r][c];
        fire_map=new int[r][c];
        for(int i=0;i<r;i++){
            String input=br.readLine();
            for(int j=0;j<c;j++){
                char c=input.charAt(j);
                if(c=='#')
                    wall[i][j]=true;
                else if(c=='J'){
                    jh[0]=i;
                    jh[1]=j;
                }
                else if(c=='F'){
                    firelist.add(new int[]{i,j});
                }
            }
        }
        
        //for(boolean[]a:wall)
        //    System.out.println(Arrays.toString(a));

        for(int[]fire:firelist){
            int starty=fire[0];
            int startx=fire[1];
            Deque<int[]> q=new ArrayDeque<>();
            visit=new boolean[r][c];
            q.add(new int[]{starty,startx,1});
            visit[starty][startx]=true;
            fire_map[starty][startx]=1;
            
            while(!q.isEmpty()){
                int[] cur=q.poll();
                for(int i=0;i<4;i++){
                    int nexty=cur[0]+dy[i];
                    int nextx=cur[1]+dx[i];
                    if(!isAble(nexty,nextx)) continue;
                    if(visit[nexty][nextx]) continue;
                    if(fire_map[nexty][nextx]!=0 && (fire_map[nexty][nextx] <=cur[2]+1)) continue;
                    q.add(new int[]{nexty,nextx,cur[2]+1});
                    visit[nexty][nextx]=true;
                    fire_map[nexty][nextx]=cur[2]+1;
                }
            }
        }
        //for(int[]a:fire_map)
            //System.out.println(Arrays.toString(a));
        //System.out.println();
        
        bfs(jh[0],jh[1],jh_map);
        
        for(int i=0;i<c;i++){
            checkEvacutate(0,i);
        }
        for(int i=1;i<r;i++){
            checkEvacutate(i,c-1);
        }
        for(int i=0;i<c-1;i++){
            checkEvacutate(r-1,i);
        }
        for(int i=1;i<r-1;i++){
            checkEvacutate(i,0);
        }
        if(flag)
            System.out.println(answer);
        else
            System.out.println("IMPOSSIBLE");
	}
    
    static boolean isAble(int y,int x){ //이동가능?
        if(y<0 || y>=r || x<0 || x>=c) //좌표 벗어남
            return false;
        if(wall[y][x])    //벽이여서 못감
            return false;
        return true;
    }

    static void checkEvacutate(int y,int x){
        if(jh_map[y][x]==0)
            return;
        if( fire_map[y][x]==0 || (jh_map[y][x]<fire_map[y][x])){
            flag=true;
            answer=Math.min(answer,jh_map[y][x]);
        }
    }
    
    static void bfs(int starty,int startx,int[][] map){
        Deque<int[]> q=new ArrayDeque<>();
        visit=new boolean[r][c];
        q.add(new int[]{starty,startx,1});
        visit[starty][startx]=true;
        map[starty][startx]=1;
        
        while(!q.isEmpty()){
            int[] cur=q.poll();
            for(int i=0;i<4;i++){
                int nexty=cur[0]+dy[i];
                int nextx=cur[1]+dx[i];
                if(!isAble(nexty,nextx)) continue;
                if(visit[nexty][nextx]) continue;
                q.add(new int[]{nexty,nextx,cur[2]+1});
                visit[nexty][nextx]=true;
                map[nexty][nextx]=cur[2]+1;
            }
        }
        //for(int[]a:map)
        //    System.out.println(Arrays.toString(a));
    }
}