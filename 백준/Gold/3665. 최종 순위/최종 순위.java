import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc=Integer.parseInt(br.readLine());
        StringBuilder sb=new StringBuilder();
        for(int test=0;test<tc;test++){
            int n=Integer.parseInt(br.readLine());
            int[] last=new int[n];
            StringTokenizer st=new StringTokenizer(br.readLine());
            for(int i=0;i<n;i++){
                last[i]=Integer.parseInt(st.nextToken());
            }
            HashMap<Integer,HashSet<Integer>> map=new HashMap<>();
            for(int i=n-1;i>=0;i--){
                for(int j=i-1;j>=0;j--){
                    map.putIfAbsent(last[j], new HashSet<>());
                    map.get(last[j]).add(last[i]);
                }
            }
            int m=Integer.parseInt(br.readLine());
            for(int i=0;i<m;i++){
                st=new StringTokenizer(br.readLine());
                int a=Integer.parseInt(st.nextToken());
                int b=Integer.parseInt(st.nextToken());
                if(map.containsKey(a) && map.get(a).contains(b)){ 
                    map.get(a).remove(b);
                    map.putIfAbsent(b,new HashSet<>());
                    map.get(b).add(a);
                }
                else if(map.containsKey(b) && map.get(b).contains(a)){
                    map.get(b).remove(a);
                    map.putIfAbsent(a,new HashSet<>());
                    map.get(a).add(b);
                }
            }
            //System.out.println(map);
            ArrayList<ArrayList<Integer>> graph=new ArrayList<>();
            for(int i=0;i<=n;i++)
                graph.add(new ArrayList<>());
            int[] indegree=new int[n+1];
            for(Integer i:map.keySet()){
                for(Integer k:map.get(i)){
                    graph.get(i).add(k);
                    indegree[k]++;
                }
            }
            //for(ArrayList l:graph)
            //    System.out.println(l);
            Deque<Integer> q=new ArrayDeque<>();
            ArrayList<Integer> result=new ArrayList<>();
            for(int i=1;i<=n;i++){
                if(indegree[i]==0)
                    q.add(i);
            }
            boolean flag=false;
            for(int count=0;count<n;count++){
                if(q.isEmpty()){
                    sb.append("IMPOSSIBLE").append("\n");
                    flag=true;
                    break;
                }
                if(q.size()>=2){
                    sb.append("?").append("\n");
                    flag=true;
                    break;
                }
                int cur=q.poll();
                result.add(cur);
                for(int next:graph.get(cur)){
                    indegree[next]--;
                    if(indegree[next]==0)
                        q.add(next);
                }
            }
            if(!flag){
                for(int i: result)
                    sb.append(i).append(" ");
                sb.append("\n");
            }
        }
        System.out.println(sb);
        

        //
        //Scanner sc=new Scanner(System.in);
        //int n=sc.nextInt();
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	}
}