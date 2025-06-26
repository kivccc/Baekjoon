import java.util.*;
import java.io.*;
public class Main {
    public static int a;
    public static int b;
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        a=Integer.parseInt(st.nextToken());
        b=Integer.parseInt(st.nextToken());
        PriorityQueue<int[]> pq=new PriorityQueue<>((e1,e2)->{
            return (e1[0]+e1[1])-(e2[0]+e2[1]);
        });
        for(int i=1;;i++){
            int ta=a*i;
            if(b%i!=0) continue;
            int tb=b/i;
            //System.out.println("ta : "+ta+" tb : "+tb);
            if(ta>tb) break;
            int gcdval=gcd(ta,tb);
            //System.out.println("gcdval : "+gcdval);
            if(gcdval!=a) continue;
            int lcmval=lcm(ta,tb,gcdval);
            //System.out.println("lcmval : "+lcmval);
            if(lcmval!=b) continue;
            pq.add(new int[]{ta,tb});
        }
        /*while(!pq.isEmpty()){
            System.out.println(Arrays.toString(pq.poll()));        
        }
        */
        int[] answer=pq.poll();
        System.out.println(answer[0]+" "+answer[1]);        

        //int N=Integer.parseInt(br.readLine());
        //Scanner sc=new Scanner(System.in);
        //int N=sc.nextInt();
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	}
    
    public static int gcd(int x,int y){
        while(y!=0){
            int tmp=y;
            y=x%y;
            x=tmp;
        }
        return x;
    }
    public static int lcm(int a,int b,int gcdval){
        long result=(long)a*(b/gcdval);
        return (int)result;
    }
}