import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int[] parents;
	static List<Integer> knowList;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		parents = new int[n+1];
		for(int i=1; i<n+1; i++) {
			parents[i] = i;
		}
		st = new StringTokenizer(br.readLine());
        
		int knowval= Integer.parseInt(st.nextToken());
		knowList = new ArrayList<>();
		if(knowval==0) {
			System.out.println(m);
			return;
		}
        for(int i=0; i<knowval; i++) 
			knowList.add(Integer.parseInt(st.nextToken()));

        
		List<Integer>[] partyList = new ArrayList[m];
		for(int i=0; i<m; i++) 
			partyList[i] = new ArrayList<>();
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int partyNum = Integer.parseInt(st.nextToken());
            
			int x = Integer.parseInt(st.nextToken());
			partyList[i].add(x);
			for(int j=1; j<partyNum; j++) {
				int y = Integer.parseInt(st.nextToken());
				union(x,y);
				partyList[i].add(y);
			}
		}
        
		int cnt=0;
		for(int i=0; i<m; i++) {
			boolean flag = true;
			for(int num : partyList[i]) {
				if(knowList.contains(find(parents[num]))) {
                    flag= false;
                    break;
    			}
            }
			if(flag) {
				cnt++;
			}
		}
		System.out.println(cnt);
		
	}
	
	static int find(int x) {
		if(parents[x] ==x ) return x;
		return find(parents[x]);
	}
	
	static void union(int x, int y) {
		int rx = find(x);
		int ry = find(y);
		if(knowList.contains(ry)) {
			int tmp = rx;
			rx = ry;
			ry =tmp;
		}
		
		parents[ry] = rx;
	}
}