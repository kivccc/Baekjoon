import java.util.*;
import java.io.*;
public class Main {
    static int[] dirY=new int[]{0,1,0,-1};
    static int[] dirX=new int[]{-1,0,1,0};
    static int[][][] sand=new int[][][]{
        {
            {-1,-1},{1,-1},{-1,0},{1,0},{-2,0},{2,0},{-1,1},{1,1},{0,-2}
        },
        {
            {1,1},{1,-1},{0,-1},{0,1},{0,2},{0,-2},{-1,-1},{-1,1},{2,0}
        },
        {
            {-1,1},{1,1},{-1,0},{1,0},{-2,0},{2,0},{-1,-1},{1,-1},{0,2}
        },
        {
            {-1,-1},{-1,1},{0,-1},{0,1},{0,-2},{0,2},{1,-1},{1,1},{-2,0}
        }
    };// 10 10 7 7 2 2 1 1 5
    static int[][] arr;
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        arr=new int[N+4][N+4];
        for(int i=0;i<N;i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                arr[i+2][j+2]=Integer.parseInt(st.nextToken());
            }
        }
        int posY=N/2+2,posX=N/2+2,dir=0;
        for(int i=1;i<=N-1;i++){
            for(int j=0;j<i;j++){
                moveSand(posY,posX,dir);
                posY+=dirY[dir];
                posX+=dirX[dir];
            }
            dir=(dir+1)%4;
            for(int j=0;j<i;j++){
                moveSand(posY,posX,dir);
                posY+=dirY[dir];
                posX+=dirX[dir];
            }
            dir=(dir+1)%4;
        }
        for(int i=0;i<N-1;i++){
            moveSand(posY,posX,dir);
            posY+=dirY[dir];
            posX+=dirX[dir];
        }
        int ans=0;
        for(int i=0;i<N+4;i++){
            for(int j=0;j<N+4;j++){
                if (i<=1||i>=N+2||j<=1||j>=N+2) 
                    ans+=arr[i][j];
            }
        }
        System.out.println(ans);        
	}
    public static void moveSand(int y,int x,int d){
        int nexty=y+dirY[d];
        int nextx=x+dirX[d];
        if(arr[nexty][nextx]==0)
            return;
        int og=arr[nexty][nextx];
        int[] tmp=new int[5]; //10 7 2 1 5
        tmp[0]=(og*10)/100;
        tmp[1]=(og*7)/100;
        tmp[2]=(og*2)/100;
        tmp[3]=(og*1)/100;
        tmp[4]=(og*5)/100;
        int sum=0;
        for(int i=0;i<4;i++)
            sum+=tmp[i]*2;
        sum+=tmp[4];
        for(int i=0;i<9;i++){
            int sandY=nexty+sand[d][i][0];
            int sandX=nextx+sand[d][i][1];
            arr[sandY][sandX]+=tmp[i/2];
        }
        arr[nexty][nextx]=0;
        arr[nexty+dirY[d]][nextx+dirX[d]]+=og-sum;
    }
}