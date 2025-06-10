import java.util.*;
import java.io.*;

public class Main {
    static int n, s, answer = 0;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for(int i=1;i<=n;i++){
            int[]a=new int[i];
            dfs(0,i,a,0);
        }
        System.out.println(answer);
    }

    
    public static void dfs(int depth, int target,int[] result,int start) {
        if (depth == target) {
            long sum=0;
            for(int i:result)
                sum+=i;
            if(sum==s){
                //System.out.println(Arrays.toString(result));
                answer++;
            }
            return;
        }

        for(int i=start;i<n;i++){
            result[depth]=arr[i];
            dfs(depth+1,target,result,i+1);
        }
    }
}
