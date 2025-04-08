import java.util.*;
import java.io.*;
public class Main {
    static int N;
    static int M;
    static int [][] arr;
    static int safe=0; //원본 안전한 곳 크기
    static int virusmin=Integer.MAX_VALUE; //원본 안전한 곳 크기
    static ArrayList<int[]> empty=new ArrayList<>(); // 벽세우는 가능 후보
    static int[][] selected=new int[3][2]; // 실제 벽 위치
    static ArrayList<int[]> start=new ArrayList<>(); // 바이러스 시작점
    static int[] dirY=new int[]{-1,1,0,0};
    static int[] dirX=new int[]{0,0,-1,1};
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        arr=new int[N][M];
        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                int val=Integer.parseInt(st.nextToken());
                if(val==0){
                    safe++;
                    empty.add(new int[]{i,j});
                }
                else if(val==2){
                    start.add(new int[]{i,j});
                }
                arr[i][j]=val;
            }
        }

        dfs(0,0);
        System.out.println(safe-virusmin-3);
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	}
    
    public static void dfs(int start,int depth){
        if(depth==3){
            bfs();
            return;
        }
        
        for(int i=start;i<empty.size();i++){
            selected[depth]=empty.get(i);
            dfs(i+1,depth+1);
        }
    }
    public static void bfs(){
        Deque<int[]> q=new ArrayDeque<>();
        
        boolean[][] visited=new boolean[N][M];
        int infected=0;
        for(int i=0;i<start.size();i++){
            int[] tmp=start.get(i);
            q.add(tmp);
            visited[tmp[0]][tmp[1]]=true;
        }
        while(!q.isEmpty()){
            int[] node=q.poll();
            for(int i=0;i<4;i++){
                int nexty=node[0]+dirY[i];
                int nextx=node[1]+dirX[i];
                if(0<= nexty && nexty<N && 0<= nextx && nextx<M){
                    if(!visited[nexty][nextx]){
                        if(arr[nexty][nextx]==0){
                            boolean flag=true;
                            for(int j=0;j<3;j++){
                                if(nexty==selected[j][0] && nextx==selected[j][1]){
                                    flag=false;
                                    break;
                                }
                            }
                            if(flag){
                                q.add(new int[]{nexty,nextx});
                                visited[nexty][nextx]=true;
                                infected++;    
                            }
                        }
                    }
                }
            }
        }
        virusmin=Math.min(virusmin,infected);
    }
}