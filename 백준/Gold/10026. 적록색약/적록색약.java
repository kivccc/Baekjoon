import java.util.*;
import java.io.*;
public class Main {
    static int[][] arr;
    static int N;
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());
        arr=new int[N][N];
        boolean[][] mem=new boolean[N][N];
        int[] diry=new int[]{1,-1,0,0};
        int[] dirx=new int[]{0,0,1,-1};
        for(int i=0;i<N;i++){
            String s=br.readLine();
            for(int j=0;j<N;j++){
                char c=s.charAt(j);
                if(c=='R')
                    arr[i][j]=0;
                else if(c=='G')
                    arr[i][j]=1;
                else if(c=='B')
                    arr[i][j]=2;
            }
        }
        int answer=0;
        Deque<int[]> q=new ArrayDeque<>();
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(!mem[i][j]){
                    answer++;
                    q.addLast(new int[]{i,j,arr[i][j]});
                    while(!q.isEmpty()){
                        int[] val=q.poll();
                        for(int a=0;a<4;a++){
                            int nexty=val[0]+diry[a];
                            int nextx=val[1]+dirx[a];
                            if(isAble(nexty,nextx) && arr[nexty][nextx]==val[2] && !mem[nexty][nextx]){
                                q.addLast(new int[]{nexty,nextx,val[2]});
                                mem[nexty][nextx]=true;
                            }
                        }
                    }
                }
            }
        }
        System.out.print(answer+" ");
        answer=0;
        q=new ArrayDeque<>();
        mem=new boolean[N][N];
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(!mem[i][j]){
                    answer++;
                    q.addLast(new int[]{i,j,arr[i][j]});
                    while(!q.isEmpty()){
                        int[] val=q.poll();
                        for(int a=0;a<4;a++){
                            int nexty=val[0]+diry[a];
                            int nextx=val[1]+dirx[a];
                            if(isAble(nexty,nextx) && !mem[nexty][nextx]){
                                if( (val[2]==arr[nexty][nextx]) || (val[2]!=2 && arr[nexty][nextx]!=2)){
                                    q.addLast(new int[]{nexty,nextx,val[2]});
                                    mem[nexty][nextx]=true;    
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println(answer);
        //StringTokenizer st=new StringTokenizer(br.readLine());
        //int N=Integer.parseInt(st.nextToken());
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	}
    
    public static boolean isAble(int y,int x){
        if( 0<=y && y<N && 0<=x && x<N )
            return true;
        else
            return false;
    }
}