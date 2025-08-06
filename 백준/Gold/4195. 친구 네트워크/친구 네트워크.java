import java.util.*;
import java.io.*;
public class Main {
    static HashMap<String,String> map;
    static HashMap<String,Integer> sizemap;
    
	public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc=Integer.parseInt(br.readLine());
        StringBuilder sb=new StringBuilder();
        for(int test=0;test<tc;test++){
            int f=Integer.parseInt(br.readLine());
            map=new HashMap<>();
            sizemap=new HashMap<>();
            for(int i=0;i<f;i++){
                StringTokenizer st=new StringTokenizer(br.readLine());
                String name1=st.nextToken();
                String name2=st.nextToken();
                if(!map.containsKey(name1)){
                    map.put(name1,name1);
                    sizemap.put(name1,1);
                } 
                if(!map.containsKey(name2)){
                    map.put(name2,name2);
                    sizemap.put(name2, 1);
                } 
                int newsize=union(name1,name2);
                sb.append(newsize).append("\n");
            }
        }
        System.out.println(sb);
        
        //int n=Integer.parseInt(br.readLine());
        //Scanner sc=new Scanner(System.in);
        //int n=sc.nextInt();
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	}
    static String find(String name){
        if(map.get(name)!=name){
            map.put(name,find(map.get(name)));
        }
        return map.get(name);
    }
    static int union(String a,String b){
        String roota=find(a);
        String rootb=find(b);
        if(!roota.equals(rootb)){
            map.put(rootb,roota);
            int sizea=sizemap.get(roota);
            int sizeb=sizemap.get(rootb);
            sizemap.put(roota,sizea+sizeb);
        }
        return sizemap.get(find(a));
    }
}