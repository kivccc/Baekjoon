import java.util.*;
import java.io.*;
public class Main {
    public static char[][] arr;
	public static void main(String[] args) throws IOException {
    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N=Integer.parseInt(br.readLine());
        int len=N*2-1;
        arr=new char[N][len];
        for(int i=0; i<N; i++)
            Arrays.fill(arr[i],' ');
        make(0, N-1, N);
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++){
            for(int j=0; j< len; j++){
                sb.append(arr[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
        //
        //Scanner sc=new Scanner(System.in);
        //int N=sc.nextInt();
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	}
    public static void make(int row, int col, int n) {
        if(n==3){
            arr[row][col]='*';
            arr[row+1][col+1] = arr[row+1][col-1] = '*';
            arr[row+2][col-2] = arr[row+2][col-1]  = arr[row+2][col] = arr[row+2][col+1] = arr[row+2][col+2] = '*';
            return;
        }
        
        int cnt=n/2;
        make(row,col,cnt);
        make(row+cnt,col+cnt,cnt);
        make(row+cnt,col-cnt,cnt);
    }
}