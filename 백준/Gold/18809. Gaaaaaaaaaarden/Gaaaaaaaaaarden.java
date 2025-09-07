import java.util.*;
import java.io.*;
public class Main {
    static int n;
    static int m;
    static int g;
    static int r;
    static int answer=0;
    static int [][] map; //0 호수, 1 배양액 불가,2는 배양액 가능
    static ArrayList<int[]> liquidList = new ArrayList<>(); // 배양액뿌리는거 가능한 좌표
    static ArrayList<Integer> greenPos = new ArrayList<>(); // 초록이 가져가는 lisuqList에서의 인덱스
    static ArrayList<Integer> redPos = new ArrayList<>(); // 발강이 가져가는 lisuqList에서의 인덱스
    static int[] diry = new int[]{-1,1,0,0};
    static int[] dirx = new int[]{0,0,-1,1};
    
	public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st=new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        g=Integer.parseInt(st.nextToken());
        r=Integer.parseInt(st.nextToken());
        map = new int[n][m];
        for(int i=0;i<n;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                int val = Integer.parseInt(st.nextToken());        
                map[i][j] = val;
                if(val==2)
                    liquidList.add(new int[]{i,j});
            }
        }
        dfsGreen(0,0);
        System.out.println(answer);
        //int n=Integer.parseInt(br.readLine());
        //Scanner sc=new Scanner(System.in);
        //int n=sc.nextInt();
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	}
    
    static void dfsGreen(int start,int depth){
        if(depth==g){
            dfsRed(0,0);
            return;
        }
        
        for(int i=start;i<liquidList.size();i++){
            greenPos.add(i);
            dfsGreen(i+1,depth+1);
            greenPos.remove(greenPos.size()-1);
        }
    }
    static void dfsRed(int start,int depth){
        if(depth==r){
            answer=Math.max(answer,getFlower());
            return;
        }
        
        for(int i=start;i<liquidList.size();i++){
            if(greenPos.contains(i)) continue;
            redPos.add(i);
            dfsRed(i+1,depth+1);
            redPos.remove(redPos.size()-1);
        }
    }
    
    
    static int getFlower(){
        int [][][] tmpMap = new int[n][m][2];
        // [0] 0 이면 빈칸 ,1이면 그린 ,2이면 빨강, 3이면 빨+그린 
        // [1] 시간
        Deque<int[]> q = new ArrayDeque<>();
        
        for(int i=0;i<g;i++){
            int[] pos = liquidList.get(greenPos.get(i));
            tmpMap[pos[0]][pos[1]][0]=1;
            tmpMap[pos[0]][pos[1]][1]=0;
            q.add(new int[]{pos[0],pos[1],1,0});
        }
        for(int i=0;i<r;i++){
            int[] pos = liquidList.get(redPos.get(i));
            tmpMap[pos[0]][pos[1]][0]=2;
            tmpMap[pos[0]][pos[1]][1]=0;
            q.add(new int[]{pos[0],pos[1],2,0});
        }
        
        while(!q.isEmpty()){
            int[] cur=q.poll();
            if(tmpMap[cur[0]][cur[1]][0]==3) continue; //본인 꽃봉오리면 패스
            for(int i=0;i<4;i++){
                int nexty=cur[0]+diry[i];
                int nextx=cur[1]+dirx[i];
                if(nexty < 0 || nexty >= n || nextx < 0 || nextx >= m ) continue;
                if(map[nexty][nextx] == 0 ) continue; //호수일 경우
                
                //이미 색 동일 or 이미 꽃봉오리
                if(tmpMap[nexty][nextx][0] == cur[2] ||tmpMap[nexty][nextx][0] == 3  ) continue; 
                
                if(tmpMap[nexty][nextx][0] == 0){ //빈칸이면
                    tmpMap[nexty][nextx][0]=cur[2]; //지 색으로 색칠
                    tmpMap[nexty][nextx][1]=cur[3]+1; 
                    q.add(new int[]{nexty,nextx,cur[2],cur[3]+1});
                }
                else if(tmpMap[nexty][nextx][1] == cur[3]+1 ){ //자기랑 다른색이고 시간이 동일하면
                    tmpMap[nexty][nextx][0]+=cur[2];
                }
            }
        }
        int count=0;
        for(int i=0;i<n;i++)
            for(int j=0;j<m;j++)
                if(tmpMap[i][j][0]==3)
                    count++;
        return count;
    }
}