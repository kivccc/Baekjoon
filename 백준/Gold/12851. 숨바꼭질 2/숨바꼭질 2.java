import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());        
        int k=Integer.parseInt(st.nextToken());     
        int big=Math.max(n,k);
        int[] visit=new int[2*big+1];
        Arrays.fill(visit, -1); 
        int[] much=new int[2*big+1];
        Deque<int[]> q=new ArrayDeque<>();
        q.add(new int[]{n,0});
        much[n]=1;
        visit[n]=0;
        while(!q.isEmpty()){
            int[]val=q.poll();
            int pos=val[0];
            int time=val[1];
            for(int i=0;i<3;i++){
                int nextpos=getnextpos(pos,i);
                if(nextpos<0 || 2*big<nextpos) continue;
                if(visit[nextpos]==-1){ //첫방문
                    visit[nextpos]=time+1;
                    much[nextpos]=much[pos];
                    q.add(new int[]{nextpos,time+1});
                }
                else if(visit[nextpos]==time+1){ //첫방문은 아닌데 동일시간도착이면
                    much[nextpos]+=much[pos];
                }
            }
        }
        System.out.println(visit[k]);
        System.out.println(much[k]);
        /*
        for(int i=0;i<N;i++){
        
        }
        */
        

        //int N=Integer.parseInt(br.readLine());
        //Scanner sc=new Scanner(System.in);
        //int N=sc.nextInt();
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	}
    
    public static int getnextpos(int pos,int idx){
        if(idx==0)
            return pos+1;
        if(idx==1)
            return pos-1;
        if(idx==2)
            return pos*2;
        return 0;
    }
}