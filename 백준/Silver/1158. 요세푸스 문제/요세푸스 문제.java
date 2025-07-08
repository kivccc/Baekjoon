import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int k=Integer.parseInt(st.nextToken());
        Deque<Integer>dq=new ArrayDeque<>();
        for(int i=1;i<=n;i++){
            dq.add(i);
        }
        
        StringBuilder sb=new StringBuilder();
        sb.append("<");
        while(dq.size()!=1){
            for(int i=0;i<k-1;i++)
                dq.addLast(dq.pollFirst());
            sb.append(dq.poll()).append(", ");
        }
        sb.append(dq.poll()).append(">");
        System.out.println(sb);

        //int n=Integer.parseInt(br.readLine());
        //Scanner sc=new Scanner(System.in);
        //int n=sc.nextInt();
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	}
}