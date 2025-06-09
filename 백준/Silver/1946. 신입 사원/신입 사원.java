import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(br.readLine());
        StringBuilder sb=new StringBuilder();
        for(int tc=0;tc<T;tc++){
            int N=Integer.parseInt(br.readLine());
            PriorityQueue<int[]> pq=new PriorityQueue<>((e1,e2)->{
                return e1[0]-e2[0];
            });
            for(int i=0;i<N;i++){
                StringTokenizer st=new StringTokenizer(br.readLine());
                int doc=Integer.parseInt(st.nextToken());
                int pt=Integer.parseInt(st.nextToken());
                pq.add(new int[]{doc,pt});
            }
            int val=100001;
            int answer=0;
            while(!pq.isEmpty()){
                int[] tmp=pq.poll();
                if(val>tmp[1]){
                    answer++;
                    val=tmp[1];
                }
            }
            sb.append(answer).append("\n");
        }
        System.out.println(sb);
        //int N=Integer.parseInt(br.readLine());
        //Scanner sc=new Scanner(System.in);
        //int N=sc.nextInt();
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	}
}