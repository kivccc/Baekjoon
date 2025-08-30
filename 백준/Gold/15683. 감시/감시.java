import java.util.*;
import java.io.*;
public class Main {
    static class Tv{
        int y;
        int x;
        int type;
        Tv(int y, int x, int type){
            this.y=y;
            this.x=x;
            this.type=type;
        }
    }
    static int n;
    static int m;
    static int[][] map; // 0 : 빈칸, 6 : 벽, 1~5 : cctv번호
    static int[] mem; 
    static ArrayList<Tv> tvlist=new ArrayList<Tv>();
    static int wallcount=0;
    static int answer=Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        map = new int[n][m];
        
        for(int i=0;i<n;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                int val = Integer.parseInt(st.nextToken());
                if(1 <= val && val<=5)
                    tvlist.add(new Tv(i,j,val));
                else if(val==6)
                    wallcount++;
                map[i][j] = val;
            }
        }
        
        mem = new int[tvlist.size()];
        dfs(0);

        System.out.println(answer);
	}
    
    
    static void dfs(int listidx){
        if(listidx==tvlist.size()){
            boolean [][] check = new boolean [n][m];
            for(int i=0;i<tvlist.size();i++)
                checkArea(tvlist.get(i),mem[i],check);
            int nm=n*m;
            int tvsize=tvlist.size();
            int curanswer=getAnswer(check); //샵의개수 
            answer=Math.min(answer,nm-tvsize-curanswer-wallcount);
            return;
        }
        Tv curtv=tvlist.get(listidx);
        if(curtv.type==1 || curtv.type==3 || curtv.type==4 ){
            for(int i=0;i<4;i++){
                mem[listidx]=i;
                dfs(listidx+1);
            }
        }
        else if( curtv.type==2 ){
            for(int i=0;i<2;i++){
                mem[listidx]=i;
                dfs(listidx+1);
            }
        }
        else if( curtv.type==5 ){
            mem[listidx]=0;
            dfs(listidx+1);
        }
    }
    

    static void checkArea(Tv tv,int dir,boolean[][] check){
        int y=tv.y;
        int x=tv.x;
        int type=tv.type;
        if(type == 1){
            if(dir==0)
                checkLeft(y,x,check);
            else if(dir==1)
                checkDown(y,x,check);
            else if(dir==2)
                checkRight(y,x,check);
            else if(dir==3)
                checkUp(y,x,check);
        }
        else if( type == 2){
            if(dir==0){ //좌우
                checkLeft(y,x,check);
                checkRight(y,x,check);
            }
            else if(dir==1){ //위아래
                checkUp(y,x,check);
                checkDown(y,x,check);
            }
        }
        else if( type == 3){
            if(dir==0){
                checkUp(y,x,check);
                checkRight(y,x,check);
            }
            else if(dir==1){
                checkRight(y,x,check);
                checkDown(y,x,check);
            }
            else if(dir==2){
                checkDown(y,x,check);
                checkLeft(y,x,check);
            }
            else if(dir==3){
                checkLeft(y,x,check);
                checkUp(y,x,check);
            }
        }
        else if( type == 4){
            if(dir==0){
                checkLeft(y,x,check);
                checkUp(y,x,check);
                checkRight(y,x,check);
            }
            else if(dir==1){
                checkUp(y,x,check);
                checkRight(y,x,check);
                checkDown(y,x,check);
            }
            else if(dir==2){
                checkRight(y,x,check);
                checkDown(y,x,check);
                checkLeft(y,x,check);
            }
            else if(dir==3){
                checkDown(y,x,check);
                checkLeft(y,x,check);
                checkUp(y,x,check);
            }
        }
        else if( type == 5){
                checkUp(y,x,check);
                checkDown(y,x,check);
                checkLeft(y,x,check);
                checkRight(y,x,check);
        }
    }
    
    static void checkRight(int starty,int startx,boolean[][] check){
        while(startx<m-1){ 
            startx++;
            if( map[starty][startx] == 6) break; //벽을만나면
            if( map[starty][startx] == 0)  //cctv가 아닌 빈공간이면
                check[starty][startx]=true;
        }
    }
    static void checkLeft(int starty,int startx,boolean[][] check){
        while(startx>0){ 
            startx--;
            if( map[starty][startx] == 6) break; //벽을만나면
            if( map[starty][startx] == 0)  //cctv가 아닌 빈공간이면
                check[starty][startx]=true;
        }
    }
    static void checkDown(int starty,int startx,boolean[][] check){
        while(starty<n-1){ 
            starty++;
            if( map[starty][startx] == 6) break; //벽을만나면
            if( map[starty][startx] == 0)  //cctv가 아닌 빈공간이면
                check[starty][startx]=true;
        }
    }
    static void checkUp(int starty,int startx,boolean[][] check){
        while(starty>0){ 
            starty--;
            if( map[starty][startx] == 6) break; //벽을만나면
            if( map[starty][startx] == 0)  //cctv가 아닌 빈공간이면
                check[starty][startx]=true;
        }
    }
    static int getAnswer(boolean[][] check){
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(check[i][j])
                    count++;
            }
        }
        return count;
    }
}