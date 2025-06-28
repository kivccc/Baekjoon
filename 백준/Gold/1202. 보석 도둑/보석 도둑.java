import java.util.*;
import java.io.*;
public class Main {
    public static int n;
    public static int k;
    public static int[] bag;
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        k=Integer.parseInt(st.nextToken());
        PriorityQueue<int[]>pq=new PriorityQueue<>((e1,e2)->{
            int ma=e1[0];
            int va=e1[1];
            int mb=e2[0];
            int vb=e2[1];
            if(va!=vb)
                return vb-va;
            else
                return mb-ma;
        });
        for(int i=0;i<n;i++){
            st=new StringTokenizer(br.readLine());
            int m=Integer.parseInt(st.nextToken());
            int v=Integer.parseInt(st.nextToken());
            pq.add(new int[]{m,v});
        }
        TreeMap <Integer,Integer> bagmap=new TreeMap<>();
        for(int i=0;i<k;i++){
            int m=Integer.parseInt(br.readLine());
            bagmap.put(m,bagmap.getOrDefault(m,0)+1);
        }
 
        long answer=0;
        while(!pq.isEmpty()){
            int[] curjew=pq.poll();
            int jewm=curjew[0];
            int jewv=curjew[1];
              
            Integer bagm=bagmap.ceilingKey(jewm);
            if(bagm!=null){
                answer+=jewv;
                if(bagmap.get(bagm)==1) bagmap.remove(bagm);
                else bagmap.put(bagm,bagmap.get(bagm)-1);
            }
        }
        System.out.println(answer);
	}
}