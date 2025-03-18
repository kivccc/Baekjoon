import java.util.*;
import java.io.*;
public class Main {
    public static boolean[] mem=new boolean[100];
    public static int[] arr=new int[100];
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine());
            int x=Integer.parseInt(st.nextToken());
            int y=Integer.parseInt(st.nextToken());
            arr[x]=y;
        }
        for(int i=0;i<M;i++){
            st=new StringTokenizer(br.readLine());
            int x=Integer.parseInt(st.nextToken());
            int y=Integer.parseInt(st.nextToken());
            arr[x]=y;
        }
        Deque<int[]> q=new ArrayDeque<>();
        q.addLast(new int[]{1,0});
        while(!q.isEmpty()){
            int[] val=q.poll();
            if(arr[val[0]]==0 && 94<=val[0] && val[0]<=99){
                //System.out.println(val[0]);
                System.out.println(val[1]+1);
                return;
            }
            for(int i=1;i<=6;i++){
                int nextpos=val[0]+i;
                if(!mem[nextpos]){
                    if(arr[nextpos]==0){
                        q.addLast(new int[]{nextpos,val[1]+1});
                        //System.out.println(val[0]+"에서 "+nextpos+"로 이동");
                    }
                    else{
                        q.addLast(new int[]{arr[nextpos],val[1]+1});
                        //System.out.println(val[0]+"에서 "+arr[nextpos]+"로 이동");
                        mem[arr[nextpos]]=true;
                    }
                    mem[nextpos]=true;
                    
                }
            }
        }
        //StringTokenizer st=new StringTokenizer(br.readLine());
        //int N=Integer.parseInt(st.nextToken());
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	}
}