import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        StringTokenizer st=new StringTokenizer(br.readLine());
        int[] arr=new int[N];
        List<Integer> list=new ArrayList<>();
        for(int i=N-1;i>=0;i--){
            arr[i]=Integer.parseInt(st.nextToken());
        }
        for(int i:arr){
            int idx=Collections.binarySearch(list,i);
            if(idx<0)
                idx=-idx-1;
            if(idx==list.size()){
                list.add(i);
            }
            else
                list.set(idx,i);
        }
        System.out.println(list.size());
	}
}