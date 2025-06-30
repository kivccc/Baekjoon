import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        long a=Long.parseLong(st.nextToken());
        long b=Long.parseLong(st.nextToken());
        long oga=a;
        long ogb=b;
        while(b!=0){
            long tmp=b;
            b=a%b;
            a=tmp;
        }
        System.out.println(oga*ogb/a);
        /*
        for(int i=0;i<n;i++){
        
        }
        */
        

        //int n=Integer.parseInt(br.readLine());
        //Scanner sc=new Scanner(System.in);
        //int n=sc.nextInt();
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	}
}