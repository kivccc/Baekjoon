import java.util.*;
import java.io.*;
public class Main {
    static int[][] arr;
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s=br.readLine().split(" ");
        int n=Integer.parseInt(s[0]);
        int m=Integer.parseInt(s[1]);
        arr=new int[n][m];
        int[][] answer=new int[n][m];
        boolean[][] mem=new boolean[n][m];
        int[] dirx=new int[]{0,0,-1,1};
        int[] diry=new int[]{1,-1,0,0};
        int[] start=new int[2];
        for(int i=0;i<n;i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                int val=Integer.parseInt(st.nextToken());    
                arr[i][j]=val;
                if(val==2){
                    start[0]=i;
                    start[1]=j;
                }
            }
        }
        Deque<int[]> q=new ArrayDeque<>();
        q.addLast(new int[]{start[0],start[1],0});
        while(!q.isEmpty()){
            int[] pos=q.poll();
            if(!mem[pos[0]][pos[1]]){
                mem[pos[0]][pos[1]]=true;
                answer[pos[0]][pos[1]]=pos[2];
                for(int i=0;i<4;i++){
                    int nexty=pos[0]+diry[i];
                    int nextx=pos[1]+dirx[i];
                    if(isAble(nexty,nextx) && arr[nexty][nextx]!=0)
                        q.addLast(new int[]{nexty,nextx,pos[2]+1});
                }
            }
        }
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                int val=answer[i][j];
                if(val==0 && arr[i][j]==1)
                    sb.append(-1).append(" ");    
                else
                    sb.append(val).append(" ");    
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
	}
    
    public static boolean isAble(int y,int x){
        if(0<=y && y<arr.length && 0<=x && x<arr[0].length)
            return true;
        else
            return false;
    }
}