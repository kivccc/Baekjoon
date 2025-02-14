import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException {
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        int b=sc.nextInt();
        int val=a*b;
        while(b!=0){
            int tmp=b;
            b=a%b;
            a=tmp;
        }
        System.out.println(a);
        System.out.println(val/a);
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st=new StringTokenizer(br.readLine());
        //int N=Integer.parseInt(st.nextToken());
	}
}