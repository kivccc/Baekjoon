import java.util.*;
import java.awt.*;
import java.io.*;
public class Main {
    static int n;
    static int m;
    static int k;
    static char[][] grid;
    static int[][][] dp;
    static String like;
    static HashMap<Character,ArrayList<Point>> map = new HashMap<>();
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        grid = new char[n][m];
        for(int i=0;i<n;i++){
            String line = br.readLine();
            for(int j=0;j<m;j++){
                char c = line.charAt(j);
                grid[i][j] = c;
                if(!map.containsKey(c))
                    map.put(c,new ArrayList<Point>());
                map.get(c).add(new Point(j,i));
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<k;i++){
            like = br.readLine();
            sb.append(getCount(like)).append("\n");
        }
        System.out.println(sb);
	}
    
    static int getCount(String like) {
        int len = like.length();
        dp = new int[n][m][len];
        for (int[][] plane : dp) {
            for (int[] row : plane) {
                Arrays.fill(row, -1);
            }
        }

        int count = 0;
        char startChar = like.charAt(0);

        if (!map.containsKey(startChar)) {
            return 0;
        }
        for (Point start : map.get(startChar)) {
            count += dfs(start.y, start.x, 0);
        }
        return count;
    }   
    static int dfs(int y, int x, int index) {
        if (index == like.length() - 1) {
            return 1; 
        }

        if (dp[y][x][index] != -1) {
            return dp[y][x][index];
        }

        dp[y][x][index] = 0; 
        char nextChar = like.charAt(index + 1);

        if (map.containsKey(nextChar)) {
            for (Point next : map.get(nextChar)) {
                if (isNear(y, x, next.y, next.x)) {
                    dp[y][x][index] += dfs(next.y, next.x, index + 1);
                }
            }
        }
        
        return dp[y][x][index]; // 계산된 값을 반환
    }
    static boolean isNear(int y1,int x1,int y2,int x2){
        if( y1==y2 && x1==x2)
            return false;
        int dy = Math.abs(y1-y2);
        int deltaY = Math.min(dy,n-dy);
        
        int dx = Math.abs(x1-x2);
        int deltaX = Math.min(dx,m-dx);
        
        return (deltaY<=1) && (deltaX<=1);
    }
}