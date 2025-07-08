import java.util.*;
import java.io.*;
public class Main {
    static class Node{
        int y;
        int x;
        int black;
        Node(int y,int x,int black){
            this.y=y;
            this.x=x;
            this.black=black;
        }
    }
    static int[] diry=new int[]{-1,1,0,0};
    static int[] dirx=new int[]{0,0,-1,1};
	public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc=-1;
        int idx=1;
        while( (tc=Integer.parseInt(br.readLine())) != 0 ){
            int[][] arr=new int[tc][tc];
            int[][] dist=new int[tc][tc];
            
            for(int i=0;i<tc;i++){
                StringTokenizer st=new StringTokenizer(br.readLine());
                for(int j=0;j<tc;j++){
                    arr[i][j]=Integer.parseInt(st.nextToken());
                    dist[i][j]=Integer.MAX_VALUE;
                }
            }
            
            PriorityQueue<Node> pq=new PriorityQueue<>((e1,e2)->{
                return e1.black-e2.black;
            });
            dist[0][0]=arr[0][0];
            pq.add(new Node(0,0,dist[0][0]));
            while(!pq.isEmpty()){
                Node cur=pq.poll();
                int cury=cur.y;
                int curx=cur.x;
                int curblack=cur.black;
                if(curblack>dist[cury][curx]) continue;
                
                for(int i=0;i<4;i++){
                    int nexty=cury+diry[i];
                    int nextx=curx+dirx[i];
                    if(nextx<0 || tc<=nextx || nexty<0 || tc<=nexty ) continue;
                    if(dist[nexty][nextx]>dist[cury][curx]+arr[nexty][nextx]){
                        dist[nexty][nextx]=dist[cury][curx]+arr[nexty][nextx];
                        pq.add(new Node(nexty,nextx,dist[nexty][nextx]));
                    }
                }
            }
            System.out.println("Problem "+(idx++)+":"+" "+dist[tc-1][tc-1]);
        }
            
        

        //Scanner sc=new Scanner(System.in);
        //int n=sc.nextInt();
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	}
}