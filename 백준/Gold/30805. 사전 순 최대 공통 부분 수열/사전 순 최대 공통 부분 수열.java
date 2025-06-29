import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        int[]arra=new int[n];        
        StringTokenizer st=new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arra[i]=Integer.parseInt(st.nextToken());
        }
        int m=Integer.parseInt(br.readLine());
        int[]arrb=new int[m];        
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<m;i++){
            arrb[i]=Integer.parseInt(st.nextToken());
        }
        // val, idx
        PriorityQueue<int[]> pq=new PriorityQueue<>((e1,e2)->{
            int vala=e1[0];
            int idxa=e1[1];
            int valb=e2[0];
            int idxb=e2[1];
            if(vala!=valb)
                return valb-vala;
            return idxa-idxb;
        });
        int idx=0;
        for(int i:arra)
            pq.add(new int[]{i,idx++});
        int idxa=0;
        int idxb=-1;
        int count=0;
        StringBuilder sb=new StringBuilder();
        while(!pq.isEmpty()){
            int[]tmp=pq.poll();
            //System.out.println(Arrays.toString(tmp));
            if(tmp[1]<idxa) continue;
            for(int i=idxb+1;i<m;i++){
                if(tmp[0]==arrb[i]){
                    idxa=tmp[1];
                    count++;
                    idxb=i;
                    sb.append(tmp[0]).append(" ");
                    //System.out.println("idxa : "+idxa);
                    //System.out.println("idxb : "+idxb);
                    break;
                }
            }
        }
        System.out.println(count);
        if(count!=0)
            System.out.println(sb);
        //
        //Scanner sc=new Scanner(System.in);
        //int n=sc.nextInt();
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	}
}