import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());
        int k=Integer.parseInt(st.nextToken())-1;
        int[] candy=new int[n+1];
        
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++)
            candy[i+1]=Integer.parseInt(st.nextToken());
        ArrayList<ArrayList<Integer>> graph=new ArrayList<>();
        for(int i=0;i<=n;i++)
            graph.add(new ArrayList<>());

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        boolean[] visited=new boolean[n+1];
        ArrayList<int[]> sumlist=new ArrayList<>();
        
        for(int i=1;i<=n;i++){
            if(visited[i]) continue;
            int candySum=0;
            int kidSum=0;
            Deque<Integer> q=new ArrayDeque<>();
            q.add(i);
            visited[i]=true;
            kidSum++;
            candySum+=candy[i];
            while(!q.isEmpty()){
                int cur=q.poll();
                for(int next:graph.get(cur)){
                    if(visited[next]) continue;
                    kidSum++;
                    candySum+=candy[next];
                    q.add(next);
                    visited[next]=true;
                }
            }
            sumlist.add(new int[]{candySum,kidSum});
        }
        //for(int[] a:sumlist)
        //    System.out.println(Arrays.toString(a));
        
        int[] dp=new int[k+1];
        for(int i=0;i<sumlist.size();i++){
            int[] sumval=sumlist.get(i);
            int candys=sumval[0];
            int kids=sumval[1];
            for(int j=k;j>=kids;j--)
                dp[j]=Math.max(dp[j],dp[j-kids]+candys);
        }
        System.out.println(dp[k]);
        //int n=Integer.parseInt(br.readLine());
        //Scanner sc=new Scanner(System.in);
        //int n=sc.nextInt();
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	}
}