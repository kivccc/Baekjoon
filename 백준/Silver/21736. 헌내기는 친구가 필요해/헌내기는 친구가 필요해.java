import java.util.*;
import java.io.*;
public class Main {
    static char[][] arr;
    static int N;
    static int M;
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[]s=br.readLine().split(" ");
        N=Integer.parseInt(s[0]);
        M=Integer.parseInt(s[1]);
        arr=new char[N][M];
        boolean[][] mem=new boolean[N][M];
        int startx=0;
        int starty=0;
        int[] diry=new int[]{1,-1,0,0};
        int[] dirx=new int[]{0,0,1,-1};
        for(int i=0;i<N;i++){
            String line=br.readLine();
            for(int j=0;j<M;j++){
                char c=line.charAt(j);
                arr[i][j]=line.charAt(j);
                if(c=='I'){
                    starty=i;
                    startx=j;
                }
            }
        }
        
        Deque<int[]> q = new ArrayDeque<>();
        q.addLast(new int[]{starty, startx});
        mem[starty][startx] = true; 
        int answer = 0;
        while (!q.isEmpty()) {
            int[] val = q.poll();
            if (arr[val[0]][val[1]] == 'P')
                answer++;

            for (int i = 0; i < 4; i++) {
                int nexty = val[0] + diry[i];
                int nextx = val[1] + dirx[i];
                if (isAble(nexty, nextx) && !mem[nexty][nextx]) {
                    q.addLast(new int[]{nexty, nextx});
                    mem[nexty][nextx] = true; 
                }
            }
        }
        if(answer==0)
            System.out.println("TT");
        else
            System.out.println(answer);
        //StringTokenizer st=new StringTokenizer(br.readLine());
        //int N=Integer.parseInt(st.nextToken());
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	}
    
    public static boolean isAble(int y,int x){
        if(0<=y && y<N && 0<=x && x<M && arr[y][x]!='X')
            return true;
        else 
            return false;
    }
}