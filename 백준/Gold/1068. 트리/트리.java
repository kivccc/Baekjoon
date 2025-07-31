import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        //
        //
        ArrayList<Integer>[] tree=new ArrayList[n];
        for(int i=0;i<n;i++){
            tree[i]=new ArrayList<Integer>();
        }
        StringTokenizer st=new StringTokenizer(br.readLine());
        int root=-1;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++){
            int parent=Integer.parseInt(st.nextToken());
            if(parent!=-1)
                tree[parent].add(i);
            else
                root=i;
            map.put(i,parent);
        }

        int target=Integer.parseInt(br.readLine());
        if(target==root){
            System.out.println(0);
            return;
        }
        tree[map.get(target)].remove(Integer.valueOf(target));
        Deque<Integer> q=new ArrayDeque<>();
        q.add(root);
        int answer=0;
        while(!q.isEmpty()){
            int cur=q.poll();
            
            if(tree[cur].size()==0){
                answer++;
            }
            else{
                for(int next:tree[cur]){
                    if(next==target) continue;
                    q.add(next);
                }
            }
        }
        System.out.println(answer);
        //
        //Scanner sc=new Scanner(System.in);
        //int n=sc.nextInt();
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	}
}