import java.util.*;
import java.io.*;
public class Main {
    static int[][]arr; 
    static int M; 
    static int N; 
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s=br.readLine().split(" ");
        M=Integer.parseInt(s[0]);
        N=Integer.parseInt(s[1]);
        arr=new int[N][M];
        int[] diry=new int[]{1,-1,0,0};
        int[] dirx=new int[]{0,0,1,-1};
        int[][] mem=new int[N][M];
        ArrayList<int[]> list=new ArrayList<>();
        for(int i=0;i<N;i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                int val=Integer.parseInt(st.nextToken());
                arr[i][j]=val;
                if(val==1)
                    list.add(new int[]{i,j});
            }
        }
        
        //for(int[]a:arr)
        //    System.out.println(Arrays.toString(a));
        //System.out.println();
    
        if(firstCheck()){
            System.out.println(0);
            return;
        }
        
        Deque<int[]> q=new ArrayDeque<>();
        for(int[]a:list)
            q.add(new int[]{a[0],a[1],0});
        int answer=0;
        while(!q.isEmpty()){
            int[] a=q.poll();
            int y=a[0];
            int x=a[1];
            if(mem[y][x]==0){
                mem[y][x]=a[2];
                if(answer<a[2])
                    answer=a[2];
                for(int i=0;i<4;i++){
                    if(isAble(y+diry[i],x+dirx[i]))
                        q.addLast(new int[]{y+diry[i],x+dirx[i],a[2]+1});
                }
            }
        }
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++)
                if(arr[i][j]==0 && mem[i][j]==0){
                    System.out.println(-1);
                    return;
                }
        }
        System.out.println(answer);
        //for(int[]a:mem)
        //    System.out.println(a[0]+" "+a[1]);
        
    } 
    
    public static boolean firstCheck(){
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++)
                if(arr[i][j]==0)
                    return false;
        }
        return true;
    }
    
    public static boolean isAble(int y,int x){
        if(0<=y && y<N && 0<=x && x<M && arr[y][x]==0)
            return true;
        else
            return false;
    }
    
    
}