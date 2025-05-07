import java.util.*;
import java.io.*;
public class Main {
    public static int N;
    public static int[][] map;
    public static int[] pos=new int[2]; //상어 y,x
    public static int size=2; //상어 크기
    public static int ate=0; //상어 크기
    public static int[] diry={-1,1,0,0}; 
    public static int[] dirx={0,0,-1,1}; 
    public static int sec=0; 
	public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());
        map=new int[N][N];

        for(int i=0;i<N;i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                int val=Integer.parseInt(st.nextToken());
                if(val==9){
                    pos[0]=i;
                    pos[1]=j;
                }
                map[i][j]=val;
            }
        }
        map[pos[0]][pos[1]]=0;
        while(bfs(pos[0],pos[1])){
        }
        
        //
        //Scanner sc=new Scanner(System.in);
        //int N=sc.nextInt();
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	}
    
    public static boolean bfs(int y,int x){
        boolean[][] visit=new boolean[N][N];
        Deque<int[]> dq=new ArrayDeque<>();
        dq.add(new int[]{y,x,0});
        visit[y][x]=true;
        
        PriorityQueue<int[]> pq=new PriorityQueue<>((e1,e2)->{
            if(e1[0]!=e2[0])
                return e1[0]-e2[0];
            else
                return e1[1]-e2[1];
        });
        int shortest=0;
        while(!dq.isEmpty()){
            int[] val=dq.poll();
            int cury=val[0];
            int curx=val[1];
            
            if(!(cury==y && curx==x)){
                if(shortest==0 && map[cury][curx]!=0 && size>map[cury][curx]){
                    shortest=val[2];
                    pq.add(new int[]{cury,curx});
                }
                else if(shortest==val[2] && map[cury][curx]!=0 && size>map[cury][curx])
                    pq.add(new int[]{cury,curx});
            }
            if(shortest!=0 && shortest<val[2])
                continue;
            for(int i=0;i<4;i++){
                int ny=cury+diry[i];
                int nx=curx+dirx[i];
                if(ny<0 || N<= ny ||nx<0 || N<= nx) continue;
                if(visit[ny][nx]) continue;
                if(map[ny][nx]==0 || size>=map[ny][nx]){
                    dq.add(new int[]{ny,nx,val[2]+1});
                    visit[ny][nx]=true;
                }
            }
        }
        if(pq.isEmpty()){
            System.out.println(sec);
            return false;
        }
        else{
            int[] val=pq.poll();
            pos[0]=val[0];
            pos[1]=val[1];
            map[val[0]][val[1]]=0;
            sec+=shortest;
            ate++;
            if(ate==size){
                ate=0;
                size++;
            }

            return true;
        }
    }
}