import java.io.*;
import java.util.*;
import java.util.StringTokenizer;

class Main{
	static int l;
	static int c;
	static char[] mo = new char[] {'a','e','i','o','u'};
	static char[] arr;
	static char[] dfsarr;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		l = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		arr = new char[c];
		dfsarr = new char[l];
		st = new StringTokenizer(br.readLine());
        for (int i = 0; i < c; i++) {
            arr[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(arr);
        //System.out.println(Arrays.toString(arr));
        dfs(0,0);
        System.out.println(sb);
	}
	static void dfs(int idx,int start) {
		if(idx == l) {
			int a = 0;
			for(char c:dfsarr) {
				for(int i=0;i<5;i++) {
					if(c == mo[i]) {
						a++;
						break;
					}
				}
			}
			int b = l-a;
			if(! (a>=1 && b>=2)) return;
			for(char c:dfsarr) {
				sb.append(c);
			}
			sb.append("\n");
			return;
		}
		
		for(int i=start;i<c;i++) {
			dfsarr[idx] = arr[i];
			dfs(idx+1,i+1);
		}
	}
}