import java.util.*;
import java.io.*;
public class Main {
    public static int n;
    public static int[][] arr;
    public static int[][] dp;
    public static class Node{
        int y;
        int x;
        int dir; // 가로 0 세로 1 대각선 2
        public Node(int y,int x,int dir){
            this.y=y;
            this.x=x;
            this.dir=dir;
        }
    }
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(br.readLine());
        arr=new int[n+1][n+1];
        dp=new int[n+1][n+1];
        for(int i=0;i<n;i++){
            arr[i][n]=2;
            arr[n][i]=2;
        }    
        for(int i=0;i<n;i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                arr[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        
        Deque<Node> q=new ArrayDeque<>();
        q.add(new Node(0,1,0));
        
        while(!q.isEmpty()){
            //print();
            Node curnode=q.poll();
            int y=curnode.y;
            int x=curnode.x;
            if(curnode.dir==0){
                if(arr[y][x+1]!= 0) continue;
                q.add(new Node(y,x+1,0)); //가로->가로
                dp[y][x+1]++;
                if(arr[y+1][x+1] != 0 || arr[y+1][x] != 0 ) continue;
                q.add(new Node(y+1,x+1,2)); // 가로->대각선
                dp[y+1][x+1]++;
            }
            else if(curnode.dir==1){
                if(arr[y+1][x]!= 0) continue;
                q.add(new Node(y+1,x,1)); //세로->세로
                dp[y+1][x]++;
                if(arr[y+1][x+1] != 0 || arr[y][x+1] != 0 ) continue;
                q.add(new Node(y+1,x+1,2)); // 세로->대각선
                dp[y+1][x+1]++;
            }
            else if(curnode.dir==2){
                if(arr[y+1][x+1]== 0 && arr[y][x+1]== 0 && arr[y+1][x]== 0 ){
                    q.add(new Node(y+1,x+1,2)); 
                    dp[y+1][x+1]++;
                }
                if(arr[y][x+1]== 0){
                    q.add(new Node(y,x+1,0)); 
                    dp[y][x+1]++;
                }
                if(arr[y+1][x]== 0){
                    q.add(new Node(y+1,x,1)); 
                    dp[y+1][x]++;
                    
                }
            }
        }
        System.out.println(dp[n-1][n-1]);
        //Scanner sc=new Scanner(System.in);
        //int n=sc.nextInt();
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	}
    public static void print(){
        for(int[]i:dp)
            System.out.println(Arrays.toString(i));
        System.out.println();
    }
}