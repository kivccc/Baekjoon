import java.util.*;
import java.io.*;
public class Main {
    static int A;
    static int B;
    static int C;
    static int mod;
    static HashMap<Integer,Integer> map=new HashMap<>();
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        A=Integer.parseInt(st.nextToken());
        B=Integer.parseInt(st.nextToken());
        C=Integer.parseInt(st.nextToken());
        mod=A%C;                
        System.out.println(ans(B));
        //StringTokenizer st=new StringTokenizer(br.readLine());
        //int N=Integer.parseInt(st.nextToken());
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	}
    public static int ans(int i){
        if(i==1)
            return mod;
        if(map.containsKey(i))
            return map.get(i);

        int mid=i/2;
        int val;
        if(i%2==0){
            int midval=ans(mid);
            val=(int)((long)midval*midval%C);
        }
        else{
            int midval=ans(mid);
            val=(int)((long)midval*ans(mid+1)%C);
        }
        map.put(i,val);
        return val;
    }
}