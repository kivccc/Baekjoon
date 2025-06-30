import java.util.*;
import java.io.*;
public class Main {
    public static int n;
    public static int k;
    public static int[][] arr;
    public static int[] diry=new int[]{-1,1,0,0};
    public static int[] dirx=new int[]{0,0,-1,1};
    public static boolean[][] visit;
	public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        k=Integer.parseInt(st.nextToken());
        arr=new int[n][n];
        visit=new boolean[n][n];
        
        for(int i=0;i<n;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                arr[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        st=new StringTokenizer(br.readLine());
        int s=Integer.parseInt(st.nextToken());
        int y=Integer.parseInt(st.nextToken())-1;
        int x=Integer.parseInt(st.nextToken())-1;
                
        Deque<int[]>q=new ArrayDeque<>();
        q.add(new int[]{y,x,0});
        visit[y][x]=true;
        PriorityQueue<Integer>pq=new PriorityQueue<>();
        int foundsec=s+1;
        while(!q.isEmpty()){
            int[] tmp=q.poll();
            int cury=tmp[0];
            int curx=tmp[1];
            if(arr[cury][curx]!=0){
                if(foundsec<tmp[2])
                    break;
                pq.add(arr[cury][curx]);
                foundsec=tmp[2];
            }
            for(int i=0;i<4;i++){
                int nexty=cury+diry[i];
                int nextx=curx+dirx[i];
                if(nexty<0 || nexty>=n || nextx<0 || nextx>=n) continue;
                if(visit[nexty][nextx]) continue;
                if(tmp[2]>=s) continue;
                q.add(new int[]{nexty,nextx,tmp[2]+1});
                visit[nexty][nextx]=true;
            }
        }
        if(pq.isEmpty())
            System.out.println(0);
        else
            System.out.println(pq.poll());

        //int n=Integer.parseInt(br.readLine());
        //Scanner sc=new Scanner(System.in);
        //int n=sc.nextInt();
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	}
}