import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException {
        Scanner sc=new Scanner(System.in);
        int L=sc.nextInt();
        sc.nextLine();
        String str=sc.nextLine();        
        int answer=0;
        int idx=0;
        for(char c:str.toCharArray()){
            int val=c-'a'+1;
            for(int i=0;i<idx;i++){
                val=(val * 31)%1234567891;
            }
            idx++;
            answer+=val;
        }
        System.out.println(answer);
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st=new StringTokenizer(br.readLine());
        //int N=Integer.parseInt(st.nextToken());
	}
}