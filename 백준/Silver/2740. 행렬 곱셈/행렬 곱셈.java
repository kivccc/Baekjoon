import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());        
        int M=Integer.parseInt(st.nextToken());        
        int[][] arr1=new int[N][M];
        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                arr1[i][j]=Integer.parseInt(st.nextToken());        
            }
        }
        st=new StringTokenizer(br.readLine());
        M=Integer.parseInt(st.nextToken());        
        int K=Integer.parseInt(st.nextToken());
        int[][] arr2=new int[M][K];
        for(int i=0;i<M;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<K;j++){
                arr2[i][j]=Integer.parseInt(st.nextToken());        
            }
        }
        int[][] answer=new int[N][K];
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<N;i++){
            for(int j=0;j<K;j++){
                for(int k=0;k<M;k++){
                    answer[i][j]+=arr1[i][k]*arr2[k][j];
                }
                sb.append(answer[i][j]).append(" ");
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