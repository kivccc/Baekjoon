import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());        
        int K=Integer.parseInt(st.nextToken());      
        PriorityQueue<Integer>pq=new PriorityQueue<>();
        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());    
            int b=Integer.parseInt(st.nextToken());    
            if(a>=b)
                K--;
            else
                pq.add(b-a);
        }
        if(K<=0)
            System.out.println("0");
        else{
            int val=0;
            while(K>0){
                val=pq.poll();
                K--;
            }
            System.out.println(val);
        }

        //int N=Integer.parseInt(br.readLine());
        //Scanner sc=new Scanner(System.in);
        //int N=sc.nextInt();
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	}
}