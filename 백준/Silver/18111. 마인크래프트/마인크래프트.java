import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); 
        int m = Integer.parseInt(st.nextToken()); 
        int b = Integer.parseInt(st.nextToken()); 
        int[][] ground = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) 
                ground[i][j] = Integer.parseInt(st.nextToken());
        }
        int[] timeByHeight = new int[257];
        int minTime = Integer.MAX_VALUE;
        String stringMinTime = "";
        for (int i = 0; i < timeByHeight.length; i++) {
            int totalB = b; 
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if (i < ground[j][k]) { 
                        timeByHeight[i] += (ground[j][k] - i) * 2; 
                        totalB += (ground[j][k] - i); 
                    } else if (i > ground[j][k]) { 
                        timeByHeight[i] += (i - ground[j][k]); 
                        totalB -= (i - ground[j][k]);
                    }
                }
            }

            if (totalB < 0) 
                timeByHeight[i] = Integer.MAX_VALUE;
            
            if (timeByHeight[i] <= minTime) { 
                stringMinTime = timeByHeight[i] + " " + i;
                minTime = timeByHeight[i];
            }
        }

        System.out.println(stringMinTime);
    }
}