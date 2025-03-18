import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                arr[i][j] = 1000000;
                if (i == j) {
                    arr[i][j] = 0;
                }
            }
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[x][y] = arr[y][x] = 1;
        }
        
        for(int k=1;k<=N;k++)
            for(int i=1;i<=N;i++)
                for(int j=1;j<=N;j++)
                    arr[i][j] = Math.min(arr[i][j],arr[i][k]+arr[k][j]);
        
        int max=Integer.MAX_VALUE;
        int answer=-1;
        for (int i=1;i<=N;i++) {
            int total = 0;
            for (int j = 1; j <= N; j++) 
                total += arr[i][j];
            if (max > total) {
                max = total;
                answer = i;
            }
        }     
        System.out.println(answer);
        //StringTokenizer st=new StringTokenizer(br.readLine());
        //int N=Integer.parseInt(st.nextToken());
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	}
}