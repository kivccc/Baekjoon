import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        int m=Integer.parseInt(br.readLine());
        int[][] graph=new int[n+1][n+1];
        for(int k=1;k<=n;k++){
            for(int j=1;j<=n;j++){
                if(k!=j)
                    graph[k][j]=999999999;
            }
        }
        //int N=Integer.parseInt(st.nextToken());        
        for(int i=0;i<m;i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());        
            int b=Integer.parseInt(st.nextToken());        
            int c=Integer.parseInt(st.nextToken());        
            graph[a][b]=Math.min(graph[a][b],c);
        }
        int min=100001;
        for(int k=1;k<=n;k++){
            for(int i=1;i<=n;i++){
                for(int j=1;j<=n;j++){
                    if(graph[i][j]>graph[i][k]+graph[k][j]){
                        graph[i][j]=graph[i][k]+graph[k][j];
                    }
                }
            }
        }
        StringBuilder sb=new StringBuilder();
        for(int k=1;k<=n;k++){
            for(int j=1;j<=n;j++){
                if(graph[k][j]==999999999)
                    sb.append(0).append(" ");
                else
                    sb.append(graph[k][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
        //int N=Integer.parseInt(br.readLine());
        //Scanner sc=new Scanner(System.in);
        //int N=sc.nextInt();
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	}
}