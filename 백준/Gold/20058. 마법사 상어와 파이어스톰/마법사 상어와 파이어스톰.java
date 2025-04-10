import java.util.*;
import java.io.*;
public class Main {
    public static int[][] icemap;
    public static int[] Ldata;
    public static int N;
    public static int Q;
    public static int pow=1; // 2 ^ N
    public static boolean[][] visit;
    public static int[] dx = {-1, 1, 0, 0}; 
    public static int[] dy = {0, 0, -1, 1};
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        Q=Integer.parseInt(st.nextToken());
        for(int i=0;i<N;i++)
            pow*=2;
        icemap=new int[pow][pow];
        Ldata=new int[Q];
        for(int i=0;i<pow;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<pow;j++){
                icemap[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<Q;i++)
            Ldata[i]=Integer.parseInt(st.nextToken());
        for(int i=0;i<Q;i++){
            rotate(Ldata[i]);
            iceloss();
        }
        visit=new boolean[pow][pow];
        int icesum=0;
        int max=0;
        for(int i=0;i<pow;i++){
            for(int j=0;j<pow;j++){
                if(!visit[i][j] && icemap[i][j]>0){
                    int size=bfs(i,j);
                    max=Math.max(max,size);
                }
                icesum+=icemap[i][j];
            }
        }
        System.out.println(icesum);
        System.out.println(max);
        /*
        for(int[]a:icemap)
            System.out.println(Arrays.toString(a));
        */
	}
    public static void rotate(int L){
        if(L==0)
            return;
        int lpow=1; // 2 ^ L
        for(int i=0;i<L;i++)
            lpow*=2;
        int count=(pow/lpow);
        for(int i=0;i<count;i++){
            for(int j=0;j<count;j++){
                subrotate(i*pow/count,j*pow/count,pow/count);
            }
        }
    }
    public static void subrotate(int y,int x,int len){
        int[][] tmp=new int[len][len];
        for(int i=0;i<len;i++){
            for(int j=0;j<len;j++){
                tmp[j][len-1-i]=icemap[y+i][x+j];
            }
        }
        for(int i=0;i<len;i++){
            for(int j=0;j<len;j++){
                icemap[y+i][x+j]=tmp[i][j];
            }
        }
    }
    public static void iceloss(){
        ArrayList<int[]> list=new ArrayList<>();
        for(int i=0;i<pow;i++){
            for(int j=0;j<pow;j++){
                int icecount=0;
                if(i-1>=0  && icemap[i-1][j]>0)    icecount++;
                if(i+1<pow && icemap[i+1][j]>0)    icecount++;
                if(j-1>=0  && icemap[i][j-1]>0)    icecount++;
                if(j+1<pow && icemap[i][j+1]>0)    icecount++;
                if(icecount<3)
                    list.add(new int[]{i,j});
            }
        }
        for(int[] i:list)
            if(icemap[i[0]][i[1]]>0)
                icemap[i[0]][i[1]]--;
    }
    public static int bfs(int y,int x){
        Deque<int[]> q=new ArrayDeque<>();
        
        q.add(new int[]{y,x});
        visit[y][x]=true;
        int count=1;
        while(!q.isEmpty()){
            int[] val=q.poll();
            int cury=val[0],curx=val[1];
            for(int i=0;i<4;i++){
                int nexty=cury+dy[i];
                int nextx=curx+dx[i];
                if(0<=nexty && nexty<pow && 0<=nextx && nextx<pow){
                    if(!visit[nexty][nextx] && icemap[nexty][nextx]>0){
                        q.add(new int[]{nexty,nextx});
                        visit[nexty][nextx]=true;
                        count++;
                    }
                }
            }
        }
        return count;
    }
}