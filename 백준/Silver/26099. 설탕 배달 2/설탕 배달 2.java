import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException {
        Scanner sc=new Scanner(System.in);
        long N=sc.nextLong();
        if(N%5==0)
            System.out.println(N/5);
        else if(N>=3 && (N-3) % 5 == 0)
            System.out.println((N-3)/5+1);
        else if(N>=6 && (N-6) % 5 == 0)
            System.out.println((N-6)/5+2);
        else if(N>=9 && (N-9) % 5 == 0)
            System.out.println((N-9)/5+3);
        else if(N>=12 && (N-12) % 5 == 0)
            System.out.println((N-12)/5+4);
        else
            System.out.println(-1);
        
        //StringTokenizer st=new StringTokenizer(br.readLine());
        //int N=Integer.parseInt(st.nextToken());
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	}
}