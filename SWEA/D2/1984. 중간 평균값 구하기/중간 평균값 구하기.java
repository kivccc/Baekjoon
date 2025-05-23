import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < T; i++) {
            int max = -1;
            int min = 10001;
            int sum = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            for (int j = 0; j < 10; j++) {
                int val = Integer.parseInt(st.nextToken());
                max = Math.max(max, val);
                min = Math.min(min, val);
                sum += val;
            }
            
            int ans = Math.round((sum - min - max) / 8.0f);
            sb.append("#").append(i + 1).append(" ").append(ans).append("\n");
        }
        
        System.out.print(sb);
    }
}
