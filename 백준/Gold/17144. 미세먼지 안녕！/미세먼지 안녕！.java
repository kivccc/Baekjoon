import java.util.*;
import java.io.*;
public class Main {
    public static int r;
    public static int c;
    public static int t;
    public static int bottom;
    public static int[][] arr;
    public static int[] dy=new int[]{-1,1,0,0};
    public static int[] dx=new int[]{0,0,-1,1};
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        r=Integer.parseInt(st.nextToken());        
        c=Integer.parseInt(st.nextToken());        
        t=Integer.parseInt(st.nextToken());        
        arr=new int[r][c];
        for(int i=0;i<r;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<c;j++){
                int val=Integer.parseInt(st.nextToken());
                if(val==-1)
                    bottom=i;
                arr[i][j]=val;
            }
        }
        for(int i=1;i<=t;i++){
            arr=dust(); 
            blow();
            /*
            for(int[]a:arr){
                System.out.println(Arrays.toString(a));
            }
            */
        }
        int answer=0;
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                int val=arr[i][j];
                if(val!=-1)
                    answer+=val;
            }
        }
        System.out.println(answer);
        //int N=Integer.parseInt(br.readLine());
        //Scanner sc=new Scanner(System.in);
        //int N=sc.nextInt();
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	}
    
    public static int[][] dust(){
        int[][] after=new int[r][c];
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                int mid=arr[i][j];
                if(mid==-1) continue;
                int left=mid/5;
                for(int idx=0;idx<4;idx++){
                    int ny=i+dy[idx];
                    int nx=j+dx[idx];
                    if(ny<0 || r<=ny || nx<0 || c<=nx) continue;
                    if(arr[ny][nx]==-1) continue;
                    after[ny][nx]+=left;
                    mid-=left;
                }             
                after[i][j]+=mid;
            }
        }
        after[bottom-1][0]=-1;
        after[bottom][0]=-1;
        return after;
    }
    
    public static void blow(){
        for(int y=bottom-1;y>=1;y--)
            arr[y][0]=arr[y-1][0];
        arr[bottom-1][0]=-1;
        for(int x=0;x<c-1;x++)
            arr[0][x]=arr[0][x+1];
        for(int y=0;y<bottom-1;y++)
            arr[y][c-1]=arr[y+1][c-1];
        for(int x=c-1;x>1;x--)
            arr[bottom-1][x]=arr[bottom-1][x-1];
        arr[bottom-1][1]=0;
        
        for(int y=bottom;y<r-1;y++)
            arr[y][0]=arr[y+1][0];
        arr[bottom][0]=-1;
        for(int x=0;x<c-1;x++)
            arr[r-1][x]=arr[r-1][x+1];
        for(int y=r-1;y>bottom;y--)
            arr[y][c-1]=arr[y-1][c-1];
        for(int x=c-1;x>1;x--)
            arr[bottom][x]=arr[bottom][x-1];
        arr[bottom][1]=0;
        
    }
}