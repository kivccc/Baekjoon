import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        PriorityQueue<Integer> q=new PriorityQueue<>((e1,e2)->{
           int a=Math.abs(e1); 
           int b=Math.abs(e2); 
           if(a!=b)
               return a-b;
            else
                return e1-e2;
        });
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<N;i++){
            int val=Integer.parseInt(br.readLine());
            if(val!=0)
                    q.add(val);
            else{
                if(q.isEmpty())
                    sb.append(0).append("\n");
                else
                    sb.append(q.poll()).append("\n");
            }
        }
        System.out.println(sb);

        //StringTokenizer st=new StringTokenizer(br.readLine());
        //int N=Integer.parseInt(st.nextToken());
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	}
}