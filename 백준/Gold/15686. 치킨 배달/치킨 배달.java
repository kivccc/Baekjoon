import java.util.*;
import java.io.*;
public class Main {
    public static int N;
    public static int M;
    public static int ans=Integer.MAX_VALUE;
    public static ArrayList<int[]> houselist=new ArrayList<>();
    public static ArrayList<int[]> chiklist=new ArrayList<>();
    public static int[] pick;
    public static int[][] distarr;
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        pick=new int[M];
        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                int val=Integer.parseInt(st.nextToken());
                if(val==1) 
                    houselist.add(new int[]{i,j});
                else if(val==2) 
                    chiklist.add(new int[]{i,j});
            }
        }
        distarr=new int[houselist.size()][chiklist.size()];
        for(int i=0;i<houselist.size();i++){
            int[] house=houselist.get(i);
            for(int j=0;j<chiklist.size();j++){
                int[] chik=chiklist.get(j);
                distarr[i][j]=Math.abs(house[0]-chik[0])+Math.abs(house[1]-chik[1]);
            }
        }
        dfs(0,0);
        System.out.println(ans);
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	}
    
    public static void dfs(int depth,int idx){
        if(depth==M){
            int tans=0;
            for(int i=0;i<houselist.size();i++){
                int min=Integer.MAX_VALUE;
                for(int j:pick) //치킨집픽 인덱스
                    min=Math.min(min,distarr[i][j]);
                tans+=min;
            }
            ans=Math.min(ans,tans);
            return;
        }
        
        for(int i=idx;i<chiklist.size();i++){
            pick[depth]=i;
            dfs(depth+1,i+1);
        }
    }
}