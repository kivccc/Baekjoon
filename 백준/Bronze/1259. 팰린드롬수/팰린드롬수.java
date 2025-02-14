import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException {
        Scanner sc=new Scanner(System.in);
        StringBuilder sb=new StringBuilder("");
        String str="";
        while(true){
            str=sc.nextLine();
            if(str.equals("0"))
                break;
            sb.append(str);
            if(str.equals(sb.reverse().toString()))
                System.out.println("yes");
            else
                System.out.println("no"); 
            sb.setLength(0);
        }
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st=new StringTokenizer(br.readLine());
        //int N=Integer.parseInt(st.nextToken());
	}
}