import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int K=sc.nextInt();
        if(N==K){
            System.out.println(0);
            return;
        }
        boolean[] mem=new boolean[100001];
        Deque<int[]> q=new ArrayDeque<>();
        q.addLast(new int[]{N,0});
        while(!q.isEmpty()){
            int[] arr=q.poll();
            int cur=arr[0];
            mem[cur]=true;
            if(cur==K){
                System.out.println(arr[1]);
                break;
            }
            else{
                if(cur+1<=100000 && !mem[cur+1])
                    q.addLast(new int[]{cur+1,arr[1]+1});
                if(0<=cur-1 && !mem[cur-1])
                    q.addLast(new int[]{cur-1,arr[1]+1});
                if(cur*2<=100000 && !mem[cur*2])
                    q.addLast(new int[]{cur*2,arr[1]+1});
            }
        }
        

        //StringTokenizer st=new StringTokenizer(br.readLine());
        //int N=Integer.parseInt(st.nextToken());
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	}
}