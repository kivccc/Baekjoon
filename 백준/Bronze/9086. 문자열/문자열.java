import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException {
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();
        sc.nextLine();
        for(int i=0;i<T;i++){
            String word=sc.nextLine();
            if(word.length()!=1)
                System.out.println(""+word.charAt(0)+word.charAt(word.length()-1));
            else
                System.out.println(""+word.charAt(0)+word.charAt(0));
        }
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st=new StringTokenizer(br.readLine());
        //int N=Integer.parseInt(st.nextToken());
	}
}