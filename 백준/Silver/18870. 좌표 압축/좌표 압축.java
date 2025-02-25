import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int[] arr=new int[N];
        ArrayList<Integer> list=new ArrayList<>();
        HashSet<Integer> set=new HashSet<>();
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<N;i++){
            int val=sc.nextInt();
            arr[i]=val;
            if(!set.contains(val)){
                list.add(val);
                set.add(val);
            }
        }
        Collections.sort(list);
        for (int i = list.size() - 1; i >= 0; i--) {
            map.put(list.get(i),i);
        }
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<N;i++){
            sb.append(map.get(arr[i])).append(" ");
        }
        System.out.println(sb.toString());
        //StringTokenizer st=new StringTokenizer(br.readLine());
        //int N=Integer.parseInt(st.nextToken());
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	}
}