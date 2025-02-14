import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        // 2~ 7 5 -> 2 2+5
        // 8~19 11-> 8 8+5+6
        //20~37 17->20 20+5+6+6
        //38~61 23->36 38+5+6+6+6
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st=new StringTokenizer(br.readLine());
        //int N=Integer.parseInt(st.nextToken());
        
        if(N==1)
            System.out.println(1);
        else{
            int answer=1;
            int val=2;
            for(;;answer++){
                if(val<= N && N <=val+6*answer-1){
                    System.out.println(answer+1);
                    break;
                }
                else
                    val=val+6*answer;
            }
        }
        
	}
}