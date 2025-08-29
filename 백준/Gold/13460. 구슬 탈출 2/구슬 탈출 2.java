import java.util.*;
import java.io.*;
public class Main {
    static int[][] map;
    static int[] red;
    static int[] blue;
    static int[] hole;
    static int n;
    static int m;
    // 0 : 위 , 1 : 아래 , 2: 왼 , 3: 오른
    static int[] diry = new int[]{-1,1,0,0};
    static int[] dirx = new int[]{0,0,-1,1}; 
    static boolean[][][][] visit;
   public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        map = new int[n][m]; // 1은 벽, 0은 빈공간
        visit = new boolean[n][m][n][m];
        red = new int[2];
        blue = new int[2];
        hole = new int[2];
        for(int i=0;i<n;i++){
            String input=br.readLine();
            for(int j=0;j<m;j++){
                char c=input.charAt(j);
                if(c=='#')
                    map[i][j]=1;
                else if(c == 'B'){
                    blue[0] = i;
                    blue[1] = j;
                }
                else if(c =='R'){
                    red[0] = i;
                    red[1] = j;
                }
                else if(c=='O'){
                    hole[0] = i;
                    hole[1] = j;
                }
            }
        }
        //for(int[]a:map)
        //    System.out.println(Arrays.toString(a));
        //System.out.println(Arrays.toString(red));
        //System.out.println(Arrays.toString(blue));
        //System.out.println(Arrays.toString(hole));

        Deque<int[]> q=new ArrayDeque<>();
        q.add(new int[]{red[0],red[1],blue[0],blue[1],0}); // y , x , 
        visit[red[0]][red[1]][blue[0]][blue[1]]=true;
        boolean isAble=false;
        while(!q.isEmpty()){
            int[] cur=q.poll();
            int count=cur[4];
            if(count==10)
                continue;
            //System.out.println();
            for(int i=0;i<4;i++){
                int dir=i;
                int yred=cur[0];
                int xred=cur[1];
                int yblue=cur[2];
                int xblue=cur[3];
                //방향이 정해짐
                boolean blueflag=false; //파랑이 구멍에들어가면 true
                boolean redflag=false; //빨강이 구멍에들어가면 true
                if(isRedFirst(dir,yred,xred,yblue,xblue)){ //빨강먼저
                    //빨강먼저 벽까지 보내고
                    
                    while(true){
                        yred+=diry[dir];
                        xred+=dirx[dir];
                        if(map[yred][xred]==1) break; //벽을만나면
                        
                        if(hole[0]==yred && hole[1]==xred){ //구멍도착
                            redflag=true;
                            break;
                        }
                    }
                    if(!redflag){
                        yred-=diry[dir];
                        xred-=dirx[dir]; //벽을 만났으니 벽만나기전 좌표로 조정
                    }
                    else{
                        yred=0;
                        xred=0;
                    }
                    //그다음 파랑을 보냄
                    while(true){
                        
                        yblue+=diry[dir];
                        xblue+=dirx[dir];
                        if(yblue == yred && xblue == xred) break; //먼저움직인 빨강만나면
                        if(map[yblue][xblue]==1) break; //벽을만나면
                        
                        if(hole[0]==yblue && hole[1]==xblue){ //구멍도착
                            blueflag=true;
                            break;
                        }
                    }
                    yblue-=diry[dir];
                    xblue-=dirx[dir]; //벽이나 빨강 만났으니 만나기전 좌표로 조정
                    if(redflag){
                        if(!blueflag){ //빨강구멍 o , 파랑 구멍 x
                            System.out.println(count+1);
                            isAble=true;
                            return;
                        }
                        else
                            continue;
                    }
                    
                    
                    //파랑이 안빠지고 안방문했으면
                    if(!blueflag && !visit[yred][xred][yblue][xblue]){
                        int[] next=new int[]{yred,xred,yblue,xblue,count+1};
                        //System.out.println(Arrays.toString(cur)+" from");
                        //System.out.println(Arrays.toString(next)+"   to");
                        q.add(next);
                        visit[yred][xred][yblue][xblue]=true;
                    }
                    
                }
                else{
                    //이번엔 파랑먼저보냄
                    while(true){
                        yblue+=diry[dir];
                        xblue+=dirx[dir];
                        if(map[yblue][xblue]==1) break; //벽을만나면
                        
                        if(hole[0]==yblue && hole[1]==xblue){ //구멍도착
                            blueflag=true;
                            break;
                        }
                    }
                    if(blueflag)
                        continue;
                    
                    yblue-=diry[dir];
                    xblue-=dirx[dir]; //벽 만났으니 만나기전 좌표로 조정
                    
                   
                    while(true){
                        yred+=diry[dir];
                        xred+=dirx[dir];
                        if(yblue == yred && xblue == xred) break; //먼저움직인 파랑만나면
                        if(map[yred][xred]==1) break; //벽을만나면
                        
                        if(hole[0]==yred && hole[1]==xred){ //구멍도착
                            System.out.println(count+1);
                            isAble=true;
                            return;
                        }
                    }
                    yred-=diry[dir];
                    xred-=dirx[dir]; //벽을 만났으니 벽만나기전 좌표로 조정
                    
                    //파랑이 안빠지고 안방문했으면
                    if(!visit[yred][xred][yblue][xblue]){
                        int[] next=new int[]{yred,xred,yblue,xblue,count+1};
                        
                        //System.out.println(Arrays.toString(cur)+" from");
                        //System.out.println(Arrays.toString(next)+"   to");
                        q.add(next);
                        visit[yred][xred][yblue][xblue]=true;
                    }
                    
                }
            }
            

        }
        if(!isAble)
            System.out.println(-1);
        
        //int n=Integer.parseInt(br.readLine());
        //Scanner sc=new Scanner(System.in);
        //int n=sc.nextInt();
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
   }
    
    public static boolean isRedFirst(int dir,int yred,int xred,int yblue,int xblue){
        // 0 : 위 , 1 : 아래 , 2: 왼 , 3: 오른
        if(dir==0)
            return yred<=yblue ? true : false; //위에있어야 먼저감
        else if(dir==1)
            return yred>=yblue ? true : false; //아래에 있어야 먼저감
        else if(dir==2)
            return xred<=xblue ? true : false; //왼쪽에 있어야 먼저감
        else if(dir==3)
            return xred>=xblue ? true : false; //오른쪽에 있어야 먼저감
        return true;
    }
    

}