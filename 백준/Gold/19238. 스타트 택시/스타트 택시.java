import java.util.*;
import java.io.*;
public class Main {
    static int [][] map; // 0 빈칸 , 1 벽 , x는 승객
    static boolean [][] visit;
    static int n;
    static int m;
    static int fuel;
    static int[] taxiPos = new int[2];
    static int[][] dest;
    
    static int[] dy = new int[]{-1,1,0,0};
    static int[] dx = new int[]{0,0,-1,1};
    static boolean flag = false;
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        fuel = Integer.parseInt(st.nextToken());
        dest = new int[m+2][2];
        map = new int[n][n];
        visit = new boolean[n][n];
        
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        st = new StringTokenizer(br.readLine());
        taxiPos[0] = Integer.parseInt(st.nextToken())-1;
        taxiPos[1] = Integer.parseInt(st.nextToken())-1;
        
        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int fromy = Integer.parseInt(st.nextToken())-1;
            int fromx = Integer.parseInt(st.nextToken())-1;
            int toy = Integer.parseInt(st.nextToken())-1;
            int tox = Integer.parseInt(st.nextToken())-1;
            map[fromy][fromx] = i+2;
            dest[i+2][0] = toy;
            dest[i+2][1] = tox;
        }
        int count = m;
        while(m>0){
            int[] next = getNearPassenger();
            if(flag){
                System.out.println(-1);
                return;
            }
            else{
                //System.out.println(Arrays.toString(next));
                taxiPos[0] = next[0];
                taxiPos[1] = next[1];
                fuel -= next[3];
                map[next[0]][next[1]] = 0;
                if(!goToDest(next[2])){
                    System.out.println(-1);
                    return; 
                }
                m--;
            }
        }
        System.out.println(fuel);
        
        //int n = Integer.parseInt(br.readLine());
        //Scanner sc = new Scanner(System.in);
        //int n = sc.nextInt();
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	}
    
    
    static int[] getNearPassenger(){
        PriorityQueue<int[]> pq = new PriorityQueue<>((e1,e2)->{
            if(e1[0] != e2[0])
                return e1[0]-e2[0];
            else
                return e1[1]-e2[1];
        });
        visit = new boolean[n][n];
        
        Deque<int[]> q = new ArrayDeque<>();
        int firstTime = -1;
        q.add(new int[]{taxiPos[0],taxiPos[1],0});
        visit[taxiPos[0]][taxiPos[1]] = true;
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int cury = cur[0];
            int curx = cur[1];
            int usedfuel = cur[2];
            
            if(map[cury][curx] != 0 && map[cury][curx] != 1 ){ //승객을 만났다면
                //System.out.println("만났다!");
                if(firstTime == -1){ // 첨만난거면
                    firstTime = usedfuel; //연료 소모량이 시간 자체를 의미
                    pq.add(new int[]{cury,curx,map[cury][curx],usedfuel});
                }
                else if(firstTime == usedfuel){ //동시간에 승객에 접근
                    pq.add(new int[]{cury,curx,map[cury][curx],usedfuel});
                }
                continue;
            } 
            
            
            if(firstTime != -1 && usedfuel >= firstTime) continue;
            
            for(int i=0;i<4;i++){
                int nexty = cury+dy[i];
                int nextx = curx+dx[i];
                if(nexty<0 || nexty>=n || nextx<0 || nextx>=n) continue;
                if(map[nexty][nextx] == 1) continue;
                if(visit[nexty][nextx]) continue;
                if(usedfuel>fuel) continue;// 다음이동이 잔여 연료보다 넘게될경우
                //System.out.println("nexty : "+nexty+" nextx : "+nextx+" usedfuel : "+usedfuel);
                visit[nexty][nextx] = true;
                q.add(new int[]{nexty,nextx,usedfuel+1});
            }
        }
        
        if(!pq.isEmpty()){
            return pq.poll();
        }
        else{
            flag = true;
            return new int[]{};
        }
    }
    static boolean goToDest(int type){
        visit = new boolean[n][n];
        int desty = dest[type][0];
        int destx = dest[type][1];
        Deque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{taxiPos[0],taxiPos[1],0});
        visit[taxiPos[0]][taxiPos[1]] = true;
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int cury = cur[0];
            int curx = cur[1];
            int usedfuel = cur[2];
            if(desty == cury && destx == curx){
                //System.out.println("목적지 만났다!");
                //System.out.println("남은 fuel "+fuel+" 여기까지오는데 쓴 "+usedfuel );
                fuel += usedfuel;
                taxiPos[0] = desty;
                taxiPos[1] = destx;
                return true;
            }
            
            for(int i=0;i<4;i++){
                int nexty = cury+dy[i];
                int nextx = curx+dx[i];
                if(nexty<0 || nexty>=n || nextx<0 || nextx>=n) continue;
                if(map[nexty][nextx] == 1) continue;
                if(visit[nexty][nextx]) continue;
                if(usedfuel>=fuel) continue;// 다음이동이 잔여 연료보다 넘게될경우
                //System.out.println("nexty : "+nexty+" nextx : "+nextx+" usedfuel : "+usedfuel);
                visit[nexty][nextx] = true;
                q.add(new int[]{nexty,nextx,usedfuel+1});
            }
        }
        return false;
    }
}