import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        HashMap<Long,Integer> map=new HashMap<>();
        for(int i=0;i<N;i++){
            Long val=Long.parseLong(br.readLine());
            map.put(val,map.getOrDefault(val,0)+1);
        }
        int max_val=0;
        Long max_key=0L;
        for(Long key:map.keySet()){
            if(map.get(key)>max_val){
                max_key=key;
                max_val=map.get(key);
            }
            else if(map.get(key)==max_val && max_key>key)
                max_key=key;
        }
        System.out.println(max_key);
	}
}