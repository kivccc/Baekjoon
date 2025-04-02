import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s=br.readLine().split(" ");
        int a=Integer.parseInt(s[0]);
        int b=Integer.parseInt(s[1]);
        Deque<long[]> q=new ArrayDeque<>();
        q.add(new long[]{a,0});
        HashSet<Long> set=new HashSet<>();
        while(!q.isEmpty()){
            long[]val=q.poll();
            set.add(val[0]);
            long[] next=new long[]{val[0]*2,val[0]*10+1};
            for(int i=0;i<2;i++){
                if(next[i]==b){
                    System.out.println(val[1]+2);
                    return;
                }
                else if(!set.contains(next[i]) && next[i]<b){
                    q.addLast(new long[]{next[i],val[1]+1});
                }    
            }
        }
        System.out.println(-1);
        
	}
}