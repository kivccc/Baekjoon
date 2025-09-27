import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main{
	static int n;
	static int m;
	static int[][] A;
	static boolean[][] cloud;
	static int[][] cmd;
	static int[] dy = new int[] {0,-1,-1,-1,0,1,1,1};
	static int[] dx = new int[] {-1,-1,0,1,1,1,0,-1}; //←, ↖, ↑, ↗, →, ↘, ↓, ↙ 
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		A = new int[n][n];
		cloud = new boolean[n][n];
		cmd = new int[m][2];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			cmd[i][0] = Integer.parseInt(st.nextToken())-1;
			cmd[i][1] = Integer.parseInt(st.nextToken()) % n;
		}
		
		// first
		cloud[n-1][0] = true;
		cloud[n-1][1] = true;
		cloud[n-2][0] = true;
		cloud[n-2][1] = true;
		
		for(int i=0;i<m;i++) {
			//1 & 2
			int dir = cmd[i][0];
			int power = cmd[i][1];
			boolean[][] waterAdded = new boolean[n][n];
			for (int y = 0; y < n; y++) {
				for (int x = 0; x < n; x++) {
					if(cloud[y][x]) { 
						int nexty = y + dy[dir]*power;
						int nextx = x + dx[dir]*power;
						
						nexty = (nexty+n) % n;
						nextx = (nextx+n) % n;
						A[nexty][nextx]++;
						waterAdded[nexty][nextx] = true;
					}
				}
			}
			//3
			cloud = new boolean[n][n];
			
			//4 & 5
			int[][] memo = new int[n][n];
			for (int y = 0; y < n; y++) {
				for (int x = 0; x < n; x++) {
					if(waterAdded[y][x]) { 
						int count = 0;
						for(int idx=1;idx<=7;idx+=2) {
							int nexty = y + dy[idx];
							int nextx = x + dx[idx];
							if(nexty<0 ||nexty>=n || nextx<0 ||nextx>=n ) continue;
							if(A[nexty][nextx] != 0)
								count++;
						}
						memo[y][x] += count;
					}
				}
			}
			for (int y = 0; y < n; y++) {
				for (int x = 0; x < n; x++) {
					A[y][x] += memo[y][x];
					if(A[y][x] >=2 && !waterAdded[y][x]) {
						cloud[y][x] = true;
						A[y][x] -= 2;
					}
				}
			}
			//pri();
			
		}
		int answer = 0;
		for (int y = 0; y < n; y++) {
			for (int x = 0; x < n; x++) {
				answer += A[y][x];
			}
		}
		System.out.println(answer);
	}
	static void pri() {
		for(int[]i:A)
			System.out.println(Arrays.toString(i));
		System.out.println();
			
	}
	
}