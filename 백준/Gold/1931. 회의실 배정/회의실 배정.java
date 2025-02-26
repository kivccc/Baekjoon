import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        int[][]arr=new int[N][2];
        for(int i=0;i<N;i++){
            String[] s=br.readLine().split(" ");
            int a=Integer.parseInt(s[0]);
            int b=Integer.parseInt(s[1]);
            arr[i][0]=a;
            arr[i][1]=b;
        }
        Arrays.sort(arr,(e1,e2)->{
            if(e1[1]==e2[1])
                return Integer.compare(e1[0],e2[0]);
            else
                return Integer.compare(e1[1],e2[1]);
        });
        int count=0;
        int time=0;
        for(int i=0;i<N;i++){
            if(time<=arr[i][0]){
                time=arr[i][1];
                count++;
            }
        }
        System.out.println(count);
        //StringTokenizer st=new StringTokenizer(br.readLine());
        //int N=Integer.parseInt(st.nextToken());
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	}
}