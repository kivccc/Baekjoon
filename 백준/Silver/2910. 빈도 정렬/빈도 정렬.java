
import java.util.*;
import java.io.*;


class Main {
	static HashMap<Integer,int[]> map = new HashMap<Integer, int[]>();
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		for(int idx=0;idx<n;idx++) {
			int val = Integer.parseInt(st.nextToken());
			
			if(!map.containsKey(val)) {
				map.put(val, new int[] {idx,1,val});
			}
			else {
				map.get(val)[1]++;
			}
		}
		ArrayList<int[]> list = new ArrayList<int[]>();
		for(int key:map.keySet()) {
			list.add(map.get(key));
		}
		Collections.sort(list,(e1,e2)->{
			if(e1[1] != e2[1])
				return e2[1]-e1[1];
			else
				return e1[0]-e2[0];
		});
		StringBuilder sb = new StringBuilder();
		
		for(int[] i : list) {
			int num = i[2];
			int count = i[1];
			for(int j=0;j<count;j++) {
				sb.append(num).append(" ");
			}
		}
		System.out.print(sb);
		
		
	}

}
