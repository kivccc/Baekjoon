import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        HashMap<Integer,Integer> map=new HashMap<>();
        StringTokenizer st=new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            int val=Integer.parseInt(st.nextToken());
            map.put(val,map.getOrDefault(val,0)+1);
        }
        int M=Integer.parseInt(br.readLine());
        StringBuilder sb=new StringBuilder();
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<M;i++){
            int val=Integer.parseInt(st.nextToken());
            sb.append(map.getOrDefault(val,0)).append(" ");
        }
        System.out.println(sb.toString());
	}
}