import java.util.*;
import java.io.*;
public class Main {
    public static class GraphList{
        public Map<Integer,ArrayList<Integer>> map=new HashMap<>();
        public void add(int u,int v){
            map.putIfAbsent(u,new ArrayList<>());
            map.putIfAbsent(v,new ArrayList<>());
            map.get(u).add(v);
            map.get(v).add(u);
        }
    }
    
    
    
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        GraphList g=new GraphList();
        for(int i=0;i<N-1;i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            g.add(a,b);
        }
        boolean[] mem=new boolean[N];
        Stack<Integer> stack=new Stack<>();
        HashMap<Integer,Integer> answer=new HashMap<>();
        stack.push(1);
        mem[0]=true;
        while(!stack.isEmpty()){
            int top=stack.pop();
            mem[top-1]=true;
            ArrayList<Integer> list=g.map.get(top);
            for(int j:list){
                if(!mem[j-1]){
                    answer.put(j,top);
                    stack.push(j);
                }
            }     
        }
        StringBuilder sb=new StringBuilder();
        for(int i=2;i<=N;i++)
            sb.append(answer.get(i)).append('\n');
        System.out.println(sb);
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	}
}