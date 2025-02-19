import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        int[][] arr=new int[N][2];
        
        for(int i=0;i<N;i++){
            String[] s=br.readLine().split(" ");
            arr[i][0]=Integer.parseInt(s[0]);
            arr[i][1]=Integer.parseInt(s[1]);
        }
        for(int i=0;i<N;i++){
            int val=1;
            for(int j=0;j<N;j++){
                if(i==j)
                    continue;
                if(arr[i][0]<arr[j][0] && arr[i][1]<arr[j][1])
                    val++;
            }
            System.out.println(val);
        }
        //StringTokenizer st=new StringTokenizer(br.readLine());
        //int N=Integer.parseInt(st.nextToken());
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	}
}