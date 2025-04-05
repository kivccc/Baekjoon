import java.util.*;
import java.io.*;
public class Main {
    public static int N;
    public static int M;
    public static int[]dice;
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        int y=Integer.parseInt(st.nextToken());
        int x=Integer.parseInt(st.nextToken());
        int k=Integer.parseInt(st.nextToken());
        int[][] arr=new int[N][M];
        dice=new int[6];
        int[] diry=new int[]{0,0,-1,1};
        int[] dirx=new int[]{1,-1,0,0}; 
        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                arr[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<k;i++){
            int dir=Integer.parseInt(st.nextToken());
            int nexty=y+diry[dir-1];
            int nextx=x+dirx[dir-1];
            if(!isAble(nexty,nextx))
                continue;
            else{
                roll(dir);
                if(arr[nexty][nextx]==0)
                    arr[nexty][nextx]=dice[5];
                else{
                    dice[5]=arr[nexty][nextx];
                    arr[nexty][nextx]=0;
                }
                y=nexty;
                x=nextx;
                System.out.println(dice[0]);
            }
        }
	}
    public static boolean isAble(int y,int x){
        if(0<=y && y< N && 0<=x && x<M)
            return true;
        else
            return false;
    }
    public static void roll(int dir){
        int[] tmp=new int[6];
        if(dir==1){
            tmp[0]=dice[0];
            tmp[2]=dice[2];
            tmp[3]=dice[3];
            tmp[5]=dice[5];
            
            dice[0]=tmp[3];
            dice[2]=tmp[0];
            dice[3]=tmp[5];
            dice[5]=tmp[2];
        }
        else if(dir==2){
            tmp[0]=dice[0];
            tmp[2]=dice[2];
            tmp[3]=dice[3];
            tmp[5]=dice[5];
            
            dice[0]=tmp[2];
            dice[2]=tmp[5];
            dice[3]=tmp[0];
            dice[5]=tmp[3];
        }
        else if(dir==3){
            tmp[0]=dice[0];
            tmp[1]=dice[1];
            tmp[4]=dice[4];
            tmp[5]=dice[5];
            
            dice[0]=tmp[4];
            dice[1]=tmp[0];
            dice[4]=tmp[5];
            dice[5]=tmp[1];
        }
        else if(dir==4){
            tmp[0]=dice[0];
            tmp[1]=dice[1];
            tmp[4]=dice[4];
            tmp[5]=dice[5];
            
            dice[0]=tmp[1];
            dice[1]=tmp[5];
            dice[4]=tmp[0];
            dice[5]=tmp[4];
        }
    }
    
}