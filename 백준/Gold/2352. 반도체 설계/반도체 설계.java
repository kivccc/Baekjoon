import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        //

        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken()); 
        }
        

        ArrayList<Integer> list = new ArrayList<>();
        for(int i:arr){
            int idx = Collections.binarySearch(list,i);
        //System.out.println("idx : "+ idx);
        //System.out.println("list.size() : "+ list.size());
            
            if(idx<0)
                idx = -idx-1;
            if(idx == list.size())
                list.add(i);
            else
                list.set(idx,i);
        //System.out.println(list);
        //System.out.println();
	
        }
        System.out.println(list.size());

        //
        //Scanner sc = new Scanner(System.in);
        //int n = sc.nextInt();
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	}
}