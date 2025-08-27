import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int K=sc.nextInt();
        if(N==K){
            System.out.println(0);
            System.out.println(N);
            return;
        }
        int[] mem=new int[100001];
        Arrays.fill(mem,100001);
        Deque<int[]> q=new ArrayDeque<>();
        q.addLast(new int[]{N,0});
        mem[N]=N;
        while(!q.isEmpty()){
            int[] arr=q.poll();
            int cur=arr[0];
            if(cur==K){
                System.out.println(arr[1]);
                ArrayList<Integer> answer=new ArrayList<>();
                int before=cur;
                while(before!=N){
                    answer.add(before);
                    before=mem[before];
                }
                answer.add(N);
                StringBuilder sb=new StringBuilder();
                for(int i=answer.size()-1;i>=0;i--)
                    sb.append(answer.get(i)).append(" ");
                System.out.println(sb);
                break;
            }
            else{
                if(cur+1<=100000 && mem[cur+1]==100001){
                    q.addLast(new int[]{cur+1,arr[1]+1});
                    mem[cur+1]=cur;
                }
                if(0<=cur-1 && mem[cur-1]==100001){
                    q.addLast(new int[]{cur-1,arr[1]+1});
                    mem[cur-1]=cur;
                }
                if(cur*2<=100000 && mem[cur*2]==100001){
                    q.addLast(new int[]{cur*2,arr[1]+1});
                    mem[cur*2]=cur;
                }
            }
        }
        

        //StringTokenizer st=new StringTokenizer(br.readLine());
        //int N=Integer.parseInt(st.nextToken());
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	}
}