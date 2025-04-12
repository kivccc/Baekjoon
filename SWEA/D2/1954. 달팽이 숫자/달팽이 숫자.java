import java.util.*;
import java.io.*;
public class Solution {
	public static void main(String args[]) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		StringBuilder sb=new StringBuilder();
		int[] dy=new int[] {-1,0,1,0};
		int[] dx=new int[] {0,1,0,-1};
		for (int i = 0; i < T; i++) {
			int N=Integer.parseInt(br.readLine());
			sb.append("#").append(i+1).append("\n");
			int[][]arr=new int[N][N];
			for (int j = 0; j < arr.length; j++) {
				arr[0][j]=j+1;
			}
			// N, N-1,N-1, N-2,N-2, N-3,N-3, ... 1,1
			//북->동->남->서
			int val=N+1;
			int y=0;
			int x=N-1;
			int dir=2;
			for(int k=N-1;k>=1;k--) {
				for(int idx=0;idx<k;idx++) {
					y+=dy[dir];
					x+=dx[dir];
					arr[y][x]=val++;
				}
				dir=(dir+1)%4;
				for(int idx=0;idx<k;idx++) {
					y+=dy[dir];
					x+=dx[dir];
					arr[y][x]=val++;
				}
				dir=(dir+1)%4;
			}
			for(int[]a:arr) {
				for(int aa:a)
					sb.append(aa).append(" ");
				sb.append("\n");
			}
		}
		System.out.println(sb);
	}
}
