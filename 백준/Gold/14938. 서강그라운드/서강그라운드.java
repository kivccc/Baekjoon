import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());        
        int m=Integer.parseInt(st.nextToken());        
        int r=Integer.parseInt(st.nextToken());        
        st=new StringTokenizer(br.readLine());
        int[] item=new int[n+1];
        int[][] graph=new int[n+1][n+1];
        for(int i=1;i<=n;i++){
            item[i]=Integer.parseInt(st.nextToken());
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if(i!=j)
                    graph[i][j]=30;
            }
        }
        for(int i=0;i<r;i++){
            st=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            int len=Integer.parseInt(st.nextToken());
            graph[a][b]=len;
            graph[b][a]=len;
        }
   
                
        for (int k=1;k<=n;k++) 
            for (int i=1;i<=n;i++) 
                for (int j=1;j<=n;j++) 
                    if (graph[i][j]>graph[i][k]+graph[k][j]) 
                        graph[i][j] = graph[i][k] + graph[k][j];
        
        int[] ans=new int[n+1];
        int max=0;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if(graph[i][j]<=m)
                    ans[i]+=item[j];
            }
            max=Math.max(max,ans[i]);
        }
        System.out.println(max);       
        //int N=Integer.parseInt(br.readLine());
        //Scanner sc=new Scanner(System.in);
        //int N=sc.nextInt();
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	}
}