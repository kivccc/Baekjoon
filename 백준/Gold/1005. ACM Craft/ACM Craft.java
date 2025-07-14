import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc=Integer.parseInt(br.readLine());
        //
        //

        for(int test=0;test<tc;test++){
            StringTokenizer st=new StringTokenizer(br.readLine());  
            int n=Integer.parseInt(st.nextToken());
            int k=Integer.parseInt(st.nextToken());
            
            int[] buildtime=new int[n+1];
            st=new StringTokenizer(br.readLine());  
            for(int i=1;i<=n;i++)
                buildtime[i]=Integer.parseInt(st.nextToken());
            
            ArrayList<ArrayList<Integer>> graph=new ArrayList<>();
            int[] indegree=new int[n+1];
            for(int i=0;i<=n;i++)
                graph.add(new ArrayList<>());
            
            for(int i=0;i<k;i++){
                st=new StringTokenizer(br.readLine());  
                int from=Integer.parseInt(st.nextToken());
                int to=Integer.parseInt(st.nextToken());
                graph.get(from).add(to);
                indegree[to]++;
            }
            int target=Integer.parseInt(br.readLine());
            
            Deque<Integer> q=new ArrayDeque<>();
            ArrayList<Integer> result=new ArrayList<>();
            int[] timeanswer=new int[n+1];
            for(int i=1;i<=n;i++){
                if(indegree[i]==0){
                    q.add(i);
                    timeanswer[i]=buildtime[i];
                }
            }
                    
            while(!q.isEmpty()){
                int cur=q.poll();
                result.add(cur);
                
                for(int next:graph.get(cur)){
                    indegree[next]--;
                    timeanswer[next]=Math.max(timeanswer[next],timeanswer[cur]+buildtime[next]);
                    if(indegree[next]==0)
                        q.add(next);
                }
            }
            //System.out.println(result);
            System.out.println(timeanswer[target]);
            //System.out.println(Arrays.toString(timeanswer));
            
        }
        

        //
        //Scanner sc=new Scanner(System.in);
        //int n=sc.nextInt();
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	}
}