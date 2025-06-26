import java.util.*;
import java.io.*;
public class Main {
    public static HashMap<Long,Long> map=new HashMap<>();
	public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        long N=Long.parseLong(st.nextToken());
        long P=Long.parseLong(st.nextToken());
        long Q=Long.parseLong(st.nextToken());
        map.put(0L,1L);
        //int P=Integer.parseInt(st.nextToken());
        //int Q=Integer.parseInt(st.nextToken());
        System.out.println(get(N,P,Q));
        // 000 000 000 000
        //int N=Integer.parseInt(br.readLine());
        //Scanner sc=new Scanner(System.in);
        //int N=sc.nextInt();
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	}
    public static long get(long i,long p,long q){
        if(!map.containsKey(i))
            map.put(i,get(i/p,p,q)+get(i/q,p,q));
        return map.get(i);
    }
}