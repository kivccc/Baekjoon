import java.util.*;
import java.io.*;
public class Main {
    static long[] arr;
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(br.readLine());
        arr=new long[101];
        arr[1]=1;
        arr[2]=1;
        arr[3]=1;
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<T;i++){
            int N=Integer.parseInt(br.readLine());
            if (arr[N] == 0) {
                for (int j = 4; j <= N; j++) 
                    if (arr[j] == 0)  
                        arr[j] = arr[j - 2] + arr[j - 3];
            }
            sb.append(arr[N]).append("\n");
        }
        System.out.println(sb.toString());
        //StringTokenizer st=new StringTokenizer(br.readLine());
        //int N=Integer.parseInt(st.nextToken());
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	}
}