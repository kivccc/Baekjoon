import java.util.*;
import java.io.*;
public class Main {
    static int[] dirY=new int[]{-1,0,1,0};
    static int[] dirX=new int[]{0,1,0,-1};
    static int N;
    static int M;
    static int[][] arr;
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken()); // n x m 좌표
        arr=new int[N][M];              // 0 청소 x , 1 벽 --- 2는 청소완료
        
        st=new StringTokenizer(br.readLine());
        int r=Integer.parseInt(st.nextToken());
        int c=Integer.parseInt(st.nextToken()); // r,c 청소기위치 
        int d=Integer.parseInt(st.nextToken()); // 방향 d 0,1,2,3 (북동남서) 
        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                arr[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        int answer=0;
        while(true){
            if(arr[r][c]==0){ //현재 칸더러우면 청소
                answer++;
                arr[r][c]=2;                
            }
            
            if(isDirty(r,c)){ // 주변 4칸중 더러운게 있으면
                while(true){
                    d=(d+3)%4;
                    if(isDirtyFront(r,c,d)){
                        r=r+dirY[d];
                        c=c+dirX[d];
                        break;
                    }
                }
            }
            else{
                if(isBackAble(r,c,d)){
                    int backd=(d+2)%4;
                    r=r+dirY[backd];
                    c=c+dirX[backd];
                }
                else{
                    System.out.println(answer);
                    return;
                }
            }
        }
        //StringTokenizer st=new StringTokenizer(br.readLine());
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	}
    
    public static boolean isDirty(int y,int x){ //4방향중 더러운곳있으면 true
        for(int i=0;i<4;i++){
            int nexty=y+dirY[i];
            int nextx=x+dirX[i];
            if(0<=nexty && nexty <N  && 0<=nextx && nextx <M)
                if(arr[nexty][nextx]==0)
                    return true;
        }
        return false;
    }
    public static boolean isDirtyFront(int y,int x,int d){ // d방향 앞이 더러우면
        int nexty=y+dirY[d];
        int nextx=x+dirX[d];
        if(0<=nexty && nexty <N  && 0<=nextx && nextx <M)
                if(arr[nexty][nextx]==0)
                    return true;
        return false;
    }
    
    public static boolean isBackAble(int y,int x,int d){
        int backd=(d+2)%4;
        int backy=y+dirY[backd];
        int backx=x+dirX[backd];
        if(backy<0 || N<=backy || backx<0 || M<=backx)
            return false;
        else if(arr[backy][backx]==1)
            return false;
        else
            return true;
    }
    
}