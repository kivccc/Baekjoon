import java.util.*;
import java.io.*;
public class Main {
    public static class GraphList{
        public Map<Integer,ArrayList<Integer>> map= new HashMap();
        public void add(int u,int v){
            map.putIfAbsent(u,new ArrayList<>());
            map.putIfAbsent(v,new ArrayList<>());
            map.get(u).add(v);
            map.get(v).add(u);
        };
    }
    
    static int[] mem;
    static GraphList g;
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s=br.readLine().split(" ");
        int N=Integer.parseInt(s[0]);
        int M=Integer.parseInt(s[1]);
        int V=Integer.parseInt(s[2]);
        g = new GraphList();
        for(int i=0;i<M;i++){
            s=br.readLine().split(" ");
            int u=Integer.parseInt(s[0]);
            int v=Integer.parseInt(s[1]);
            g.add(u,v);
        }
        dfs(V,N);
        bfs(V,N);
	}
    
    public static void dfs(int start,int size){
        boolean[] mem=new boolean[size+1];
        Stack<Integer> stack=new Stack<>();
        stack.push(start);
        StringBuilder sb=new StringBuilder();
        while(!stack.isEmpty()){
            int val=stack.pop();
            if(!mem[val]){
                sb.append(val).append(" ");
                mem[val]=true;
                ArrayList<Integer> list=g.map.get(val);
                if(list!=null){
                    Collections.sort(list);
                    for (int j=list.size()-1;j>=0; j--) {
                        int des=list.get(j);
                        if(!mem[des])
                            stack.push(des);
                    }
                }   
            }
        }
        System.out.println(sb);
    }
    
    public static void bfs(int start,int size){
        boolean[] mem=new boolean[size+1];
        Deque<Integer> q=new ArrayDeque<>();
        q.addLast(start);
        StringBuilder sb=new StringBuilder();
        while(!q.isEmpty()){
            int val=q.poll();
            if(!mem[val]){
                sb.append(val).append(" ");
                mem[val]=true;
                ArrayList<Integer> list=g.map.get(val);
                if(list!=null){
                    Collections.sort(list);
                    for (int j=0;j<list.size(); j++) {
                        int des=list.get(j);
                        if(!mem[des])
                            q.addLast(des);
                    }
                }   
            }
        }
        System.out.println(sb);
    }    
    
    
}