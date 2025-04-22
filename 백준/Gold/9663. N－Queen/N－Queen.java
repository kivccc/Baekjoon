import java.util.*;
import java.io.*;
public class Main {
    public static int N;
    public static int answer;
    public static int[] board;
    public boolean[][] visit;
	public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());
        board=new int[N];
        answer=0;
        dfs(0);        
        System.out.println(answer);
        //int N=Integer.parseInt(br.readLine());
        //Scanner sc=new Scanner(System.in);
        //int N=sc.nextInt();
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	}
    
    public static void dfs(int depth){
        if(depth==N){
            answer++;
            return;
        }
        for(int col=0;col<N;col++){
            board[depth]=col;
            if(isAble(depth))
                dfs(depth+1);
        }
    }
    
    public static boolean isAble(int row) {
        for(int i=0;i<row;i++){
            if (board[i] == board[row] || Math.abs(row - i) == Math.abs(board[row] - board[i])) 
                return false;
        }
        return true;
    }
}