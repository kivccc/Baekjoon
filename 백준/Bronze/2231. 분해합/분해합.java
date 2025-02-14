import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int answer=0;
        for(int i=1;i<N;i++){
            int val=0;
            val+=i;
            int tmp=i;
            while(tmp!=0){
                val+=tmp%10;
                tmp=tmp/10;
            }
            if(val==N){
                answer=i;
                break;
            }
        }
        System.out.println(answer);
        
	}
}