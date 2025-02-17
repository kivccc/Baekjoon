import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int big=N/5;
        boolean flag=false;
        for(int a=big;a>=0;a--){
            if((N-a*5)%3==0){
                System.out.println(a+(N-a*5)/3);
                flag=true;
                break;                
            }
        }
        if(!flag)
            System.out.println(-1);
	}
}