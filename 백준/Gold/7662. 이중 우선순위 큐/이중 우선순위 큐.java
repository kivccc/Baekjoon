import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		for(int test=0; test<t; test++) {
			int input = Integer.parseInt(br.readLine());
			TreeMap<Integer, Integer> map = new TreeMap<>();
			for(int i=0; i<input; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				String op = st.nextToken();
				if(op.equals("I")) {
					int val = Integer.parseInt(st.nextToken());
					map.put(val, map.getOrDefault(val, 0)+1);
				}else {
					if(map.size()==0) 
                        continue;
					int j = Integer.parseInt(st.nextToken());
					int val;
					if(j == 1) { //최댓값 삭제 
						val = map.lastKey();
					}else { // 최솟값 삭제
						val = map.firstKey();
					}
					if(map.put(val, map.get(val)-1)==1) {
						map.remove(val);
					}
				}
			}
            if (map.size()==0) 
	            sb.append("EMPTY\n");
	        else 
	        	sb.append(map.lastKey()+" " + map.firstKey()+"\n");
		}
		System.out.println(sb);
	}
}