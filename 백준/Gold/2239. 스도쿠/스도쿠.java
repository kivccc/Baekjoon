import java.util.*;
import java.io.*;
public class Main {
    public static int[][]arr;
	public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr=new int[9][9];
        for(int i=0;i<9;i++){
            String line=br.readLine();
            for(int j=0;j<9;j++){
                arr[i][j]=line.charAt(j)-'0';
            }
        }
        solve(0,0);

        //int n=Integer.parseInt(br.readLine());
        //Scanner sc=new Scanner(System.in);
        //int n=sc.nextInt();
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	}
    public static void solve(int row,int col){
        if(col==9){
            solve(row+1,0);
            return;
        }
        
        if(row==9){
            StringBuilder sb=new StringBuilder();
            for(int i=0;i<9;i++){
                for(int j=0;j<9;j++){
                    sb.append(arr[i][j]);
                }
                sb.append("\n");
            }
            System.out.println(sb);
            System.exit(0);
        }
        
        if(arr[row][col]==0){
            for(int i=1;i<=9;i++){
                if(isOk(row,col,i)){
                    arr[row][col]=i;
                    solve(row,col+1);
                    arr[row][col]=0;
                }
            }
        }
        else{
            solve(row,col+1);
        }
    }
    public static boolean isOk(int row,int col,int num){
        for(int i=0;i<9;i++) 
            if(arr[row][i]==num||arr[i][col]==num) return false;
        int startrow=(row/3)*3;
        int startcol=(col/3)*3;
        
        for(int i=startrow;i<startrow+3;i++) 
            for (int j=startcol; j<startcol+3;j++) 
                if (arr[i][j] == num) return false;
        return true;
    }
    
}