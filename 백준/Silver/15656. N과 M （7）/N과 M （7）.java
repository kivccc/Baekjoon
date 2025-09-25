import java.util.*;
import java.io.*;

public class Main{
    static int n;
    static int m;
    static int[] arr;
    static int[] line;
    static StringBuilder answer = new StringBuilder();
    static HashSet<String> set = new HashSet<>();
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        line = new int[m];
        
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        dfs(0,0);        
        System.out.println(answer);
    }
    
    
    static void dfs(int start,int len){
        
        if(len==m){
            StringBuilder sb = new StringBuilder();
            for(int i:line)
                sb.append(i).append(" ");
            if(set.contains(sb.toString()))
                return;
            sb.append("\n");
            answer.append(sb.toString());
            return;
        }
        
        for(int i=0;i<n;i++){
            line[len] = arr[i];
            dfs(start,len+1);
        }
    }
    
}