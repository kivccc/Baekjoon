import java.util.*;
import java.io.*;
public class Main {
    public static int[][][] mem=new int[101][101][101];
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        while(true){
            StringTokenizer st=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            int c=Integer.parseInt(st.nextToken());
            if(a==-1 && b==-1 && c==-1)
                break;
            sb.append("w(").append(a).append(", ").append(b).append(", ");
            sb.append(c).append(") = ").append(sol(a,b,c));
            sb.append("\n");
            
        }
        //-50 ≤ a, b, c ≤ 50
        System.out.println(sb);         
	}
    public static int sol(int a,int b,int c){
        
        if(mem[a+50][b+50][c+50]!=0)
            return mem[a+50][b+50][c+50];
        if(a<=0 || b<=0 || c<=0){
            mem[a+50][b+50][c+50]=1;
            return 1;
        }
        if(a>20 || b>20 || c>20){
            mem[a+50][b+50][c+50]=sol(20,20,20);
            return mem[a+50][b+50][c+50];
        }
        if(a<b && b<c){
            mem[a+50][b+50][c+50]=sol(a,b,c-1)+sol(a,b-1,c-1)-sol(a,b-1,c);
            return mem[a+50][b+50][c+50];
        }
        else{
            mem[a+50][b+50][c+50]=sol(a-1,b,c)+sol(a-1,b-1,c)+sol(a-1,b,c-1)-sol(a-1,b-1,c-1);
            return mem[a+50][b+50][c+50];
        }
    }
}