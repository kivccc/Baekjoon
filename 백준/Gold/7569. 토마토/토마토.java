import java.util.*;
import java.io.*;
public class Main {
    static int[][][] arr;
    static int M;
    static int N;
    static int H;
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        M=Integer.parseInt(st.nextToken());
        N=Integer.parseInt(st.nextToken());
        H=Integer.parseInt(st.nextToken());
        int[] dirz=new int[]{1,-1,0,0,0,0};
        int[] diry=new int[]{0,0,1,-1,0,0};
        int[] dirx=new int[]{0,0,0,0,1,-1};
        arr=new int[H][N][M];
        int[][][] mem=new int[H][N][M];
        ArrayList<int[]> list=new ArrayList<>();
        for(int height=0;height<H;height++){
            for(int row=0;row<N;row++){
                st=new StringTokenizer(br.readLine());
                for(int col=0;col<M;col++){
                    int val=Integer.parseInt(st.nextToken());
                    arr[height][row][col]=val;
                    if(val==1)
                        list.add(new int[]{height,row,col});
                }
            }
        }
        if(firstCheck()){
            System.out.println(0);
            return;
        }
        Deque<int[]> q=new ArrayDeque<>();
        
        for(int[] a:list)
            q.addLast(new int[]{a[0],a[1],a[2],0});
        int answer=0;
        while(!q.isEmpty()){
            int[] a=q.poll();
            int z=a[0];
            int y=a[1];
            int x=a[2];
            if(mem[z][y][x]==0){
                mem[z][y][x]=a[3];
                if(answer<a[3])
                    answer=a[3];
                for(int i=0;i<6;i++){
                    if(isAble(z+dirz[i],y+diry[i],x+dirx[i]))
                        q.addLast(new int[]{z+dirz[i],y+diry[i],x+dirx[i],a[3]+1});
                }
            }
        }

        for(int k=0;k<H;k++){
            for(int i=0;i<N;i++){
                for(int j=0;j<M;j++)
                    if(arr[k][i][j]==0 && mem[k][i][j]==0){
                        System.out.println(-1);
                        return;
                    }
            }
        }
        System.out.println(answer);
        //StringTokenizer st=new StringTokenizer(br.readLine());
        //int N=Integer.parseInt(st.nextToken());
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	}
    
    public static boolean firstCheck(){
        for(int k=0;k<H;k++){
            for(int i=0;i<N;i++){
                for(int j=0;j<M;j++)
                    if(arr[k][i][j]==0)
                        return false;
            }
        }
        return true;
    }
    
    public static boolean isAble(int z,int y,int x){
        if(0<=z && z<H && 0<=y && y<N && 0<=x && x<M && arr[z][y][x]==0)
            return true;
        else
            return false;
    }
}