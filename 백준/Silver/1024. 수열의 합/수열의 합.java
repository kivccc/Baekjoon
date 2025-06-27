import java.util.*;
import java.io.*;
public class Main {
    public static StringBuilder sb=new StringBuilder();
	public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int l=Integer.parseInt(st.nextToken());
        while(true){
            int min=n/l-(l-1)/2;
            if (min<0 || l>100) {
                System.out.println(-1);
                break;
            }
            int sum=l*(2*min+(l-1))/2;
            if(sum==n){
                printanswer(min,l);
                break;
            }
            l++;
        }
	}
    public static void printanswer(int start,int len){
        for(int i=start;i<start+len;i++)
            sb.append(i).append(" ");
        System.out.println(sb);
        return;
    }
}