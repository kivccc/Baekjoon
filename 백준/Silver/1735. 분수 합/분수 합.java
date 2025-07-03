import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int a1=Integer.parseInt(st.nextToken());
        int b1=Integer.parseInt(st.nextToken());
        st=new StringTokenizer(br.readLine());
        int a2=Integer.parseInt(st.nextToken());
        int b2=Integer.parseInt(st.nextToken());
        
        long gcd=getgcd(b1,b2);

        long lcm=b1*b2/gcd;
        long val1=a1*lcm/b1;
        long val2=a2*lcm/b2;
        gcd=getgcd((val1+val2),lcm);
        System.out.println((val1+val2)/gcd+" "+lcm/gcd);
        /*
        for(int i=0;i<n;i++){
        
        }
        */
        

        //int n=Integer.parseInt(br.readLine());
        //Scanner sc=new Scanner(System.in);
        //int n=sc.nextInt();
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	}
    public static long getgcd(long a,long b){
        while(b!=0){
            long tmp=b;
            b=a%b;
            a=tmp;
        }
        return a;
    }
}